package edu.uz.dr.auctioneer.model.user;

public class User {

    private Credentials credentials;
    private String profilePicturePath;
    private String description;

    public User(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
