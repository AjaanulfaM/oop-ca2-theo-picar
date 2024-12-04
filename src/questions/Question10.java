package questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question10 {
    public static void main(String[] args) {
        System.out.println("BACKTRACKING ALGORITHM");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = {
                "Start Navigating",
                "View Maze",
                "Quit application",
        };
        UtilityClass.menuOptions(options);

        System.out.println("Choose one of the above options (1-3)");
        int choice = UtilityClass.validateRange(1, 3);

        if(choice == 1) {
            mazeMenu();
        }
        else {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
    }

    public static void mazeMenu() {
        Deque<int[]> positions = new ArrayDeque<>();
        Deque<String> directions = new ArrayDeque<>();
        int row = 3, column = 4;
        int[][] mazePosition = createMaze();
        String N = "up", E = "right", S = "down", W = "left";

        // Push all possible paths from the starting position [3][4]
        positions.push(new int[]{row, column});
        directions.push(W);

        positions.push(new int[]{row, column});
        directions.push(N);

        positions.push(new int[]{row, column});
        directions.push(E);

        positions.push(new int[]{row, column});
        directions.push(S);

        boolean exitFound = false;
        while(!exitFound) {
            // re-assign variables every time a dead end is found
            int[] newRowAndColumn = positions.pop();
            String directionToMove = directions.pop();

            row = newRowAndColumn[0];
            column = newRowAndColumn[1];

            boolean done = false;
            if(directionToMove.equals("left")) {
                while(!done) {
                    outputMaze(row, column);
                    // move left until we hit a wall / dead end
                    if(mazePosition[row][column-1] == 0) {
                        done = true;
                    }
                    else {
                        column--;
                    }

                    // checks to see if column is equal to either max or min bound of the array. This means we found exit
                    if(column <= 0 || column >= mazePosition[0].length && !done) {
                        System.out.println("Exit found!\n");
                        done = true;
                        exitFound = true;
                    }

                    // as we're moving along, check if there are any paths along the way
                    if(mazePosition[row-1][column] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(W);
                    }
                    if(mazePosition[row+1][column] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(E);
                    }
                }
            }
            else if(directionToMove.equals("right")) {
                while(!done) {
                    outputMaze(row, column);
                    // move right until we hit a wall / dead end
                    if(mazePosition[row][column+1] == 0) {
                        done = true;
                    }
                    else {
                        column++;
                    }

                    // checks to see if column is equal to either max or min bound of the array. This means we found exit
                    if(column <= 0 || column >= mazePosition[0].length && !done) {
                        System.out.println("Exit found!\n");
                        done = true;
                        exitFound = true;
                    }

                    // as we're moving along, check if there are any paths along the way
                    if(mazePosition[row-1][column] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(W);
                    }
                    if(mazePosition[row+1][column] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(E);
                    }
                }
            }
            else if(directionToMove.equals("down")) {
                while(!done) {
                    outputMaze(row, column);
                    // move down until we hit a wall / dead end
                    if(mazePosition[row+1][column] == 0) {
                        done = true;
                    }
                    else {
                        row++;
                    }

                    // checks to see if row is equal to either max or min bound of the array. This means we found exit
                    if(row < 0 || row >= mazePosition.length && !done) {
                        System.out.println("Exit found!\n");
                        done = true;
                        exitFound = true;
                    }

                    // as we're moving along, check if there are any paths along the way
                    if(mazePosition[row][column-1] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(W);
                    }
                    if(mazePosition[row][column+1] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(E);
                    }
                }
            }
            else {
                while(!done) {
                    outputMaze(row, column);
                    // move up until we hit a wall / dead end
                    if(mazePosition[row-1][column] == 0) {
                        done = true;
                    }
                    else {
                        row--;
                    }

                    // checks to see if row is equal to either max or min bound of the array. This means we found exit
                    if(row <= 0 || row >= mazePosition.length && !done) {
                        System.out.println("Exit found!\n");
                        done = true;
                        exitFound = true;
                    }

                    // as we're moving along, check if there are any paths along the way
                    if(mazePosition[row][column-1] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(W);
                    }
                    if(mazePosition[row][column+1] == 1) {
                        positions.push(new int[] {row, column});
                        directions.push(E);
                    }
                }
            }
        }

        menuOptions();
    }

//    public static void checkValidPaths(String direction, int row, int column, int[][] mazePosition) {
//
//    }

    public static int[][] createMaze() {
        return new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    // parameters act as a way to keep track where the user is moving
    public static void outputMaze(int startingRow, int startingColumn) {
        int[][] maze = createMaze();

        for(int i = 0; i < maze.length; i++) {
            if(i != 0)  {
                System.out.println();
            }

            for(int j = 0; j < maze.length; j++) {
                // wall
                if(maze[i][j] == 0) {
                    System.out.print("[]");
                }
                else if(i == startingRow && j == startingColumn) {
                    System.out.print("<>");
                }
                // path (two spaces so it formats correctly on terminal)
                else {
                    System.out.print("  ");
                }
            }
        }

        System.out.println("\n");
    }

}
