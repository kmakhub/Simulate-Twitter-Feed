package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TweetFeedTest {

    private final ByteArrayOutputStream content = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(content));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void testPrintTweetFeedGivenListOfUsersAndListOfTweets() {

        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet("Alan", "something she said"));
        tweets.add(new Tweet("Ward", "something he said"));

        List<User> users = new ArrayList<>();
        users.add(new User("Ward"));
        users.add(new User("Alan"));

        TweetFeed.printTweetFeed(users, tweets);

        Object expectedOutput = "Ward\n" + "\t@Ward: something he said\n" +
                "Alan\n" + "\t@Alan: something she said\n";

        assertEquals(expectedOutput, content.toString());
    }

    @Test(expected = ExceptionLogger.class)
    public void testPrintTweetFeedWhenExceptionIsThrown() {

        TweetFeed.printTweetFeed(null, null);

        assertEquals(null, content.toString());
    }

    @Test
    public void shouldReturnTheUserNameIfUserDoesNotFollowAnyone() {

        assertEquals("Ward", TweetFeed.concatenateUserWithTheirFollows(new User("Ward")));
        assertEquals("Ward\n", content.toString());
    }

    @Test
    public void shouldConcatenateUserWithTheirFollowsIfUserFollowsAnyone() {

        User actualUser = new User("Ward");
        HashSet<String> follows = createFollowsList();
        actualUser.setFollows(follows);

        assertEquals("Ward Martin Alan", TweetFeed.concatenateUserWithTheirFollows(actualUser));
    }

    private HashSet<String> createFollowsList() {

        HashSet<String> set = new HashSet<>();
        set.add("Martin");
        set.add("Alan");

        return set;
    }
}