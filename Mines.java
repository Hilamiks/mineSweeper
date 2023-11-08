package minesweeper;

public class Mines {
    static int[] xPositions;

    static int[] yPositions;

    static int quantity;

    static void generateMine(int i) {
        xPositions[i] = (int)(Math.random()*Field.fieldX);
        yPositions[i] = (int)(Math.random()*Field.fieldY);
    }

    static void createMineCoords() {
        xPositions = new int[quantity];
        yPositions = new int[quantity];
        for(int i = 0; i < quantity; i ++) {
            generateMine(i);
            for (int j = 0; j < i; j ++) {
                if (xPositions[j] == xPositions[i] && yPositions[j] == yPositions[i]) {
                    generateMine(i);
                    j = -1;
                }
            }
        }
    }

    static void hideMines() {
        for(int i = 0; i < quantity; i++) {
            if (Field.field[xPositions[i]][yPositions[i]] != '*') {
                Field.field[xPositions[i]][yPositions[i]] = '.';
            }
        }
    }

    static void showMines() {
        for(int i = 0; i < quantity; i++) {
            Field.field[xPositions[i]][yPositions[i]] = 'X';
        }
    }
}
