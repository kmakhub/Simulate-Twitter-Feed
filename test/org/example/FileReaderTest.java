package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class FileReaderTest {
    private FileReader fileReader;
    private Scanner userInstance;

    @Before
    public void setUp() {
        fileReader = FileReader.getInstance();
        userInstance = fileReader.readFile("sample data/user.txt");
    }

    @After
    public void tearDown() {
        fileReader = null;
        userInstance = null;
    }

    @Test(expected = RuntimeException.class)
    public void shouldReadDataFromFileWhenItThrowsAnException() throws FileNotFoundException {

        Scanner expectedData = new Scanner("some data");

        assertEquals(expectedData.hasNext(), fileReader.readFile("filename.txt").hasNext());
    }

    @Test
    public void shouldReadDataFromFileFileShouldReturnScannerObjectWithData() throws Exception {

        boolean expectedHasNext = new Scanner("some data").hasNext();
        String expectedNextLine = "Ward follows Alan";

        assertEquals(expectedHasNext, userInstance.hasNext());
        assertEquals(expectedNextLine, userInstance.nextLine());
    }

    @Test
    public void shouldReplaceFollowsWithACommaToCombineUsersAndReturnArrayOfUsers() {

        String line = "Ward follows Alan";
        String line2 = "Ward follows Alan, Martin";
        String line3 = "Ward follows Alan, Martin, Jacob, Adam";

        assertArrayEquals(new String[]{"Ward", "Alan"}, fileReader.splitLine(line));
        assertArrayEquals(new String[]{"Ward", "Alan", "Martin"}, fileReader.splitLine(line2));
        assertArrayEquals(new String[]{"Ward", "Alan", "Martin", "Jacob", "Adam"}, fileReader.splitLine(line3));
    }

    @Test
    public void shouldCreateUserGivenAListOfUsers() throws Exception {

        User user = new User();

        user.setName("Ward");

        assertEquals("Ward", user.getName());
    }

    @Test(expected = RuntimeException.class)
    public void shouldCreateUserWhoHasNoFollower() throws Exception {

        User user = new User();
        user.setName("Alan");

        assertEquals("Ward", user.getFollowers().get(0).getName());
    }

    @Test
    public void shouldCreateUserWhoHasOneFollower() throws Exception {

        List<User> names = createFollower();

        User user = new User();
        user.setName("Alan");
        user.setFollowers(names);

        assertEquals("Alan", user.getName());

        assertEquals("Ward", user.getFollowers().get(0).getName());
    }

    @Test
    public void shouldCreateUserManyFollowers() throws Exception {

        List<User> names = createFollower();
        names.add(createUser("Martin"));
        names.add(createUser("Bob"));

        User user = createUser("Alan");
        user.setFollowers(names);

        assertEquals("Alan", user.getName());

        assertEquals("Ward", user.getFollowers().get(0).getName());
        assertEquals("Martin", user.getFollowers().get(1).getName());
        assertEquals("Bob", user.getFollowers().get(2).getName());
    }


    @Test
    public void shouldCreateUserAndListOfUserFollowersIfUserHasMoreThanOneFollowers() throws Exception {

    }

    private User createUser(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    private List<User> createFollower() {
        List<User> names = new ArrayList<>();
        User expectedFollower = createUser("Ward");
        names.add(expectedFollower);
        return names;
    }

}
