package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TweetTest {

    @Test
    public void shouldCreateTweet() throws Exception {
        Tweet tweet = new Tweet("Alan", "something something");
        assertEquals("Alan", tweet.getUserName());
        assertEquals("something something", tweet.getMessage());
    }
}