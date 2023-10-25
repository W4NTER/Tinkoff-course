package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    private static final int LENGTH = 8;
    private static final int[][] MOVES = new int[][] {
        {-2, -1},
        {-1, -2},
        {-2, 1},
        {-1, 2}
    };

    public static boolean knightBoardCapture(int[][] input) {
        for (int i = 0; i < LENGTH - 1; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (input[i][j] == 1) {
                    for (int[] move : MOVES) {
                        int x = j + move[1];
                        int y = i + move[0];
                        if ((x >= 0) && (x < LENGTH) && (y >= 0) && (y < LENGTH) && (input[x][y] == 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
