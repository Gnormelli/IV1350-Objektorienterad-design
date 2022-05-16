package se.kth.iv1350.salesProcess.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Class that showing error message for user.
 */
public class errorMessageHandler {
    /**
     * Builds and prints error message
     * @param message is the error message to build
     */
    public static void buildPrintErrorMessage(String message){
        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append(timeOfError());
        errorBuilder.append(", Following error occurred: ");
        errorBuilder.append(message);
        System.out.println(errorBuilder);
    }

    /**
     * Creates the time of when error was recorded and displayed
     * @return time of error
     */
    private static String timeOfError(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        return now.format(formatter);
    }
}
