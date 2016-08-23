package org.example;

import java.util.*;

public class UserContext {

    public static List<User> createUsers(String filename) {

        Scanner input = FileReader.readFile(filename);

        List<User> users = new ArrayList<>();

        while (input.hasNext()) {

            String[] usersList = FileReader.splitUser(input.nextLine());

            User mainUser = new User(usersList[0]); //the first name from the input line acts as the main user

            HashSet<String> follows = new HashSet<>();

            //iterate through a list of follows to instantly create them as both follows and users
            for (int i = 1; i < usersList.length; i++) {

                User newUser = new User(usersList[i]);
                follows.add(newUser.getName());

                //check if follower already exists as a user
                if (!checkIfUserAlreadyExists(newUser, users)) {
                    users.add(newUser);
                }
            }
            mainUser.setFollows(follows);

            //check if user already exists
            if (!checkIfUserAlreadyExists(mainUser, users)) {
                users.add(mainUser);
            }
        }
        sort(users);

        return users;
    }

    protected static boolean checkIfUserAlreadyExists(User userToAdd, List<User> users) {

        boolean unique = false;

        for (User user : users) {
            //if user exists
            if (user.getName().equals(userToAdd.getName())) {
                //does the prospect user have followers
                if (userToAdd.getFollows().size() > 0) {
                    //union followers to existing
                    HashSet<String> followers = user.getFollows();

                    for (String follows : userToAdd.getFollows()) {
                        followers.add(follows);
                    }
                    user.setFollows(followers);
                }
                unique = true;
            }
        }
        return unique;
    }

    protected static void sort(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
}
