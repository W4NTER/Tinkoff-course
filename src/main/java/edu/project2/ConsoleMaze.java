package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConsoleMaze {
    private final static int WALL = 1;
    private final static int PATH = 3;
    private final static int PASSAGE = 1;

    private ConsoleMaze() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    private final static int SIZE = 33;

    public static void run() {
        Position start = new Position(1, 1);
        Position end = new Position(SIZE - 2, SIZE - 2);
        int[][] labyrinth = new Solver().solve(new Maze(SIZE), start, end);
        printMaze(labyrinth);
    }

    public static void printMaze(int[][] maze) {
        StringBuilder output = new StringBuilder("\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (maze[i][j] == WALL) {
                    output.append("██");
                } else if (maze[i][j] == PASSAGE || maze[i][j] == PATH) {
                    output.append("  ");
                } else {
                    output.append("**");
                }
            }
            output.append("\n");
        }
        LOGGER.info(output);
    }
}
