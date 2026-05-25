package com.mycompany.message.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckLengthSuccess() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String expected = "Message ready to send.";
        assertEquals(expected, msg.checkLength());
    }

    @Test
    public void testCheckLengthFailure() {
        StringBuilder largeText = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            largeText.append("A");
        }
        Message msg = new Message(0, "+27718693002", largeText.toString());
        String expected = "Message exceeds 250 characters by 5; please reduce the size.";
        assertEquals(expected, msg.checkLength());
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message(0, "+27718693002", "Valid Message");
        String expected = "Cell phone number successfully captured.";
        assertEquals(expected, msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message(1, "08575975899", "Another Message");
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        assertEquals(expected, msg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String idPrefix = msg.getUniqueId().substring(0, 2);
        String expectedHash = idPrefix + ":0:HITONIGHT";
        assertEquals(expectedHash, msg.getMessageHash());
    }

    @Test
    public void testCheckMessageIDGeneration() {
        Message msg = new Message(0, "+27718693002", "Test ID");
        assertTrue(msg.checkMessageID());
        assertNotNull(msg.getUniqueId());
        assertEquals(10, msg.getUniqueId().length());
    }

    @Test
    public void testSentMessageOptions() {
        Message msg = new Message(0, "+27718693002", "Action Test");
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        assertEquals("Message successfully stored.", msg.SentMessage(3));
    }
}
