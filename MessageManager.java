/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.message.java;

// These three imports are required to make Lists and Arrays work
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageManager {
    // Parallel lists to store your test data dynamically
    private final List<String> messageIds = new ArrayList<>(Arrays.asList("MSG001", "MSG002", "MSG003", "0838884567", "MSG005"));
    private final List<String> recipients = new ArrayList<>(Arrays.asList("+27834557896", "+27838884567", "+27834484567", "0838884567", "+27838884567"));
    private final List<String> messages = new ArrayList<>(Arrays.asList(
        "Did you get the cake?",
        "Where are you? You are late! I have asked you to be on time.",
        "Yohoooo, I am at your gate.",
        "It is dinner time !",
        "Ok, I am leaving without you."
    ));
    private final List<String> flags = new ArrayList<>(Arrays.asList("Sent", "Stored", "Disregard", "Sent", "Stored"));
    private final List<String> hashes = new ArrayList<>(Arrays.asList("HASH111", "HASH222", "HASH333", "HASH444", "HASH555"));

    // Feature A: Return only Sent messages (Up to item 4 per test spec)
    public String getSentMessages() {
        List<String> sentList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if ("Sent".equals(flags.get(i))) {
                sentList.add(messages.get(i));
            }
        }
        return String.join(", ", sentList);
    }

    // Feature B: Find the longest message (Up to item 4 per test spec)
    public String findLongestMessage() {
        String longest = "";
        for (int i = 0; i < 4; i++) {
            if (messages.get(i).length() > longest.length()) {
                longest = messages.get(i);
            }
        }
        return longest;
    }

    // Feature C: Search by Message ID
    public String searchById(String searchId) {
        int index = messageIds.indexOf(searchId);
        if (index != -1) {
            return messages.get(index);
        }
        return "Message ID not found.";
    }

    // Feature D: Search Sent/Stored by Recipient
    public String searchByRecipient(String targetRecipient) {
        List<String> matchedMessages = new ArrayList<>();
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(targetRecipient) && 
               ("Sent".equals(flags.get(i)) || "Stored".equals(flags.get(i)))) {
                matchedMessages.add(messages.get(i));
            }
        }
        return matchedMessages.isEmpty() ? "No records found." : String.join(" | ", matchedMessages);
    }

    // Feature E: Delete by Hash
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

    //Display Report
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
