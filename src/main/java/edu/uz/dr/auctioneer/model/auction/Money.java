package edu.uz.dr.auctioneer.model.auction;

import edu.uz.dr.auctioneer.model.auction.error.WrongCurrencyException;

class Money {

    private final double amount;
    private final Currency currency;

    Money(final double amount, final Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    boolean isBiggerThan(final Money that) throws WrongCurrencyException {
        if (currency == that.getCurrency()) {
            return amount > that.getAmount();
        } else {
            throw new WrongCurrencyException(currency, that.getCurrency());
        }
    }

    private Currency getCurrency() {
        return currency;
    }

    double getAmount() {
        return amount;
    }
}
