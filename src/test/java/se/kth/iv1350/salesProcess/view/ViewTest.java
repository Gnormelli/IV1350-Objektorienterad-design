package se.kth.iv1350.salesProcess.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.integration.CashRegister;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.Printer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instanceToTest;

    private ExternalSystemStartUp creator;
    private Printer printer;
    private CashRegister cashRegister;
    private Controller contr;
    private Scanner scan;

    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalStream;

    @BeforeEach
    void setUp() {
        creator = new ExternalSystemStartUp();
        printer = new Printer();
        cashRegister = new CashRegister();
        contr = new Controller(creator, printer, cashRegister);
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalStream = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        creator = null;
        printer = null;
        cashRegister = null;
        contr = null;
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalStream);
    }

    /**
     * Testing the printout when a new sale is started
     */
    @Test
    void testSimulatorOfExecutionNewSalePrintout() {
        instanceToTest.simulatorOfExecution(scan);
        String printout = printoutBuffer.toString();
        String expectedOutput = "new sale";
        assertTrue(printout.contains(expectedOutput),"UI did not start correctly");
    }
}