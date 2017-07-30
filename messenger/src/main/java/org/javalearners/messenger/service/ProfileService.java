package org.javalearners.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.javalearners.messenger.database.DatabaseClass;
import org.javalearners.messenger.model.Profile;

public class ProfileService {

    private final Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("hsimpson", new Profile(1L, "hsimpson", "Homer", "Simpson"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(final String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(final Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(final Profile profile) {
        if (profile.getProfileName() == null || profile.getProfileName().isEmpty()) {
            return null;
        } else {
            return profiles.put(profile.getProfileName(), profile);
        }
    }

    public Profile removeProfile(final String profileName) {
        return profiles.remove(profileName);
    }

}
