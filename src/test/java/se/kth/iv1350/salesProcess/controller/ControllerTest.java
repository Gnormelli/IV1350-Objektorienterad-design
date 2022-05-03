package se.kth.iv1350.salesProcess.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.integration.ExternalSystemStartUp;
import se.kth.iv1350.salesProcess.integration.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller instanceToTest;
    private ExternalSystemStartUp startUp;
    private Printer printer;
    private CashRegister cashRegister;

    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Printer printer = new Printer();
        startUp = new ExternalSystemStartUp();
        instanceToTest = new Controller(startUp, printer, cashRegister);
    }

    @AfterEach
    void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instanceToTest = null;
        startUp = null;
    }

    /**
     * NEEDS TO BE REWRITTEN TO BE TESTED
     */
    @Test
    void testSearchForItemIdentifierMatch() {
        /**
        RegisteredItemDTO searchItem = new RegisteredItemDTO(1, 1);
        int expResult = searchItem.getItemIdentifier();
        int result = instanceToTest.addItemToSale(searchItem).getItemIdentifier();
        assertEquals(expResult, result,"");
         */
    }

    @Test
    void testSearchForItemIdentifierNotMatch() {
        /**
         *

        RegisteredItemDTO searchItem = new RegisteredItemDTO(1, 11);
        int expResult = searchItem.getItemIdentifier();
        instanceToTest.addItemToSale(searchItem);
        assertNotEquals(expResult, result, "Item identifier was found, but should not");
         */
    }

    @Test
    void testAddItemToSale() {
    }
}