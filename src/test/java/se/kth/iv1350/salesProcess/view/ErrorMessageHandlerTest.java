package se.kth.iv1350.salesProcess.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageHandlerTest {
    ErrorMessageHandler instanceToTest;
    ByteArrayOutputStream output;
    PrintStream systemOutput;

    @BeforeEach
    void setUp() {
        instanceToTest = new ErrorMessageHandler();
        systemOutput = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        output = null;
        System.setOut(systemOutput);
    }

    @Test
    void buildPrintErrorMessage() {
        String errorMsg = "this is the message";
        instanceToTest.buildPrintErrorMessage(errorMsg);
        String expResultMsg = ", Following error occurred: " + errorMsg;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String expResultTime = now.format(formatter);
        String result = output.toString();
        assertTrue(result.contains(expResultMsg), "Wrong message printed.");
        assertTrue(result.contains(expResultTime), "Wrong message printed.");
    }
}