package org.example;

import java.util.List;

public class User {
    private String name;
    private List<User> followers;


    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowers() {
        try {
            return this.followers;
        } catch (Exception e) {
            throw new RuntimeException(this.name + " has no followers");
        }
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
