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
        Deque<int[]> position = new ArrayDeque<>();
        Deque<String> direction = new ArrayDeque<>();
        int row = 3, column = 4;
        int[][] mazePosition = createMaze();

        // Manually give starting position in maze and push it to stack
        position.push(new int[]{row, column});

        // Push all possible paths from the starting position. (North, East, South, West)
        String N = "up", E = "right", S = "down", W = "left";
        direction.push(N);
        direction.push(E);
        direction.push(S);
        direction.push(W);

        boolean exitFound = false;
        while(!exitFound) {
            boolean done = false;

            if(direction.pop().equals("up")) {
                while(!done) {
                    row--;

                    if(mazePosition[row][column] == 0) {
                        done = true;
                    }
                    // check if there is a left path on current position
                    if(mazePosition[row][column - 1] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(W);
                    }
                    // check if there is a right path on current position
                    if(mazePosition[row][column + 1] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(E);
                    }
                }
            }
            else if(direction.pop().equals("right")) {
                while(!done) {
                    column++;

                    if(mazePosition[row][column] == 0) {
                        done = true;
                    }
                    // check if there is an up path on current position
                    if(mazePosition[row - 1][column] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(N);
                    }
                    // check if there is a down path on current position
                    if(mazePosition[row + 1][column] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(E);
                    }
                }
            }
            else if(direction.pop().equals("down")) {
                while(!done) {
                    row++;

                    if(mazePosition[row][column] == 0) {
                        done = true;
                    }
                    // check if there is a left path on current position
                    if(mazePosition[row][column - 1] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(W);
                    }
                    // check if there is a right path on current position
                    if(mazePosition[row][column + 1] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(E);
                    }
                }
            }
            else {
                while(!done) {
                    column--;

                    if(mazePosition[row][column] == 0) {
                        done = true;
                    }
                    // check if there is an up path on current position
                    if(mazePosition[row - 1][column] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(N);
                    }
                    // check if there is a down path on current position
                    if(mazePosition[row + 1][column] == 1) {
                        position.push(new int[]{row, column});
                        direction.push(E);
                    }
                }
            }
        }


        System.out.println("\n");
        menuOptions();
    }

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
                // path (two spaces so it formats correctly on terminal)
                else {
                    System.out.print("  ");
                }
            }
        }
    }

}
