package org.javalearners.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.javalearners.messenger.database.DatabaseClass;
import org.javalearners.messenger.model.Message;

public class MessageService {

    private final Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello World", "Max Mustermann"));
        messages.put(2L, new Message(1, "Hello JAX-RS", "Max Mustermann"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(final long messageId) {
        return messages.get(messageId);
    }

    public Message addMessage(final Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        } else {
            messages.put(message.getId(), message);
            return message;
        }
    }

    public Message removeMessage(Message message) {
        return messages.remove(message.getId());
    }

}
