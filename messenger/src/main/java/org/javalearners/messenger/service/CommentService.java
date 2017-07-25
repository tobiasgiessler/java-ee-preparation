package org.javalearners.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.javalearners.messenger.database.DatabaseClass;
import org.javalearners.messenger.model.Comment;
import org.javalearners.messenger.model.Message;

public class CommentService {

    private final Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(final long messageId) {
        return new ArrayList(messages.get(messageId).getComments().values());
    }

    public Comment getComment(final long messageId, final long commentId) {
        return messages.get(messageId).getComments().get(commentId);
    }

    public Comment addComment(final long messageId, final Comment comment) {
        final Map<Long, Comment> comments = 
                messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(
            final long messageId,
            final long commentId,
            final Comment comment) {
        if (comment.getId() <= 0) {
            return null;
        }

        messages.get(messageId).getComments().put(commentId, comment);
        return comment;
    }

    public Comment removeComment(final long messageId, final long commentId) {
        return messages.get(messageId).getComments().remove(commentId);
    }

}
