package se.kth.iv1350.salesProcess.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class SalesItemTest {
    private SalesItem instanceToTest;
    private int quantityOfItem;
    private ItemDTO item;


    @BeforeEach
    void setUp() {
        quantityOfItem = 7;
        item = new ItemDTO("Milk",1, 15, 25, "Green");
        instanceToTest = new SalesItem(quantityOfItem, item);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
    }

    @Test
    void testAddQuantityOfItem() {
        SalesItem test = new SalesItem(quantityOfItem+1, item);
        int expected = test.getQuantityOfItem();
        instanceToTest.addQuantityOfItem(1);
        int result = instanceToTest.getQuantityOfItem();

        assertEquals(expected, result, "The quantities are not the same");
    }

    @Test
    void testTotalPriceIncVATForSalesItem() {
        float vat = item.getPrice()*(item.getRateVAT()/100);
        float expected  =  (vat + item.getPrice())*quantityOfItem;
        float result = instanceToTest.totalPriceIncVATForSalesItem();

        assertEquals(expected, result, "Total prices inc VAT are not equal");
    }

    @Test
    void totalTotalPriceExclVATForSalesItem() {
        float expected  =  item.getPrice()*quantityOfItem;
        float result = instanceToTest.totalPriceExclVATForSalesItem();

        assertEquals(expected, result, "Total prices exl are not equal");
    }

    @Test
    void testTotalVATForSalesItem() {
        float expected = (item.getPrice()*(item.getRateVAT()/100))*quantityOfItem;
        float result = instanceToTest.totalVATForSalesItem();

        assertEquals(expected, result, "Total VAT for sales item are not equal");
    }
}