package com.mycompany.message.java;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        MessageManager manager = new MessageManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Part 3: Stored Messages Menu ---");
            System.out.println("1. View Sent Messages");
            System.out.println("2. View Longest Message");
            System.out.println("3. Search by Message ID");
            System.out.println("4. Search by Recipient");
            System.out.println("5. Delete Message by Hash");
            System.out.println("6. Display Full Report");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the text buffer

            switch (choice) {
                case 1 -> System.out.println("Result: " + manager.getSentMessages());
                case 2 -> System.out.println("Longest: " + manager.findLongestMessage());
                case 3 -> {
                    System.out.print("Enter Message ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Result: " + manager.searchById(id));
                }
                case 4 -> {
                    System.out.print("Enter Recipient: ");
                    String recipient = scanner.nextLine();
                    System.out.println("Result: " + manager.searchByRecipient(recipient));
                }
                case 5 -> {
                    System.out.print("Enter Hash to Delete: ");
                    String hash = scanner.nextLine();
                    System.out.println(manager.deleteByHash(hash));
                }
                case 6 -> {
                    System.out.println("\n--- MESSAGE REPORT ---");
                    System.out.print(manager.generateReport());
                }
                case 7 -> {
                    running = false;
                    System.out.println("Exiting Part 3 Menu...");
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }
}
package com.mycompany.message.java;

import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        MessageManager manager = new MessageManager();
        Scanner scanner = new Scanner(System.class);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Part 3: Stored Messages Menu ---");
            System.out.println("1. View Sent Messages");
            System.out.println("2. View Longest Message");
            System.out.println("3. Search by Message ID");
            System.out.println("4. Search by Recipient");
            System.out.println("5. Delete Message by Hash");
            System.out.println("6. Display Full Report");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the text buffer

            switch (choice) {
                case 1:
                    System.out.println("Result: " + manager.getSentMessages());
                    break;
                case 2:
                    System.out.println("Longest: " + manager.findLongestMessage());
                    break;
                case 3:
                    System.out.print("Enter Message ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Result: " + manager.searchById(id));
                    break;
                case 4:
                    System.out.print("Enter Recipient: ");
                    String recipient = scanner.nextLine();
                    System.out.println("Result: " + manager.searchByRecipient(recipient));
                    break;
                case 5:
                    System.out.print("Enter Hash to Delete: ");
                    String hash = scanner.nextLine();
                    System.out.println(manager.deleteByHash(hash));
                    break;
                case 6:
                    System.out.println("\n--- MESSAGE REPORT ---");
                    System.out.print(manager.generateReport());
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting Part 3 Menu...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
