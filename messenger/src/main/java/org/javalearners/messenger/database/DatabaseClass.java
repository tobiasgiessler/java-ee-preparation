package org.javalearners.messenger.database;

import java.util.HashMap;
import java.util.Map;
import org.javalearners.messenger.model.Message;
import org.javalearners.messenger.model.Profile;

public class DatabaseClass {

    private static final Map<Long, Message> MESSAGES = new HashMap<>();
    private static final Map<Long, Profile> PROFILES = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return MESSAGES;
    }

    public static Map<Long, Profile> getProfiles() {
        return PROFILES;
    }

}
