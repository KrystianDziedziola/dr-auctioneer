package edu.uz.dr.auctioneer.model.auction;

import edu.uz.dr.auctioneer.model.auction.error.WrongCurrencyException;

class Money {
    private static final int LOWEST_AMOUNT = 0;
    private static final String CURRENCY_REQUIRED_MESSAGE = "Currency is required";
    private static final String WRONG_AMOUNT_MESSAGE = "Amount should be more than %d";

    private final double amount;
    private final Currency currency;

    Money(final double amount, final Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException(CURRENCY_REQUIRED_MESSAGE);
        }
        if (amount < LOWEST_AMOUNT) {
            throw new IllegalArgumentException(String.format(WRONG_AMOUNT_MESSAGE, LOWEST_AMOUNT));
        }
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
