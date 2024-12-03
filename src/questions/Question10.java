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
        int row = 3;
        int column = 4;

        // Manually give starting position in maze and push it to stack
        position.push(new int[]{row, column});

        // Push all possible paths from the starting position
        String N = "up", E = "right", S = "down", W = "left";
        direction.push(N);
        direction.push(E);
        direction.push(S);
        direction.push(W);

        boolean exitFound = false;
        while(!exitFound) {
            if(direction.pop().equals("up")) {
                row--;
            }
            else if(direction.pop().equals("right")) {
                column++;
            }
            else if(direction.pop().equals("down")) {
                row++;
            }
            else {
                column--;
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
