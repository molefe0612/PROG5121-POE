package com.mycompany.message.java;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        MessageManager manager = new MessageManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=================================");
            System.out.println("           MAIN MENU             ");
            System.out.println("=================================");
            System.out.println("1. [Part 1 Feature Placeholder]");
            System.out.println("2. [Part 2 Feature Placeholder]");
            System.out.println("3. [Part 2 Extra Feature Placeholder]");
            System.out.println("4. Stored Messages");
            System.out.println("5. Exit Application");
            System.out.print("Select an option (1-5): ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); 

            if (mainChoice == 5) {
                System.out.println("Exiting Application. Goodbye!");
                break;
            }

            if (mainChoice == 4) {
                boolean inSubMenu = true;
                while (inSubMenu) {
                    System.out.println("\n---------------------------------");
                    System.out.println("    OPTION 4: STORED MESSAGES    ");
                    System.out.println("---------------------------------");
                    System.out.println("a. Display sender and recipient of all stored messages");
                    System.out.println("b. Display the longest stored message");
                    System.out.println("c. Search for a message ID (Display recipient & message)");
                    System.out.println("d. Search for all messages regarding a particular recipient");
                    System.out.println("e. Delete a message using the message hash");
                    System.out.println("f. Display a report of sent message details");
                    System.out.println("g. Return to Main Menu");
                    System.out.print("Select an option (a-g): ");

                    String subChoice = scanner.nextLine().trim().toLowerCase();

                    switch (subChoice) {
                        case "a" -> {
                            System.out.println("\n[Stored Messages - Senders & Recipients]");
                            System.out.println(manager.getStoredSendersAndRecipients());
                        }
                        case "b" -> System.out.println("\nLongest Message: " + manager.findLongestMessage());
                        case "c" -> {
                            System.out.print("\nEnter Message ID to search: ");
                            String id = scanner.nextLine();
                            System.out.println("Result: " + manager.searchById(id));
                        }
                        case "d" -> {
                            System.out.print("\nEnter Recipient number: ");
                            String recipient = scanner.nextLine();
                            System.out.println("Result: " + manager.searchByRecipient(recipient));
                        }
                        case "e" -> {
                            System.out.print("\nEnter Message Hash to delete: ");
                            String hash = scanner.nextLine();
                            System.out.println("Result: " + manager.deleteByHash(hash));
                        }
                        case "f" -> {
                            System.out.println("\n--- MESSAGE REPORT ---");
                            System.out.print(manager.generateReport());
                        }
                        case "g" -> inSubMenu = false;
                        default -> System.out.println("Invalid option! Please type a letter from a to g.");
                    }
                }
            } else if (mainChoice >= 1 && mainChoice <= 3) {
                System.out.println("\nExecuting Part 1/2 feature workflow logic...");
            } else {
                System.out.println("Invalid core option. Try again.");
            }
        }
        scanner.close();
    }
}

