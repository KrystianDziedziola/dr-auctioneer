package edu.uz.dr.auctioneer.model.user.error;

public class LoginNotAvailableException extends RuntimeException {

    public LoginNotAvailableException(final String login) {
        super(String.format("Login: '%s' is not available. It's already used by different user.", login));
    }
}
