package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private final static Logger LOGGER = LogManager.getLogger();
    private int rows;
    private int cols;
    private int[][] maze;
    private final static int START_POSITION = 1;

    public Maze(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        this.maze = new int[rows][cols];
        genMaze();
    }

    public int[][] getMaze() {
        return maze;
    }

    public void genMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
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
        int noVisitCount = (rows / 2) * (cols / 2);
        Stack<Position> stack = new Stack<>();
        Position currPosition = new Position(START_POSITION, START_POSITION);
        maze[currPosition.getY()][currPosition.getX()] = 0;
        stack.push(currPosition);
        noVisitCount--;
        Random rnd = new Random();
        var neighbours = findNeighbours(currPosition);

        while (noVisitCount > 0) {
            while (neighbours.size() == 0) {
                currPosition = stack.pop();
                neighbours = findNeighbours(currPosition);
            }
            prevPosition = currPosition;
            currPosition = neighbours.get(rnd.nextInt(neighbours.size()));
            maze[currPosition.getY()][currPosition.getX()] = 0;
            maze[(currPosition.getY() + prevPosition.getY()) / 2][(currPosition.getX() + prevPosition.getX()) / 2] = 0;
            stack.push(currPosition);
            noVisitCount--;
            neighbours = findNeighbours(currPosition);
        }
    }

    public List<Position> findNeighbours(Position position) {
        List<Position> res = new ArrayList<>();
        if (position.getX() > 2 && maze[position.getY()][position.getX() - 2] == 2) {
            res.add(new Position(position.getX() - 2, position.getY()));
        }
        if (position.getY() > 2 && maze[position.getY() - 2][position.getX()] == 2) {
            res.add(new Position(position.getX(), position.getY() - 2));
        }
        if (position.getX() < maze[0].length - 2 && maze[position.getY()][position.getX() + 2] == 2) {
            res.add(new Position(position.getX() + 2, position.getY()));
        }
        if (position.getY() < maze.length - 2 && maze[position.getY() + 2][position.getX()] == 2) {
            res.add(new Position(position.getX(), position.getY() + 2));
        }
        return res;
    }

    public void printMaze() {
//        Arrays.stream(maze).map(Arrays::toString).forEach(System.out::println);
//        Logger LOGGER = LogManager.getLogger();
        StringBuilder output = new StringBuilder("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 1) {
                    output.append("█ ");
                } else {
                    output.append("  ");
                }
            }
            output.append("\n");
        }
        LOGGER.info(output);
    }



}
