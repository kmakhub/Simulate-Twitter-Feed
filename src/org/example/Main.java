package org.example;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsolePrinter printerContext = new ConsolePrinter();

        printerContext.welcomePrint();

        Scanner input = new Scanner(System.in); //take input from user

        printerContext.print("Enter users file: ");
        String usersFilename = input.nextLine();

        printerContext.print("Enter tweets file: ");
        String tweetsFilename = input.nextLine();

        List<User> usersList = UserContext.createUsers(usersFilename);

        List<Tweet> tweetList = TweetContext.createTweets(tweetsFilename);

        TweetFeed.printTweetFeed(usersList, tweetList);

        printerContext.goodbyePrint();
    }
}