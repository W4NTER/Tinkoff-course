package edu.project2;

import java.util.List;

public interface Neighbors {
    List<Position> findNeighbours(Position position, int distance, int[][] maze, int notChecked);
}

