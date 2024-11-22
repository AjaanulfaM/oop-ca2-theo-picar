package questions.question8;

import questions.UtilityClass;

import java.util.*;

public class Question8 {
    static Queue<Block> stock = new ArrayDeque<>();
    static Map<String, Queue<Block>> companyStocks = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

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

    public static void buyStockOption() {
        String symbol = "";
        int quantity = 0;
        double buyPrice = 0.0;

        System.out.println("Enter name of stock company symbol:");
        symbol = scanner.next();

        System.out.println("Enter the quantity of this stock:");
        quantity = scanner.nextInt();

        System.out.println("Enter the price of this stock:");
        buyPrice = scanner.nextDouble();
    }

    public static void sellStockOption() {
        String symbol = "";
        double sell = 0.0;

        System.out.println("Enter the stock company would you like to sell:");
        symbol = scanner.next();

        System.out.println("Enter you sell amount for this stock:");
        sell = scanner.nextDouble();
    }
}
