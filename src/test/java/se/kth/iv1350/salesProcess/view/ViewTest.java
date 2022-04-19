package se.kth.iv1350.salesProcess.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private ExternalSystemStartUp creator;
    private Printer printer;
    private View instanceToTest;

    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalStream;

    @BeforeEach
    void setUp() {
    Controller contr = new Controller(creator, printer);
    instanceToTest = new View(contr);

    printoutBuffer = new ByteArrayOutputStream();
    PrintStream inMemSysOut = new PrintStream(printoutBuffer);
    originalStream = System.out;
    System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalStream);
    }

    /**
     * Testing the printout when a new sale is started
     */
    @Test
    void testSimulatorOfExecutionNewSalePrintout() {
        instanceToTest.simulatorOfExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "new sale";
        assertTrue(printout.contains(expectedOutput),"UI did not start correctly");
    }
}