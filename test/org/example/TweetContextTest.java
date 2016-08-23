package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TweetContextTest {

    @Test
    public void shouldCreateTweetAndReturnAListOfUsersCreatedFromAUserFile() throws Exception {

        String filename = "sample data/tweet.txt"; // used actual file

        assertEquals(3, TweetContext.createTweets(filename).size());
    }

    @Test(expected = ExceptionLogger.class)
    public void shouldThrowExceptionLoggerWhenFileNotFound() throws Exception {

        assertEquals(3, TweetContext.createTweets("nosuchfile.txt").size());
    }

    @Test(expected = ExceptionLogger.class)
    public void shouldThrowExceptionLoggerWhenArrayOutOfBound() throws Exception {
        String filename = "sample data/user.txt"; // used actual file

        TweetContext.createTweets(filename);
    }
}