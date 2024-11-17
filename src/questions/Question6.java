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

        Queue<String> forTakeoff = new ArrayDeque<String>();
        Queue<String> forLanding = new ArrayDeque<String>();

        System.out.println("FLIGHT TAKE-OFF SIMULATOR\n" +
                            "Choose one of the options (1-4)\n" +
                            "1. Queue takeoff\n" +
                            "2. Queue landing\n" +
                            "3. Queue next flight\n" +
                            "4. Queue application");
        int choice = validateRange(1, 4);

        if(choice == 1) {
            System.out.println("Enter flight code below:");
        }
        else if(choice == 2) {
            System.out.println("Enter flight code below:");
        }
        else if(choice == 3) {
            System.out.println("Flight 1 has now landed. Flight 2 is now taking off. Flight 3 is preparing for takeoff:");
        }
        else {
            System.out.println("Ending session...\nDone. Goodbye!");
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
