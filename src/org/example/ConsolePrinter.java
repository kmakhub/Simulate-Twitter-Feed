package org.example;

public class ConsolePrinter {
    public static final String TABS = "\t\t\t";
    private static final String HASH_DECO = TABS + "#################################################################";
    public static final String NEW_LINE = "\n";
    public static final String DASH_DECO = "-----------------------------";

    public void goodbyePrint() {
        print(String.format(""));
        print(NEW_LINE + TABS + DASH_DECO + " GOODBYE " + DASH_DECO);
    }

    public void welcomePrint() {
        print(NEW_LINE + DASH_DECO + " WELCOME TO TWITTER SIMULATOR " + DASH_DECO);

        print(NEW_LINE + HASH_DECO);

        print(TABS + "#\tNOTE: Please provide full path/location for all your files\t#");
        print(HASH_DECO + NEW_LINE);
    }

    public void print(String input) {
        System.out.println(input);
    }
}
