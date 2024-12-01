package questions.question7and8;

// Example scenario because I keep forgetting what I am meant to do:
// Bought one block of 100 shares for €20, bought a second block for another 100 at €10
// User wants to sell 175 blocks for €30
// Formula: Gain = (Sell price - Buy price) * Quantity
// So take 100 shares from first block: (30-20) * 100 = €1000
// Take remaining 75 shares from second block: (30-10) * 75 = €750
// Total gain = €1750

import questions.UtilityClass;

import java.util.Scanner;

public class Question7 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("STOCK SIMULATOR");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = new String[3];
        options[0] = "Buy shares";
        options[1] = "Sell shares";
        options[2] = "Quit application";

        UtilityClass.menuOptions(options);
        int choice = UtilityClass.validateRange(1, 3);

        if(choice == 1) {
            buyMenu();
        }
        else if(choice == 2) {
            sellMenu();
        }
        else {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
    }

    public static void buyMenu() {
        System.out.println("Buy menu...");
        menuOptions();
    }

    public static void sellMenu() {
        System.out.println("Sell menu...");
        menuOptions();
    }
}
