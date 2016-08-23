package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static Scanner readFile(String filename) {
        try {
            return new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new ExceptionLogger(ErrorCode.FILE_NOT_FOUND);
        }
    }

    public static String[] splitUser(String line) {
        return line.replace(" follows", ",").split(", ");
    }

    public static String[] splitTweet(String data) {
        return data.split("> ");
    }
}

