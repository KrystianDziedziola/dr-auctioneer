package edu.uz.dr.auctioneer.model.user;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;


public class CredentialsTest {

    @Test
    public void Should_Create_Credentials() {
        // given
        final String login = "login";
        final String password = "password";

        // when
        final Credentials credentials = new Credentials(login, password);

        // then
        assertThat(credentials).isNotNull();
        assertThat(credentials.getLogin()).isNotEmpty();
        assertThat(credentials.getPassword()).isNotEmpty();
    }

    @Test
    public void Should_Not_Create_Credentials_If_Too_Short_Login() {
        // given
        final String login = "l";
        final String password = "password";

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Not_Create_Credentials_If_Empty_Login() {
        // given
        final String login = "";
        final String password = "password";

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Not_Create_Credentials_If_Login_Not_Present() {
        // given
        final String login = null;
        final String password = "password";

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Not_Create_Credentials_If_Too_Short_Password() {
        // given
        final String login = "login";
        final String password = "pa";

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Not_Create_Credentials_If_Empty_Password() {
        // given
        final String login = "login";
        final String password = "";

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Should_Not_Create_Credentials_If_Password_Not_Present() {
        // given
        final String login = "login";
        final String password = null;

        // when
        final Throwable result = catchThrowable(() -> new Credentials(login, password));

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}