package edu.uz.dr.auctioneer.service.error;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(final String title) {
        super(String.format("Wrong password for auction '%s'", title));
    }
}
