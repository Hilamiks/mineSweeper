package minesweeper;

import java.util.Arrays;

public class Field {
    static int fieldX = 9;

    static int fieldY = 9;

    static char[][] field = new char[fieldX][fieldY];

    static void createGameField() {
        for(int i = 0; i < field.length; i++){
            Arrays.fill(field[i], '.');
        }
    }

    static void printField() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for(int i = 0; i < field.length; i++){
            System.out.print((1+i)+"|");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println("-|---------|");
    }

    static void fillMineNumbers(int i, int j) {
        //for (int i = 0; i < field.length; i++){
        //for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] == '.') {
            int counter = 0;
            if (i == 0) {
                if (j == 0) {
                    //top left corner
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j + 1] == 'X') {
                        counter++;
                    }
                } else if (j == field[i].length - 1) {
                    //top right corner
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j - 1] == 'X') {
                        counter++;
                    }
                } else {
                    //top side
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j - 1] == 'X') {
                        counter++;
                    }
                }
            } else if (i == field.length - 1) {
                if (j == 0) {
                    //bottom left corner
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j + 1] == 'X') {
                        counter++;
                    }
                } else if (j == field[i].length - 1) {
                    //bottom right corner
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j - 1] == 'X') {
                        counter++;
                    }
                } else {
                    //bottom side
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j - 1] == 'X') {
                        counter++;
                    }
                }
            } else {
                if (j == 0) {
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                } else if (j == field[i].length - 1) {
                    //right side
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                } else {
                    //middle
                    if (field[i + 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j + 1] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j] == 'X') {
                        counter++;
                    }
                    if (field[i - 1][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i][j - 1] == 'X') {
                        counter++;
                    }
                    if (field[i + 1][j - 1] == 'X') {
                        counter++;
                    }
                }
            }
            if (counter != 0) {
                Flags.removeFlag(i, j);
                field[i][j] = Integer.toString(counter).charAt(0);
            }
        }
        //}
        //}
    }
}
