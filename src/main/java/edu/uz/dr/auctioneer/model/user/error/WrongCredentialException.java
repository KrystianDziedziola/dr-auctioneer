package edu.uz.dr.auctioneer.model.user.error;

public class WrongCredentialException extends RuntimeException {

    public WrongCredentialException(final String credential) {
        super(String.format("Wrong credentials. Enter correct %s.", credential));
    }
}
