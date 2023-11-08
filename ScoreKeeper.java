package minesweeper;

import java.util.ArrayList;

public class ScoreKeeper {
    static int score;

    static void allMinesSelected() {
        for (int i = 0; i < Flags.flagsX.size() && i < Flags.flagsY.size(); i++){
            if (Field.field[Flags.flagsX.get(i)][Flags.flagsY.get(i)] == '*') {
                for (int j = 0; j < Mines.xPositions.length; j++) {
                    if (Mines.xPositions[j] == Flags.flagsX.get(i) && Mines.yPositions[j] == Flags.flagsY.get(i)) {
                        score++;
                    }
                }
            }
        }
    }

    static void allFreeSpacesFound() {
        ArrayList<Integer> dotsX = new ArrayList<>();
        ArrayList<Integer> dotsY = new ArrayList<>();
        for (int i = 0; i < Field.fieldX; i++) {
            for (int j = 0; j < Field.fieldY; j++) {
                if (Field.field[i][j] == '.') {
                    dotsX.add(i);
                    dotsY.add(j);
                }
            }
        }
        if ((dotsX.size() + Flags.flagsX.size()) <= Mines.quantity) {
            for (int i = 0; i < dotsX.size(); i++) {
                for (int j = 0; j < Mines.quantity; j++) {
                    if (Mines.xPositions[j] == dotsX.get(i)
                            && Mines.yPositions[j] == dotsY.get(i)){
                        score++;
                    }
                }
            }
        }
    }
    static boolean youWin() {
        allMinesSelected();
        allFreeSpacesFound();
        return score == Mines.quantity;
    }
}
