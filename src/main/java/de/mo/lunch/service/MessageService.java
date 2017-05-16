package de.mo.lunch.service;

import de.mo.lunch.Mapper.MessageMapper;
import de.mo.lunch.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageMapper messageMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public List<Message> findAll() {
        return messageMapper.findAll();
    }

    public void save(String message) {

        this.messageMapper.insert(new Message(0, message));
    }
}
