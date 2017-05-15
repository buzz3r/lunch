package de.mo.lunch.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void testCreateMessage() {
        Message message = new Message("Hello");
        assertEquals("Hello", message.getMessage());
    }


}