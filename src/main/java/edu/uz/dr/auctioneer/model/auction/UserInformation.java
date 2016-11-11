package edu.uz.dr.auctioneer.model.auction;

public class UserInformation {

    private final String login;
    private final String description;

    public UserInformation(final String login, final String description) {
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
