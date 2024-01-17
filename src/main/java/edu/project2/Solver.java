package edu.project2;

import java.util.Random;
import java.util.Stack;

public class Solver implements MazeSolver {
    private final static int PATH = 3;
    private final static int DISTANCE = 1;
    private final static int PASSAGE = 0;
    private final static int WAY = 2;

    @Override
    public int[][] solve(Maze maze, Position start, Position end) {
        int[][] labyrinth = maze.getMaze();
        Stack<Position> stackPath = new Stack<>();
        FindNeighbours find = new FindNeighbours();
        Position currPosition = new Position(start.getX(), start.getY());
        Position finalPosition = new Position(end.getX(), end.getY());
        labyrinth[currPosition.getX()][currPosition.getX()] = WAY;
        stackPath.push(currPosition);
        var neighbours = find.findNeighbours(currPosition, DISTANCE, labyrinth, PASSAGE);
        Random random = new Random();
        Position prevPosition;

        while (!currPosition.getPoint().equals(finalPosition.getPoint())) {
            while (neighbours.isEmpty()) {
                currPosition = stackPath.pop();
                neighbours = find.findNeighbours(currPosition, DISTANCE, labyrinth, PASSAGE);
                prevPosition = currPosition;
                labyrinth[prevPosition.getY()][prevPosition.getX()] = PATH;
            }
            currPosition = neighbours.get(random.nextInt(neighbours.size()));
            labyrinth[currPosition.getY()][currPosition.getX()] = WAY;
            stackPath.push(currPosition);
            neighbours = find.findNeighbours(currPosition, DISTANCE, labyrinth, PASSAGE);
        }
        return labyrinth;
    }
}
