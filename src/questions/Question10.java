package questions;

public class Question10 {
    public static void main(String[] args) {
        System.out.println("BACKTRACKING ALGORITHM");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = {
                "1. Maze 1 - Easy",
                "2. Maze 2 - Medium",
                "3. Maze 3 - Hard",
                "4. Quit application",
        };
        UtilityClass.menuOptions(options);

        System.out.println("Choose one of the above options (1-4)");
        int choice = UtilityClass.validateRange(1, 4);

        if(choice == 1) {
            mazeLevel1();
        }
        else if(choice == 2) {
            mazeLevel2();
        }
        else if(choice == 3) {
            mazeLevel3();
        }
        else {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
    }

    public static void mazeLevel1() {

    }

    public static void mazeLevel2() {

    }

    public static void mazeLevel3() {

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
                    {0, 1, 1, 1, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0}
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
