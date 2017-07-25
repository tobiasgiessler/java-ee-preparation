package org.javalearners.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.javalearners.messenger.database.DatabaseClass;
import org.javalearners.messenger.model.Message;

public class MessageService {

    private final Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        final Message m1 = new Message(1, "Hello World", "Max Mustermann");
        final Message m2 = new Message(2, "Hello JAX-RS", "Max Mustermann");
        final Message m3 = new Message(3, "Hello 2016", "Max Mustermann");
        final Message m4 = new Message(4, "Hello 2015", "Max Mustermann");
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.JUNE, 21);
        m3.setCreated(calendar.getTime());
        calendar.set(2015, Calendar.OCTOBER, 9);
        m4.setCreated(calendar.getTime());
        messages.put(m1.getId(), m1);
        messages.put(m2.getId(), m2);
        messages.put(m3.getId(), m3);
        messages.put(m4.getId(), m4);
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesPaginated(
            final int start,
            final int pageSize) {
        return getAllMessages().subList(start, pageSize);
    }

    public List<Message> getAllMessagesByYear(final int year) {
        final Calendar calendar = Calendar.getInstance();
        return getAllMessages().stream().filter(
                message -> {
                    calendar.setTime(message.getCreated());
                    return calendar.get(Calendar.YEAR) == year;
                }
        ).collect(Collectors.toList());
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

    public Message removeMessage(final long messageId) {
        return messages.remove(messageId);
    }

}
