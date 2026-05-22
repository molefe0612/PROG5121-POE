/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message.java;

import java.util.Random;

public final class Message {
    // Global counter to track total messages successfully sent across the application lifecycle
    public static int totalSentCounter = 0;

    
    private final String uniqueId;      
    private final int messageNum;       
    private final String recipient;     
    private final String text;          
    private String messageHash;   

    // Constructor to initialize object states
    public Message(int messageNum, String recipient, String text) {
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.text = text;
        this.uniqueId = generateRandomID();
        this.messageHash = createMessageHash();
    }

    // Helper method to automatically compute a random 10-digit numerical sequence string
    private String generateRandomID() {
        Random rand = new Random();
        long number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    // method which checks if ID scales up to 10 characters or fewer
    public boolean checkMessageID() {
        return this.uniqueId != null && this.uniqueId.length() <= 10;
    }

    // method which Verifies recipient code prefix format requirements 
    public String checkRecipientCell() {
        if (this.recipient != null && this.recipient.startsWith("+") && this.recipient.length() >= 10) {
            return this.recipient;
        }
        return "Invalid Recipient Number";
    }

    // Requirement Method 3: Computes message text block hash matrix context fields 
    public String createMessageHash() {
        if (this.text == null || this.text.trim().isEmpty()) {
            return this.uniqueId.substring(0, 2) + ":" + this.messageNum + ":EMPTY";
        }
        
        // Split text block using variable whitespace boundary delimiters
        String[] words = this.text.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        String rawHash = this.uniqueId.substring(0, 2) + ":" + this.messageNum + ":" + firstWord + lastWord;
        this.messageHash = rawHash.toUpperCase();
        return this.messageHash;
    }

    // Requirement Method 4: Processes internal text message storage operations
    public String SentMessage(int choice) {
        if (choice == 1) {
            totalSentCounter++; // Increment operational global value tracking bounds
            return "Message successfully sent";
        } else if (choice == 2) {
            return "Press 0 to delete the message";
        } else if (choice == 3) {
            return "Message successfully stored";
        }
        return "Invalid Choice";
    }

    // Requirement Method 5: Prints out full data records structure in required order
    public String printMessages() {
        return "Message ID: " + this.uniqueId + "\n" +
               "Message Hash: " + this.messageHash + "\n" +
               "Recipient: " + this.recipient + "\n" +
               "Message: " + this.text;
    }

    // Requirement Method 6: Returns global execution loop sum metrics
    public int returnTotalMessagess() {
        return totalSentCounter;
    }

    // Research Requirement Method 7: Serializes class state tracking parameters to raw JSON layout strings
    public String storeMessage() {
        return "{\n" +
               "  \"uniqueMessageId\": \"" + this.uniqueId + "\",\n" +
               "  \"numMessagesSent\": " + this.messageNum + ",\n" +
               "  \"recipient\": \"" + this.recipient + "\",\n" +
               "  \"message\": \"" + this.text.replace("\"", "\\\"") + "\",\n" +
               "  \"messageHash\": \"" + this.messageHash + "\"\n" +
               "}";
    }

    // standard clean system getters
    public String getUniqueId() { return uniqueId; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getText() { return text; }
}