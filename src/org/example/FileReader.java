package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private static FileReader instance = new FileReader();

    private FileReader() {
    }

    public static FileReader getInstance() {
        return instance;
    }

    public Scanner readFile(String filename) {
        try {
            return new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found, " + e.getMessage());
        }
    }

    public String[] getUser(String line) {
        return line.replace(" follows", ",").split(", ");
    }

    public String getTweet(String data) {
        String firstChar = data.charAt(0) + "";

        return data.replace(firstChar, "\t@" + firstChar).replace("> ", ": ");
    }
}
