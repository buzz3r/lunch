package de.mo.lunch.controller;

import de.mo.lunch.controller.WelcomeController;
import de.mo.lunch.model.Message;
import de.mo.lunch.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WelcomeControllerTest {

    private WelcomeController welcomeController;
    private MessageService messageService;

    @Before
    public void setup() {
        messageService = mock(MessageService.class);
        welcomeController = new WelcomeController(messageService);
    }

    @Test
    public void welcomeShouldReturnWelcomeTemplateName() {
        assertEquals("welcome", welcomeController.welcome(new ExtendedModelMap()));
    }

    @Test
    public void welcomeShouldGetAllMessagesFromMessageService() {
        welcomeController.welcome(new ExtendedModelMap());
        verify(messageService).findAll();
    }

    @Test
    public void welcomeShouldPassMessagesToViewModel() {
        List<Message> messages = Arrays.asList(new Message("Hello"));
        when(messageService.findAll()).thenReturn(messages);

        ExtendedModelMap expectedModelMap = new ExtendedModelMap();
        expectedModelMap.put("messages", messages);

        ExtendedModelMap returnedModelMap = new ExtendedModelMap();
        welcomeController.welcome(returnedModelMap);

        assertThat(expectedModelMap, is(returnedModelMap.asMap()));
    }

    @Test
    public void addMessageShouldCallMessageServiceSaveToSaveMessage() {
        String message = "Hello Friend";
        welcomeController.addMessage(new ExtendedModelMap(), message);
        verify(messageService).save(any());
    }
}