package edu.project2;

import java.util.Random;
import java.util.Stack;

public class Maze {
    private int size;
    private int[][] maze;
    private final static int START_POSITION = 1;
    private final static int DISTANCE = 2;
    private final static int NOT_CHECKED = 2;
    private final static int PASSAGE = 0;


    public Maze(int size) {
        this.size = size;
        this.maze = new int[size][size];
        genMaze();
    }

    public int[][] getMaze() {
        return maze;
    }

    public void genMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    maze[i][j] = 2;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
    }

    public void genMaze() {
        genMatrix();
        Position prevPosition;
        int noVisitCount = (size / 2) * (size / 2);
        Stack<Position> stack = new Stack<>();
        FindNeighbours find = new FindNeighbours();
        Position currPosition = new Position(START_POSITION, START_POSITION);
        maze[currPosition.getY()][currPosition.getX()] = PASSAGE;
        stack.push(currPosition);
        noVisitCount--;
        Random rnd = new Random();
        var neighbours = find.findNeighbours(currPosition, DISTANCE, maze, NOT_CHECKED);

        while (noVisitCount > 0) {
            while (neighbours.isEmpty()) {
                currPosition = stack.pop();
                neighbours = find.findNeighbours(currPosition, DISTANCE, maze, NOT_CHECKED);
            }
            prevPosition = currPosition;
            currPosition = neighbours.get(rnd.nextInt(neighbours.size()));
            maze[currPosition.getY()][currPosition.getX()] = PASSAGE;
            maze[(currPosition.getY() + prevPosition.getY()) / 2]
                [(currPosition.getX() + prevPosition.getX()) / 2] = PASSAGE;
            stack.push(currPosition);
            noVisitCount--;
            neighbours = find.findNeighbours(currPosition, DISTANCE, maze, NOT_CHECKED);
        }
    }
}
