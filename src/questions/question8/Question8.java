package questions.question8;

import questions.UtilityClass;

import java.util.*;

public class Question8 {
    static Map<String, Queue<Block>> companyStocks = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static String symbolPattern = "^[A-Z0-9]{3,5}$";

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
            sellStockOption();
        }
        else if(choice == 3) {
            System.out.println("View stocks");
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye");
        }
    }

    public static void buyStockOption() {
        String symbol;
        int quantity;
        double buyPrice;

        System.out.println("Enter name of stock company symbol:");
        symbol = UtilityClass.validatePattern(symbolPattern, "Must only contain uppercase letters, numbers, no more than 5 characters and at least 3 characters");

        Queue<Block> buyStockQueue = companyStocks.get(symbol);
        if (buyStockQueue == null) {
            buyStockQueue = new ArrayDeque<>();
        }
        else {
            System.out.println("You have already bought this company. Ending buy session...");
            menuOptions();
        }

        System.out.println("Enter the shares this stock has:");
        quantity = UtilityClass.validateInt();

        System.out.println("Enter the price of this stock (rounded up to 2 decimal places):");
        buyPrice = UtilityClass.validateDouble(2);

        buyStockQueue.add(new Block(quantity, buyPrice));
        companyStocks.put(symbol, buyStockQueue);

        System.out.println("'" +symbol+ "' with " +quantity+ " shares has successfully been bought for €" +buyPrice+ ".\n");
        menuOptions();
    }

    public static void sellStockOption() {
        String symbol;
        int sellAmount;

        System.out.println("Enter the stock company would you like to sell:");
        symbol = UtilityClass.validatePattern(symbolPattern, "Must only contain uppercase letters, numbers, no more than 5 characters and at least 3 characters");

        Queue<Block> sellStockQueue = companyStocks.get(symbol);

        if (sellStockQueue == null) {
            System.out.println("You have not bought this company yet. Ending sell session...\n");
            menuOptions();
        }

        Block blockToSell = sellStockQueue.peek();

        System.out.println("Enter how many shares you want to sell for this stock:");
        sellAmount = UtilityClass.validateInt();

        if(sellAmount > blockToSell.getQuantity()) {
            System.out.println("Unsuccessful.Can't sell more shares than you have. Ending sell session...\n");
            menuOptions();
        }

        blockToSell.sell(sellAmount);

        System.out.println("Successfully sold " +sellAmount+ " shares from " +symbol+ ".\n");
        menuOptions();
    }
}
