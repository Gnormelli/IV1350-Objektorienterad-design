package se.kth.iv1350.salesProcess.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale instanceToTest;

    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        instanceToTest = new Sale();
    }

    @AfterEach
    void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
        instanceToTest = null;
    }

    @Test
    void testCheckItemDTOInSale() {

    }

    @Test
    void updateItemQuantityInSale() {
    }

    @Test
    void calculateTotalPriceIncVAT() {
    }
}