package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TweetContext {

    public static List<Tweet> createTweets(String filename) {

        Scanner input = FileReader.readFile(filename);

        List<Tweet> tweets = new ArrayList<>();

        while (input.hasNext()) {

            String[] prospectTweet = FileReader.splitTweet(input.nextLine());

            try {
                //extract user name and message/tweet
                String userName = prospectTweet[0];
                String message = prospectTweet[1];
                if (message.length() > 140) {
                    throw new ExceptionLogger(ErrorCode.TWEET_LENGTH_EXCEEDED);
                }

                Tweet tweet = new Tweet(userName, message);

                tweets.add(tweet);

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ExceptionLogger(ErrorCode.OUT_OF_BOUNDS);
            }
        }

        return tweets;
    }
}
