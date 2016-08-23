package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserContextTest {

    @Test
    public void shouldCreateUsersAndReturnAListOfUsersCreatedFromAUserFile() {
        String filename = "sample data/user.txt"; // used actual file

        assertEquals(3, UserContext.createUsers(filename).size());
    }

    @Test
    public void shouldCheckIfUserAlreadyExistsGivenUserAndAListOfExistingUsers() throws Exception {

        List<User> users = createUsersList();

        assertEquals(true, UserContext.checkIfUserAlreadyExists(new User("Ward"), users));
        assertEquals(false, UserContext.checkIfUserAlreadyExists(new User("Bob"), users));
    }

    @Test
    public void shouldSortListOfUsers() throws Exception {

        List<User> users = createUsersList();

        UserContext.sort(users);

        assertEquals("Alan", users.get(0).getName());
    }

    private List<User> createUsersList() {
        List<User> users =  new ArrayList<>();
        users.add(new User("Ward"));
        users.add(new User("Alan"));
        users.add(new User("Martin"));
        return users;
    }
}