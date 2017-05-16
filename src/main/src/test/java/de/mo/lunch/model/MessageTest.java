package de.mo.lunch.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void testCreateMessage() {
        Message message = new Message(0, "Hello");
        assertEquals(0, message.getId());
        assertEquals("Hello", message.getMessage());
    }


}