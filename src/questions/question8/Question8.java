package questions.question8;

import questions.UtilityClass;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Question8 {
    static Queue<Block> stock = new ArrayDeque<>();
    static Map<String, Queue<Block>> companyStocks = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("STOCK SIMULATOR");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = new String[3];
        options[0] = "Buy stock";
        options[1] = "Sell stock";
        options[2] = "Quit application";

        System.out.println("Please choose one of the following (1-3)");
        UtilityClass.menuOptions(options);

        int choice = UtilityClass.validateRange(1, 3);

        menu(choice);
    }

    public static void menu(int choice) {
        if(choice == 1) {
            System.out.println("Buy stock");
        }
        else if(choice == 2) {
            System.out.println("Sell stock");
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye");
        }
    }
}
