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
        else if(choice == 2){
            outputMaze();

            System.out.println("\n");
            menuOptions();
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
        directions.push(S);

        positions.push(new int[]{row, column});
        directions.push(E);

        positions.push(new int[]{row, column});
        directions.push(N);

        boolean exitFound = false;
        while(!exitFound) {
            int[] newRowAndColumn = positions.pop();
            String directionToMove = directions.pop();

            row = newRowAndColumn[0];
            column = newRowAndColumn[1];

            boolean done = false;
            if (directionToMove.equals("up")) {
                while(!done) {
                    // move up until we hit a wall / dead end
                    if(mazePosition[row-1][column] == 0) {
                        done = true;
                    }
                    else {
                        row--;
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


        System.out.println("\n");
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

    public static void outputMaze() {
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
                else if(i == 3 && j == 4) {
                    System.out.print("<>");
                }
                // path (two spaces so it formats correctly on terminal)
                else {
                    System.out.print("  ");
                }
            }
        }
    }

}
