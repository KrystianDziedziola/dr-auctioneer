package edu.uz.dr.auctioneer.model.auction.error;

import edu.uz.dr.auctioneer.model.auction.Currency;

public class WrongCurrencyException extends RuntimeException {
    public WrongCurrencyException(final Currency currentCurrency, final Currency bidCurrency) {
        super(String.format("Currency is not maching. Should be: %s, but it actually is: %s",
                currentCurrency.name(), bidCurrency.name()));
    }
}
