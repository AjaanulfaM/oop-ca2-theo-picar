package questions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Theo Picar
 *  Class Group: SD2A
 */

public class Question6 { // Flight take-off (Queue)
    static Scanner scanner = new Scanner(System.in);

    static Queue<String> forTakeoff = new ArrayDeque<String>();
    static Queue<String> forLanding = new ArrayDeque<String>();

    public static void main(String[] args) {
//        An airport has only one runway. When it is busy, planes wishing to take off or land have to
//        wait. Implement a simulation, using two queues, one each for the planes waiting to take off
//        and land. Landing planes get priority.
//        The user enters commands:
//                > takeoff flightCode
//                > land flightCode
//                > next
//                > quit

//        The first two commands place the flight in the appropriate queue. The next command
//        finishes the current take-off or landing and enables the next one, printing the action (take
//        off or land) and the flight symbol.
//        For example:
    //        takeoff( “Flight-100”); // is queued for ‘take off’
    //        takeoff(“Flight-220”); // is queued
    //        land(“Flight-320”); // is queued for landing
    //        takeoff(“Flight-EI104”); // queued for takeoff
    //        next(); // will complete landing of the landing of Flight-320
    //        next(); // will complete takeoff of Flight-100

        menuOptions();
    }

    public static void menuOptions() {
        System.out.println("\nFLIGHT TAKE-OFF SIMULATOR\n" +
                "Choose one of the options (1-4)\n" +
                "1. Queue takeoff\n" +
                "2. Queue landing\n" +
                "3. Queue next flight\n" +
                "4. View flights\n" +
                "5. End application");
        int choice = validateRange(1, 5);

        menu(choice);
    }

    public static void menu(int choice) {
        String flightCode = "";

        if(choice == 1) {
            System.out.println("(Press 'q' to exit) Enter only the flight codes below:");

            while (!flightCode.equals("q")) {
                flightCode = validateFlightCode();

                if (!flightCode.equals("q")) {
                    forTakeoff.add("Flight-" +flightCode);
                    System.out.println(flightCode+ " in queue for takeoff");
                }
            }

            System.out.println("Ending...");
            menuOptions();
        }
        else if(choice == 2) {
            System.out.println("(Press 'q' to exit) Enter only the flight codes below:");

            while (!flightCode.equals("q")) {
                flightCode = validateFlightCode();

                if (!flightCode.equals("q")) {
                    forLanding.add("Flight-" +flightCode);
                    System.out.println(flightCode+ " in queue for landing");
                }
            }

            System.out.println("Ending...");
            
            menuOptions();
        }
        else if(choice == 3) {
            System.out.println("Flight 1 has now landed. Flight 2 is now taking off. Flight 3 is preparing for takeoff:");
        }
        else if(choice == 4) {
            System.out.println("Flights queued for landing:");
            displayFlights(forLanding);

            System.out.println("Flights queued for take-off");
            displayFlights(forTakeoff);

            menuOptions();
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye!");
        }
    }

    public static String validateFlightCode() {
        String code = "";
        boolean done = false;
        String pattern = "^[A-Z0-9]{3,6}$";

        while(!done) {
            code = scanner.next();

            if(code.matches(pattern)) {
                done = true;
            }
            else if(code.equals("q")) {
                done = true;
            }
            else {
                System.out.println("Invalid flight code. Please try again");
            }
        }

        return code;
    }

    public static void displayFlights(Queue<String> queue) {
        int counter = 0;

        if(!queue.isEmpty()) {
            System.out.print("[");
            for (String flight : queue) {
                counter++;

                if (counter != queue.size()) {
                    System.out.print(flight + ", ");
                } else {
                    System.out.println(flight + "]");
                }
            }
        }
        else {
            System.out.println("There are currently no flights");
        }
    }

    public static int validateRange(int min, int max) {
        int input = 0;
        boolean done = false;

        while(!done) {
            if(scanner.hasNextInt()) {
                input = scanner.nextInt();

                if(input < min || input > max) {
                    System.out.println("Please enter a valid option (1-2)");
                }
                else {
                    done = true;
                }
            }
            else {
                System.out.println("Please enter only integer values");
                scanner.next();
            }
        }

        return input;
    }
}
