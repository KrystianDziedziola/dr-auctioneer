package edu.uz.dr.auctioneer.model;

public class User {

    private final String login;
    private final String description;

    public User(final String login, final String description) {
        this.login = login;
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public String getDescription() {
        return description;
    }
}
