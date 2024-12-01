package questions.question7and8;

// Example scenario because I keep forgetting what I am meant to do:
// Bought one block of 100 shares for €20, bought a second block for another 100 at €10
// User wants to sell 175 blocks for €30
// Formula: Gain = (Sell price - Buy price) * Quantity
// So take 100 shares from first block: (30-20) * 100 = €1000
// Take remaining 75 shares from second block: (30-10) * 75 = €750
// Total gain = €1750

import questions.UtilityClass;

import java.util.*;

public class Question7 {

    static Queue<Block> boughtShares = new ArrayDeque<>();

    public static void main(String[] args) {
        System.out.println("STOCK SIMULATOR");
        menuOptions();
    }

    public static void menuOptions() {
        String[] options = new String[4];
        options[0] = "Buy shares";
        options[1] = "Sell shares";
        options[2] = "View shares";
        options[3] = "Quit application";

        UtilityClass.menuOptions(options);
        int choice = UtilityClass.validateRange(1,4);

        if(choice == 1) {
            buyMenu();
        }
        else if(choice == 2) {
            sellMenu();
        }
        else if(choice == 3) {
            displayAllBlocks();
        }
        else {
            System.out.println("Ending session...\nDone! Goodbye.");
        }
    }

    public static void buyMenu() {
        System.out.println("Enter amount of shares you would like to buy below:");
        int sharesToBuy = UtilityClass.validateInt();

        System.out.println("Enter the price for these shares (rounded up):");
        int buyPrice = UtilityClass.validateInt();

        // add the new block to the queue with the given shares and price
        boughtShares.add(new Block(sharesToBuy, buyPrice));

        System.out.println(sharesToBuy+ " shares successfully bought for €" +buyPrice+ "! Returning to main menu...\n");
        menuOptions();
    }

    public static void sellMenu() {
        System.out.println("Enter amount of shares you would like to sell below:");
        int sharesToSell = UtilityClass.validateInt();
        // look at while loop to see what this is for
        int copyOfSharesToSell = sharesToSell;

        System.out.println("Enter the sell price for these shares (rounded up):");
        int sellPrice = UtilityClass.validateInt();

        int gain = 0, blocksSoldOut = 0;
        while(sharesToSell > 0 && !boughtShares.isEmpty()) {
            Block currentBlock = boughtShares.peek();
            int sharesInCurrentBlock = currentBlock.getQuantity();

            // will not continue with selling rest of sharesToSell if quantity of currentBlock is less than shares left to sell (sharesToSell)
            if(boughtShares.size() == 1 && currentBlock.getQuantity() < sharesToSell) {
                System.out.println("Cannot sell remaining " +sharesToSell+ " share(s) but managed to sell " +(copyOfSharesToSell - sharesToSell)+ " shares.");
                break;
            }

            // if sharesToSell < sharesInCurrentBlock, sell that. Otherwise, sell amount will be sharesInCurrentBlock
            int availableSharesToSell = Math.min(sharesToSell, sharesInCurrentBlock);

            gain += (sellPrice - currentBlock.getPrice()) * availableSharesToSell;

            // reduce the quantity of chosen block within Block class
            currentBlock.sellShares(availableSharesToSell);
            // reduce the share by the amount the user is able to sell for the current block
            sharesToSell -= availableSharesToSell;

            // remove the currentBlock if its share count is now 0
            if(currentBlock.getQuantity() == 0) {
                boughtShares.remove();
                blocksSoldOut++;
            }
        }

        if(gain > 0) {
            System.out.println("Gained total of €" + gain + " from shares and have fully sold out " +blocksSoldOut+ " block(s). Returning to main menu...\n");
        }
        else {
            System.out.println("No profit gained from selling these stocks and have fully sold out " +blocksSoldOut+ " block(s). Returning to main menu...\n");
        }

        menuOptions();
    }

    public static void displayAllBlocks() {

        if(!boughtShares.isEmpty()) {
            int blockID = 0;
            
            for (Block block : boughtShares) {
                blockID++;
                System.out.println("Block " +blockID+ ":\n|| " + block.getQuantity() + " shares for €" + block.getPrice() + " ||");
            }
        }
        else {
            System.out.println("No stocks have been bought yet or all stocks sold!");
        }

        System.out.println();
        menuOptions();
    }
}
