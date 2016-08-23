package org.example;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldCreateUser() {

        User user = createUser();

        assertEquals("Ward", user.getName());
    }

    @Test
    public void shouldCreateUserWhoDoesNotFollowAnyone() {

        User user = createUser();

        assertEquals(0, user.getFollows().size());
    }

    @Test
    public void shouldCreateUserWhoFollowsOtherUsers() {

        HashSet<String> names = createFollows();

        User user = new User("Ward");
        user.setFollows(names);

        assertEquals("Ward", user.getName());
        assertEquals(true, user.getFollows().iterator().hasNext());
        assertEquals("Martin", user.getFollows().iterator().next());
    }

    private User createUser() {
        return new User("Ward");
    }

    private HashSet<String> createFollows() {

        HashSet<String> names = new HashSet<>();
        names.add("Martin");
        return names;
    }
}