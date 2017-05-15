package de.mo.lunch.service;

import de.mo.lunch.Mapper.MessageMapper;
import de.mo.lunch.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by moritz on 13/05/2017.
 */
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
        Message message = new Message("Hello");
        when(messageMapper.findAll()).thenReturn(Arrays.asList(message));

        List<Message> messages = messageService.findAll();
        verify(messageMapper).findAll();

        assertThat(messages, hasItem(message));
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