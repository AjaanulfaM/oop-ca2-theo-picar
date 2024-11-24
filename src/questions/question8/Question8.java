package questions.question8;

import questions.UtilityClass;

import java.util.*;

public class Question8 {
    static Map<String, Queue<Block>> companyStocks = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("STOCK SIMULATOR");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = new String[4];
        options[0] = "Buy stock";
        options[1] = "Sell stock";
        options[2] = "View current stocks";
        options[3] = "Quit application";

        System.out.println("Please choose one of the following (1-4)");
        UtilityClass.menuOptions(options);

        int choice = UtilityClass.validateRange(1, 4);

        if(choice == 1) {
            buyStockOption();
        }
        else if(choice == 2) {
            System.out.println("Sell stock");
        }
        else if(choice == 3) {
            System.out.println("View stocks");
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye");
        }
    }

    public static void buyStockOption() {
        Queue<Block> buyStockQueue = new ArrayDeque<>();

        String symbol;
        int quantity;
        double buyPrice;

        System.out.println("Enter name of stock company symbol:");
        symbol = scanner.next();

        System.out.println("Enter the shares this stock has:");
        quantity = scanner.nextInt();

        System.out.println("Enter the price of this stock:");
        buyPrice = scanner.nextDouble();

        buyStockQueue.add(new Block(quantity, buyPrice));
        companyStocks.put(symbol, buyStockQueue);

        System.out.println(symbol+ " with " +quantity+ " shares has successfully been bought for €" +buyPrice+ ".\n");
        menuOptions();
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
