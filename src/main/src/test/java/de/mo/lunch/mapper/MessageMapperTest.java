package de.mo.lunch.mapper;

import de.mo.lunch.Mapper.MessageMapper;
import de.mo.lunch.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageMapperTest {


    @Autowired
    MessageMapper messageMapper;

    @Test
    public void findAllMessagesShouldReturnAllMessages() {
        Message message = new Message("Hello");
        messageMapper.insert(message);

        List<Message> messages = messageMapper.findAll();
        assertThat(messages, hasItem(hasProperty("message", equalTo("Hello"))));
    }
}
