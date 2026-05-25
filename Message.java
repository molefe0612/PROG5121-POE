package com.mycompany.message.java;

import java.util.Random;

public final class Message {
    public static int totalSentCounter = 0;

    private final String uniqueId;      
    private final int messageNum;       
    private final String recipient;     
    private final String text;          
    private String messageHash;   

    // Default No-Arg Constructor for utility/tracking access
    public Message() 
    {
        this.uniqueId = "";
        this.messageNum = 0;
        this.recipient = "";
        this.text = "";
        this.messageHash = "";
    }

    // Constructor to initialize object states
    public Message(int messageNum, String recipient, String text) {
        this.messageNum = messageNum;
        this.recipient = recipient;
        this.text = text;
        this.uniqueId = generateRandomID();
        this.messageHash = createMessageHash();
    }

    private String generateRandomID() {
        Random rand = new Random();
        long number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    // Requirement Method: Message Length Check
    public String checkLength() {
        if (this.text.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extraChars = this.text.length() - 250;
            return "Message exceeds 250 characters by " + extraChars + "; please reduce the size.";
        }
    }

    // Requirement Method: Message ID Length Check
    public boolean checkMessageID() {
        return this.uniqueId != null && this.uniqueId.length() <= 10;
    }

    // Requirement Method: Recipient Validation
    public String checkRecipientCell() {
        if (this.recipient != null && this.recipient.startsWith("+") && this.recipient.length() >= 10) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // Requirement Method: Message Hash Matrix Creator
    public String createMessageHash() {
        if (this.text == null || this.text.trim().isEmpty()) {
            return "00:" + this.messageNum + ":EMPTY";
        }
        
        String[] words = this.text.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
        
        String idPrefix = (this.uniqueId.length() >= 2) ? this.uniqueId.substring(0, 2) : "00";
        
        this.messageHash = (idPrefix + ":" + this.messageNum + ":" + firstWord + lastWord).toUpperCase();
        return this.messageHash;
    }

    // Requirement Method: Process Sub-menu Options
    public String SentMessage(int choice) {
        if (choice == 1) {
            totalSentCounter++;
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        }
        return "Invalid Choice";
    }

    public String printMessages() {
        return "Message ID: " + this.uniqueId + "\n" +
               "Message Hash: " + this.messageHash + "\n" +
               "Recipient: " + this.recipient + "\n" +
               "Message: " + this.text;
    }

    public int returnTotalMessages() {
        return totalSentCounter;
    }

    // Storing messages in raw JSON format string layout
    public String storeMessage() {
        return "{\n" +
               "  \"uniqueMessageId\": \"" + this.uniqueId + "\",\n" +
               "  \"numMessagesSent\": " + this.messageNum + ",\n" +
               "  \"recipient\": \"" + this.recipient + "\",\n" +
               "  \"message\": \"" + this.text.replace("\"", "\\\"") + "\",\n" +
               "  \"messageHash\": \"" + this.messageHash + "\"\n" +
               "}";
    }

    // Fixed standard system getters returning the class instance fields
    public String getUniqueId() { 
        return this.uniqueId; 
    }
    
    public String getMessageHash() { 
        return this.messageHash; 
    }
    
    public String getRecipient() { 
        return this.recipient; 
    }
    
    public String getText() { 
        return this.text; 
    }
}
