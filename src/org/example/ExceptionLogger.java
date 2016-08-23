package org.example;

public class ExceptionLogger extends RuntimeException {
    public ExceptionLogger(ErrorCode e) {

        ConsolePrinter printerContext = new ConsolePrinter();

        // TODO: 2016/08/22 -- make the getNumber more dynamic
        int number = e.getNumber();
        if (number == 101) {
            printerContext.print("No such file found, please try again");
        } else if (number == 102) {
            printerContext.print("Tweet or User data provided is corrupted, please try again");
        } else if (number == 103) {
            printerContext.print("No such tweet or user, please try again");
        } else if (number == 104) {
            printerContext.print("Tweet length exceeded, please try again");
        } else {
            printerContext.print("Something went wrong, please try again");
        }

        System.exit(0);
    }
}
