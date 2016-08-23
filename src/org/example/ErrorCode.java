package org.example;

public enum ErrorCode {
    FILE_NOT_FOUND(101),
    OUT_OF_BOUNDS(102),
    NO_SUCH_USER_OR_TWEET(103),
    TWEET_LENGTH_EXCEEDED(104),
    GENERAL_ERROR(105);

    private final int number;

    ErrorCode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
