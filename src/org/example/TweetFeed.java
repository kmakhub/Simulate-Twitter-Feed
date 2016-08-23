package org.example;

import java.util.List;

public class TweetFeed {
    public static void printTweetFeed(List<User> users, List<Tweet> tweets) {

        ConsolePrinter printerContext = new ConsolePrinter();

        try {
            for (User user : users) {
                String userWithTheirFollows = concatenateUserWithTheirFollows(user);
                for (Tweet tweet : tweets) {
                    if (userWithTheirFollows.contains(tweet.getUserName())) {
                        printerContext.print("\t@" + tweet.getUserName() + ": " + tweet.getMessage());
                    }
                }
            }
        }catch(NullPointerException e){
            throw new ExceptionLogger(ErrorCode.NO_SUCH_USER_OR_TWEET);
        }
    }

    protected static String concatenateUserWithTheirFollows(User user) {
        ConsolePrinter printerContext = new ConsolePrinter();

        printerContext.print(user.getName());
        String userAndFollowers = user.getName();
        if (user.getFollows().size() > 0) {
            for (String followers : user.getFollows()) {
                userAndFollowers += " " + followers;
            }
        }
        return userAndFollowers;
    }
}
