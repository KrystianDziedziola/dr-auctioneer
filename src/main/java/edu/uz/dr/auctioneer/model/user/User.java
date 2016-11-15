package edu.uz.dr.auctioneer.model.user;

public class User {

    private final Credentials credentials;
    private String profilePicturePath;
    private String description;

    public User(final Credentials credentials) {
        this.credentials = credentials;
    }

    public String getPassword() {
        return credentials.getPassword();
    }

    public String getLogin() {
        return credentials.getLogin();
    }

    public void setProfilePicturePath(final String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
