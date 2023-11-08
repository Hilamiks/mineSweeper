package minesweeper;

import java.util.ArrayList;

public class Flags {

    static ArrayList<Integer> flagsX = new ArrayList<>();

    static ArrayList<Integer> flagsY = new ArrayList<>();

    static void addFlag(int x, int y) {
        flagsX.add(x);
        flagsY.add(y);
    }

    static void removeFlag(int x, int y) {
        for (int c = 0; c < flagsX.size() && c < flagsY.size(); c++) {
            if (flagsX.get(c) == x && flagsY.get(c) == y) {
                flagsX.remove(c);
                flagsY.remove(c);
            }
        }
    }

    static void hideFlags() {
        for (int i = 0; i < Field.fieldX; i++) {
            for (int j = 0; j < Field.fieldY; j++) {
                if (Field.field[i][j] == '*') {
                    Field.field[i][j] = '.';
                }
            }
        }
    }

    static void showFlags() {
        for (int i = 0; i < flagsX.size() && i < flagsY.size(); i++) {
            if (flagsX.get(i) != null && flagsY.get(i) != null) {
                Field.field[flagsX.get(i)][flagsY.get(i)] = '*';
            }
        }
    }
}
