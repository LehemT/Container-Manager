/**
 * Main class is the entry point for the shipping container management application.
 * It allows users to use 2 different entry methods, manual entry and RFID scanning,
 * as well as the ability to view the details of all the entered containers.
 *
 * @author Lehem Temesgen
 * @version 08/13/2024
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ShipContainer> containers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int containerIDCounter = 100; // initialize the container ID counter

        while (true) {
            // display the menu for the user & take their input
            System.out.println("Choose type of details entering method:");
            System.out.println(" M)anual container entry.\n R)FID container entry.\n P)rint shipping container's details. \n Q)uit.");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "M":
                    // create ManualContentList object & set its ID
                    ShipContainer manualContainer = new ManualContentList(containerIDCounter);
                    containerIDCounter += 1; // increment container ID counter

                    // take the user's input, set the container contents & add container to the linked list
                    System.out.print("Enter the container contents: ");
                    String manualContents = scanner.nextLine();
                    manualContainer.setContents(manualContents);
                    containers.add(manualContainer);
                    break;

                case "R":
                    // create ShippingContainerRFID object and increment containerIDCounter
                    ShipContainer rfidContainer = new ShippingContainerRFID(containerIDCounter);
                    containerIDCounter += 1;

                    while (true) {
                        // take the user's input & set the container contents
                        System.out.print("Scan an RFID (Enter the container contents): ");
                        String rfidContents = scanner.nextLine();
                        rfidContainer.setContents(rfidContents);

                        System.out.print("Would you like to scan another RFID? (Y/N): ");
                        String more = scanner.nextLine().toUpperCase();

                        switch (more) {
                            case "Y":
                                // continue scanning more RFID items
                                continue;

                            case "N":
                                // end RFID scanning & add container to the linkedlist
                                containers.add(rfidContainer);
                                break;

                            default:
                                // print error message & repeat loop if the input is invalid
                                System.out.println("Invalid choice. Please enter Y or N.");
                                break;
                        }
                        // break the loop if N was entered
                        if (more.equals("N")) {
                            break;
                        }
                    }
                    break;

                case "P":
                    // print the details of all the containers
                    System.out.println("******* Shipping Container's details *******");
                    for (ShipContainer container : containers) {
                        container.printContent();
                    }
                    break;

                case "Q":
                    // exit the program
                    System.out.println("Quitting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    // print error message & repeat loop if the input is invalid
                    System.out.println("Invalid choice. Please enter M, R, P, or Q.");
            }
            System.out.println(" "); // print space in between menus
        }
    }
}