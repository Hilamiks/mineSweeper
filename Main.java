package minesweeper;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //creates an empty field
        Field.createGameField();
        //creates mines
        System.out.println("How many mines do you want on the field?");
        Mines.quantity = scanner.nextInt();
        Mines.createMineCoords();
        Field.printField();
        playTheGame();
    }

    private static void playTheGame() {
        //note that x and y are inverted...
        // (y is actually x, and x is actually y)
        //yes, it's bad, but it was easier to just swap them after I noticed the mistake
        boolean running = true;
        int turns = 0;
        while (running) {
            //play the game

            //makes the field easier for the program to work with (invisible to the user)
            Flags.hideFlags();
            Mines.showMines();

            ScoreKeeper.score = 0;
            System.out.println("Set/unset mines marks or claim a cell as free: ");
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String action = scanner.nextLine();
            y = y - 1;
            x = x - 1;
            if (action.contains("mine")) {
                Mines.hideMines();
                if (Field.field[x][y] != '.' && Field.field[x][y] != 'X') {
                    System.out.println("The field has already been checked!");
                    continue;
                } else {
                    Flags.showFlags();
                    if (Field.field[x][y] == '*') {
                        Flags.removeFlag(x,y);
                    } else if (Field.field[x][y] == '.'){
                        Flags.addFlag(x,y);
                    }
                    Flags.hideFlags();
                }
                Mines.showMines();
            } else if (action.contains("free")) {
                turns++;
                if (Field.field[x][y] == '.'){
                    explore(x, y);
                } else if (Field.field[x][y] == 'X' && turns == 1) {
                    while (Field.field[x][y] == 'X') {
                        Mines.hideMines();
                        Mines.createMineCoords();
                        Field.createGameField();
                        Mines.showMines();
                    }
                    explore(x, y);
                } else if (Field.field[x][y] == 'X') {
                    Field.printField();
                    System.out.println("You stepped on a mine and failed!");
                    break;
                }
            }
            Mines.hideMines();
            Flags.showFlags();
            running = !ScoreKeeper.youWin();
            Field.printField();
            if (!running) {
                System.out.println("Congratulations! You found all the mines!");
            }
        }
    }

    private static void explore(int x, int y) {
        Field.fillMineNumbers(x, y);
        if (Field.field[x][y] == '.') {
            Field.field[x][y] = '/';

            for (int c = 0; c < Flags.flagsX.size(); c++) {
                if (Flags.flagsX.get(c) == x && Flags.flagsY.get(c) == y) {
                    Flags.removeFlag(x, y);
                }
            }

            if (x < Field.fieldX-1) explore(x + 1, y);
            if (x > 0) explore(x - 1, y);
            if (y < Field.fieldY-1) explore(x, y + 1);
            if (y > 0) explore(x, y - 1);
            if (x < Field.fieldX-1 && y < Field.fieldY-1) explore(x + 1, y + 1);
            if (x > 0 && y < Field.fieldY-1) explore(x - 1, y + 1);
            if (x < Field.fieldX-1 && y > 0) explore(x + 1, y - 1);
            if (x > 0 && y > 0)explore(x - 1, y - 1);
        }
    }
}
