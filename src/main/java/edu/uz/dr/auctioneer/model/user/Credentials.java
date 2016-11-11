package edu.uz.dr.auctioneer.model.user;

public class Credentials {

    private static final int MIN_LOGIN_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private String login;
    private String password;

    public Credentials(String login, String password) {
        if (isCredentialInvalid(login, MIN_LOGIN_LENGTH)) {
            throw new IllegalArgumentException(createInvalidCredentialMessage("login", MIN_LOGIN_LENGTH));
        }
        if (isCredentialInvalid(password, MIN_PASSWORD_LENGTH)) {
            throw new IllegalArgumentException(createInvalidCredentialMessage("password", MIN_PASSWORD_LENGTH));
        }
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String createInvalidCredentialMessage(String credential, int minLength) {
        return String.format("Invalid %s. It should be at least %d characters long", credential, minLength);
    }

    private boolean isCredentialInvalid(String credential, int minLength) {
        return credential == null || credential.isEmpty() || credential.length() < minLength;
    }
}
