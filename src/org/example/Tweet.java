package org.example;

public class Tweet {

    private final String userName;
    private final String message;

    public Tweet(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
