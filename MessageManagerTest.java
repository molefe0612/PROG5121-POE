package com.mycompany.message.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageManagerTest {

    private MessageManager manager;

    @BeforeEach
    public void setUp() {
        // This resets the data fresh before every single test runs
        manager = new MessageManager();
    }

    @Test
    public void testSentMessagesPopulated() 
    {
        String result = manager.getSentMessages();
        assertEquals("Did you get the cake?, It is dinner time!", result);
    }

    @Test
    public void testDisplayLongestMessage() {
        String longest = manager.findLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchForMessageId() {
        String foundMessage = manager.searchById("0838884567");
        assertEquals("It is dinner time !", foundMessage);
    }

    @Test
    public void testSearchSentOrStoredByRecipient() {
        String result = manager.searchByRecipient("+27838884567");
        assertEquals("Where are you? You are late! I have asked you to be on time.  Ok, I am leaving without you.", result);
    }

    @Test
    public void testDeleteMessageUsingHash() {
        String deletionConfirmation = manager.deleteByHash("HASH222");
        assertEquals("Message: "Where are you? You are late! I have asked you to be on time.\" successfully deleted.", deletionConfirmation);
        
        String tryAgain = manager.deleteByHash("HASH222");
        assertEquals("Hash not found.", tryAgain);
    }

    @Test
    public void testDisplayReport() {
        String expectedReport = """
                                HASH111 - +27834557896 - Did you get the cake?
                                HASH444 - 0838884567 - It is dinner time !
                                """;
                                
        assertEquals(expectedReport, manager.generateReport());
    }
}
