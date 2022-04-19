package se.kth.iv1350.salesProcess.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExternalInventorySystemTest {
    ExternalInventorySystem instanceToTest;

    @BeforeEach
    void setUp() {
        instanceToTest = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
    }

    @Test
    void testFindItemInInventoryMatching () {
        RegisteredItemDTO searchItem = new RegisteredItemDTO(5, 1);
        int expResult = searchItem.getItemIdentifier();
        int result = instanceToTest.findItemInInventory(searchItem).getItemIdentifier();
        assertEquals(expResult,result, "Item was not found");
    }

    @Test
    void testFindItemInInventoryNotMatching () {
        RegisteredItemDTO searchItem = new RegisteredItemDTO(5, 11);
        int expResult = searchItem.getItemIdentifier();
        ItemDTO result = instanceToTest.findItemInInventory(searchItem);
        assertNotEquals(expResult, result, "Item identifier was found, but should not");
    }

    /** Might be added later for testing.
    @Test
    void testFindItemInInventoryNull () {
        RegisteredItemDTO searchItem = null;
        RegisteredItemDTO expResult = searchItem;
        ItemDTO result = instanceToTest.findItemInInventory(searchItem);
        assertNotEquals(expResult, result, "Item identifier was found, but should not");
    }
    */
}