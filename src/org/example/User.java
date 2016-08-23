package org.example;

import java.util.HashSet;

public class User {
    private String name;
    private HashSet<String> follows;

    public User(String name) {
        this.name = name;
        this.follows = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getFollows() {
        return this.follows;
    }

    public void setFollows(HashSet<String> followers) {
        this.follows = followers;
    }
}
