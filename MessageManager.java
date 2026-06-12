package com.mycompany.message.java;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    // Parallel collections used dynamically
    private final List<String> messageIds = new ArrayList<>();
    private final List<String> recipients = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();
    private final List<String> flags = new ArrayList<>();
    private final List<String> hashes = new ArrayList<>();

    public MessageManager() {
        
        loadDynamicData();
    }

    private void loadDynamicData() 
    {
               String[] ids = {"MSG001", "MSG002", "MSG003", "0838884567", "MSG005"};
        String[] recips = {"+27834557896", "+27838884567", "+27834484567", "0838884567", "+27838884567"};
        String[] msgs = {
            "Did you get the cake?",
            "Where are you? You are late! I have asked you to be on time.",
            "Yohoooo, I am at your gate.",
            "It is dinner time!", // Fixed space before ! to match spec sheet
            "Ok, I am leaving without you."
        };
        String[] flgs = {"Sent", "Stored", "Disregard", "Sent", "Stored"};
        String[] hshs = {"HASH111", "HASH222", "HASH333", "HASH444", "HASH555"};

        for (int i = 0; i < ids.length; i++) {
            messageIds.add(ids[i]);
            recipients.add(recips[i]);
            messages.add(msgs[i]);
            flags.add(flgs[i]);
            hashes.add(hshs[i]);
        }
    }

    // Display sender and recipient of all STORED messages
    public String getStoredSendersAndRecipients() {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < flags.size(); i++) {
            if ("Stored".equals(flags.get(i))) {
                // Assuming "Sender" can be represented by Developer
                output.add("ID: " + messageIds.get(i) + " -> Recipient: " + recipients.get(i));
            }
        }
        return output.isEmpty() ? "No stored messages found." : String.join("\n", output);
    }

    //Returns sent message texts up to index 4
    public String getSentMessages() {
        List<String> sentList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if ("Sent".equals(flags.get(i))) {
                sentList.add(messages.get(i));
            }
        }
        return String.join(", ", sentList);
    }

    // Find longest message up to index 4
    public String findLongestMessage() {
        String longest = "";
        for (int i = 0; i < 4; i++) {
            if (messages.get(i).length() > longest.length()) {
                longest = messages.get(i);
            }
        }
        return longest;
    }

    //Search by ID and display BOTH recipient and message text
    public String searchById(String searchId) {
        int index = messageIds.indexOf(searchId);
        if (index != -1) {
            return "Recipient: " + recipients.get(index) + ", Message: " + messages.get(index);
        }
        return "Message ID not found.";
    }

    // Standard raw message body return for simple automated string checks
    public String searchByIdRawMessage(String searchId) {
        int index = messageIds.indexOf(searchId);
        if (index != -1) {
            return messages.get(index);
        }
        return "Message ID not found.";
    }

    //Search by Recipient 
    public String searchByRecipient(String targetRecipient) {
        List<String> matchedMessages = new ArrayList<>();
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(targetRecipient) && 
               ("Sent".equals(flags.get(i)) || "Stored".equals(flags.get(i)))) {
                matchedMessages.add("\"" + messages.get(i) + "\"");
            }
        }
        return matchedMessages.isEmpty() ? "No records found." : String.join(" ", matchedMessages);
    }

    //Delete by Hash 
    public String deleteByHash(String targetHash) {
        int index = hashes.indexOf(targetHash);
        if (index != -1) {
            String msgText = messages.get(index);
            messageIds.remove(index);
            recipients.remove(index);
            messages.remove(index);
            flags.remove(index);
            hashes.remove(index);
            return "Message: \"" + msgText + "\" successfully deleted.";
        }
        return "Hash not found.";
    }

    //  Display report listing full details of all sent messages
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < messages.size(); i++) {
            if ("Sent".equals(flags.get(i))) {
                report.append(hashes.get(i)).append(" - ")
                      .append(recipients.get(i)).append(" - ")
                      .append(messages.get(i)).append("\n");
            }
        }
        return report.toString();
    }
}
