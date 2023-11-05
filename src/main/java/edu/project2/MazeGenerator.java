package edu.project2;

import java.util.*;

public class MazeGenerator {
    private int rows;
    private int cols;
    private int[][] maze;
    private boolean[][] visited;
    private Random random;

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        this.visited = new boolean[rows][cols];
        this.random = new Random();
    }

    public void generateMaze() {
        // Initialize maze with walls
        for (int[] row : maze) {
            Arrays.fill(row, 1);
        }

        // Start DFS from a random cell
        int startRow = random.nextInt(rows);
        int startCol = random.nextInt(cols);
        dfs(startRow, startCol);
    }

    private void dfs(int row, int col) {
        visited[row][col] = true;
        maze[row][col] = 0; // Set current cell as passage

        // Randomly shuffle the directions
        List<Integer> directions = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(directions, random);

        // Visit neighboring cells in random order
        for (int direction : directions) {
            int newRow = row + dx[direction];
            int newCol = col + dy[direction];

            // Check if neighboring cell is within bounds and not visited
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                // Remove wall between current cell and neighboring cell
                switch (direction) {
                    case (0) -> maze[row][col + 1] = 0;
                    case (1) -> maze[row][col - 1] = 0;
                    case (2) -> maze[row + 1][col] = 0;
                    default -> maze[row - 1][col] = 0;
                }

                // Recursive call to visit the neighboring cell
                dfs(newRow, newCol);
            }
        }
    }

    public void displayMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 1) {
                    System.out.print(1);// Wall
                } else {
                    System.out.print(0); // Passage
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 11;
        int cols = 11;
        MazeGenerator mazeGenerator = new MazeGenerator(rows, cols);
        mazeGenerator.generateMaze();
        mazeGenerator.displayMaze();

    }
}
