package questions;

public class Question10 {
    public static void main(String[] args) {
        System.out.println("BACKTRACKING ALGORITHM");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = {
                "Maze 1 - Easy",
                "Maze 2 - Medium",
                "Maze 3 - Hard",
                "Quit application",
        };
        UtilityClass.menuOptions(options);

        System.out.println("Choose one of the above options (1-4)");
        int choice = UtilityClass.validateRange(1, 4);

        if(choice == 4) {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
        else {
            mazeMenu(choice);
        }
    }

    public static void mazeMenu(int level) {
        int[][] maze = createMaze(level);

        for(int i = 0; i < maze.length; i++) {
            System.out.println();

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

        System.out.println("\n");
        menuOptions();
    }

    public static int[][] createMaze(int level) {
        if(level == 1) {
            return new int[][] {
                    {0, 0, 0, 0, 0},
                    {1, 1, 1, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0}
            };
        }
        else if(level == 2) {
            return new int[][] {
                    {0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 0},
                    {0, 1, 1, 1, 0, 1, 0},
                    {0, 1, 0, 0, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 1, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0},
            };
        }
        else {
            return new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 1, 1, 1, 1, 1, 0, 1, 0, 0},
                    {0, 0, 1, 0, 0, 1, 0, 1, 1, 0},
                    {0, 0, 1, 0, 1, 1, 0, 0, 1, 0},
                    {0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
                    {0, 0, 1, 1, 1, 1, 0, 0, 1, 0},
                    {0, 0, 1, 0, 0, 1, 0, 1, 1, 0},
                    {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
        }
    }

}
