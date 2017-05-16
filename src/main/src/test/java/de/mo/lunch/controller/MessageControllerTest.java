package de.mo.lunch.controller;

import de.mo.lunch.model.Message;
import de.mo.lunch.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MessageControllerTest {

    private MessageController messageController;
    private MessageService messageService;
    private Model model;


    @Before
    public void setup() {
        messageService = mock(MessageService.class);
        model = mock(Model.class);
        messageController = new MessageController(messageService);
    }

    @Test
    public void welcomeShouldReturnShowMessagesTemplateName() {
        assertEquals("showMessages", messageController.showMessages(model));
    }

    @Test
    public void welcomeShouldGetAllMessagesFromMessageService() {
        messageController.showMessages(model);
        verify(messageService).findAll();
    }

    @Test
    public void welcomeShouldPassMessagesToViewModel() {
        List<Message> messages = Arrays.asList(new Message(0, "Hello"));
        when(messageService.findAll()).thenReturn(messages);

        messageController.showMessages(model);
        verify(model).addAttribute("messages", messages);
    }

    @Test
    public void addMessageShouldCallMessageServiceSaveToSaveMessage() {
        String message = "Hello Friend";
        messageController.addMessage(model, message);
        verify(messageService).save(message);
    }

    @Test
    public void addMessageShouldCallShowMessages() {
        String message = "Hello Friend";
        messageController = spy(messageController);
        messageController.addMessage(model, message);
        verify(messageController).showMessages(model);
    }
}