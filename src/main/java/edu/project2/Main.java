package edu.project2;

import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        int rows = command.nextInt();
        int cols = command.nextInt();
        Maze maze = new Maze(rows, cols);
        maze.printMaze();
    }
}
