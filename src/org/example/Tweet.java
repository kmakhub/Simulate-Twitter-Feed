package org.example;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Tweet {

    private List<Pair<String, String>> tweetFeed;

    public List<String> getTweetFeed(String name) {
        List<String> messages = new ArrayList<>();
        messages.add(""); // TODO: 2016/08/20 --cater for users with not tweets

        if (tweetFeed != null) {
            for (Pair<String, String> tweet : tweetFeed) {
                if (tweet.getKey().equals(name)) {
                     messages.add("\t@" + tweet.getKey() + ": " + tweet.getValue());
                }
            }
        }
        return messages;
    }

    public void createUserFeed(List<Pair<String, String>> tweetFeed) {
        this.tweetFeed = tweetFeed;
    }
}
