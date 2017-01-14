package edu.uz.dr.auctioneer.model.request;

public class DeleteAuctionRequest {

    private String title;
    private String password;

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
