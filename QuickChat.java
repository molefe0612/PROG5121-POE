/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        int currentMessageIndex = 1;

        System.out.println("=== QuickChat Initialization ===");
        
        //  Required Login Simulation Check
        System.out.print("Enter Username: ");
        String user = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();
        
        if(!user.isEmpty() && !pass.isEmpty()) {
            isLoggedIn = true;
            System.out.println("Login System: Success!");
        } else {
            System.out.println("Login System: Failed! App will restrict sending features.");
        }

        // 2. Pre-defined Session Message Entry Limit Boundaries
        System.out.print("\nDefine how many messages you wish to enter this session: ");
        int maxMessages = scanner.nextInt();
        scanner.nextLine(); // Clear trailing newline buffer character

        boolean running = true;
        
        // 3. Main Application Lifecycle Execution Engine Loop
        while (running) {
            System.out.println("\n---------------------------------");
            System.out.println("Welcome to QuickChat.");
            System.out.println("---------------------------------");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.print("Choose an option from the numeric menu: ");
            
            int mainMenuChoice = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            switch (mainMenuChoice) {
                case 1:
                    //  login verification checks
                    if (!isLoggedIn) {
                        System.out.println("Error: The users should only be able to send messages if they have logged in successfully.");
                        break;
                    }
                    if (Message.totalSentCounter >= maxMessages) {
                        System.out.println("Limit reached! You can only enter the set number of messages (" + maxMessages + ").");
                        break;
                    }

                    // Collect input fields from assignment sheet test parameters
                    System.out.print("Enter Recipient Cell Number (e.g. +27718693002): ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter Message Text (max 250 characters): ");
                    String text = scanner.nextLine();

                    // String scale field size constraint check logic validation
                    if (text.length() > 250) {
                        System.out.println("Please enter a message of less than 250 characters.");
                        break; 
                    } else {
                        System.out.println("Message processing...");
                    }

                    // Instantiate temporary object from your Message template class
                    Message tempMsg = new Message(currentMessageIndex, recipient, text);

                    // Confirm validation state requirements
                    if(!tempMsg.checkRecipientCell().equals("Invalid Recipient Number") && tempMsg.checkMessageID()) {
                        
                        // Secondary Nested Action Confirmation sub-menu panel layer interface
                        System.out.println("\nSelect an action for this message:");
                        System.out.println("1 - Send Message");
                        System.out.println("2 - Disregard Message");
                        System.out.println("3 - Store Message to send later");
                        System.out.print("Your choice: ");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear scanner buffer

                        String statusResult = tempMsg.SentMessage(subChoice);
                        System.out.println(statusResult);

                        if (subChoice == 1) {
                            
                            System.out.println("\n=== Message Sent Confirmation Details ===");
                            System.out.println(tempMsg.printMessages());
                            currentMessageIndex++;
                        } 
                        else if (subChoice == 2) {
                            System.out.println("Action: Object deleted from staging memory execution flow tracks.");
                        } 
                        else if (subChoice == 3) {
                            // JSON Research Component Framework
                            String filename = "message_store_" + tempMsg.getUniqueId() + ".json";
                            try (FileWriter file = new FileWriter(filename)) {
                                file.write(tempMsg.storeMessage());
                                System.out.println("JSON storage file written successfully: " + filename);
                            } catch (IOException e) {
                                System.out.println("An error occurred trying to write JSON out to text disk drive block storage.");
                            }
                        }
                    } else {
                        System.out.println("Validation Processing Error: Recipient formatting issue encountered (+ indicator required). Message aborted.");
                    }
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid entry context numeric choice options variant match.");
            }
        }

        // Final closure output summary logging stats data telemetry display session
        System.out.println("\n==============================================");
        System.out.println("Total overall system session messages sent: " + Message.totalSentCounter);
        System.out.println("Thank you for choosing QuickChat application utilities. Goodbye.");
        System.out.println("==============================================");
        scanner.close();
    }
}
