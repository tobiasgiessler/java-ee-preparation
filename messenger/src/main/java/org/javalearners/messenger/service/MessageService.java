package org.javalearners.messenger.service;

import java.util.ArrayList;
import java.util.List;
import org.javalearners.messenger.model.Message;

public class MessageService {

    public List<Message> getAllMessages() {
        final Message m1 = new Message(1L, "Hello World!", "Max Mustermann");
        final Message m2 = new Message(2L, "Hello JAX-RS!", "Max Mustermann");
        List<Message> allMessages = new ArrayList<>();
        allMessages.add(m1);
        allMessages.add(m2);
        return allMessages;
    }

}
