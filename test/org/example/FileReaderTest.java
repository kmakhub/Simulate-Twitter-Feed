package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class FileReaderTest {
    private Scanner userInstance;

    @Before
    public void setUp() {
        userInstance = FileReader.readFile("sample data/user.txt");
    }

    @After
    public void tearDown() {
        userInstance = null;
    }

    @Test(expected = ExceptionLogger.class)
    public void shouldReadDataFromFileWhenItThrowsAnException() throws IOException {

        Scanner expectedData = new Scanner("some data");

        assertEquals(expectedData.hasNext(), FileReader.readFile("filename.txt").hasNext());
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

        assertArrayEquals(new String[]{"Ward", "Alan"}, FileReader.splitUser(line));
        assertArrayEquals(new String[]{"Ward", "Alan", "Martin"}, FileReader.splitUser(line2));
        assertArrayEquals(new String[]{"Ward", "Alan", "Martin", "Jacob", "Adam"}, FileReader.splitUser(line3));
    }

    @Test
    public void shouldCreateUserAndListOfUserFollowersIfUserHasMoreThanOneFollowers() throws Exception {

    }

    @Test
    public void shouldReplaceGivenTweetDataToRecommendedOutput() throws Exception {

        String line = "Alan> If you have a procedure with 10 parameters, you probably missed some.";

        assertEquals("Alan", FileReader.splitTweet(line)[0]);
        assertEquals("If you have a procedure with 10 parameters, you probably missed some.", FileReader.splitTweet(line)[1]);
    }

}
