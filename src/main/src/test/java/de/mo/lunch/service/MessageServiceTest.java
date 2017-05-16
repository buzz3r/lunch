package de.mo.lunch.service;

import de.mo.lunch.Mapper.MessageMapper;
import de.mo.lunch.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    private MessageMapper messageMapper;
    private MessageService messageService;

    @Before
    public void setUp() {
        messageMapper = mock(MessageMapper.class);
        messageService = new MessageService(messageMapper);
    }

    @Test
    public void getAllShouldCallMessageMapperFindAll() {
        List<Message> expectedMessages = Arrays.asList(new Message(0, "Hello"));
        when(messageMapper.findAll()).thenReturn(expectedMessages);

        List<Message> messages = messageService.findAll();
        verify(messageMapper).findAll();

        assertThat(expectedMessages, equalTo(messages));
    }

    @Test
    public void saveShouldCallMessageMapperInsert() {
        ArgumentCaptor<Message> argumentCaptor = ArgumentCaptor.forClass(Message.class);
        String message = "Hello";
        messageService.save(message);
        verify(messageMapper).insert(argumentCaptor.capture());
        assertEquals(message, argumentCaptor.getValue().getMessage());
    }

}