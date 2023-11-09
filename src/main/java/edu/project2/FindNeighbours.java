package edu.project2;

import java.util.ArrayList;
import java.util.List;

public class FindNeighbours implements Neighbors {
    @Override
    public List<Position> findNeighbours(Position position, int distance, int[][] maze, int notChecked) {
        List<Position> res = new ArrayList<>();
        if (position.getX() > distance
            && maze[position.getY()][position.getX() - distance] == notChecked) {
            res.add(new Position(position.getX() - distance, position.getY()));
        }
        if (position.getY() > distance
            && maze[position.getY() - distance][position.getX()] == notChecked) {
            res.add(new Position(position.getX(), position.getY() - distance));
        }
        if (position.getX() < maze[0].length - distance
            && maze[position.getY()][position.getX() + distance] == notChecked) {
            res.add(new Position(position.getX() + distance, position.getY()));
        }
        if (position.getY() < maze.length - distance
            && maze[position.getY() + distance][position.getX()] == notChecked) {
            res.add(new Position(position.getX(), position.getY() + distance));
        }
        return res;
    }
}
