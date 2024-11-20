package questions.question8;

import questions.UtilityClass;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Question8 {
    static Queue<Block> stock = new ArrayDeque<>();
    static Map<String, Queue<Block>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("STOCK SIMULATOR");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = new String[5];
        options[0] = "Buy stock";
        options[1] = "Sell stock";
        options[2] = "Stock symbol";
        options[3] = "Stock price";
        options[4] = "Quit application";

        System.out.println("Please choose one of the following (1-5)");
        UtilityClass.menuOptions(options);

        int choice = UtilityClass.validateRange(1, 5);

        menu(choice);
    }

    public static void menu(int choice) {
        if(choice == 1) {
            System.out.println("Buy stock");
        }
        else if(choice == 2) {
            System.out.println("Sell stock");
        }
        else if(choice == 3) {
            System.out.println("Stock symbol");
        }
        else if(choice == 4) {
            System.out.println("Stock price");
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye");
        }
    }
}
