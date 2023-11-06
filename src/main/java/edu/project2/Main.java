package edu.project2;

import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        int rows = command.nextInt();
        int cols = command.nextInt();
        Maze maze = new Maze(121, 121);
        maze.printMaze();
        int startRow = command.nextInt();
        int startCol = command.nextInt();
        int desiredRow = command.nextInt();
        int desiredCol = command.nextInt();
        maze.findPath(1, 1, 119, 119);
        maze.printMaze();
    }
}
