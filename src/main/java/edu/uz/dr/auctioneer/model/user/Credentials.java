package edu.uz.dr.auctioneer.model.user;

public class Credentials {

    private static final int MIN_LOGIN_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private final String login;
    private final String password;

    public Credentials(final String login, final String password) {
        verifyCredentials(login, password);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private void verifyCredentials(final String login, final String password) {
        if (isCredentialInvalid(login, MIN_LOGIN_LENGTH)) {
            throw new IllegalArgumentException(createInvalidCredentialMessage("login", MIN_LOGIN_LENGTH));
        }

        if (isCredentialInvalid(password, MIN_PASSWORD_LENGTH)) {
            throw new IllegalArgumentException(createInvalidCredentialMessage("password", MIN_PASSWORD_LENGTH));
        }
    }

    private boolean isCredentialInvalid(final String credential, final int minLength) {
        return credential == null || credential.isEmpty() || credential.length() < minLength;
    }

    private String createInvalidCredentialMessage(final String credential, final int minLength) {
        return String.format("Invalid %s. It should be at least %d characters long", credential, minLength);
    }
}
