package questions;

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
            int[][] maze = createMaze();

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
        else {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
    }

    public static void mazeMenu() {
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

}
