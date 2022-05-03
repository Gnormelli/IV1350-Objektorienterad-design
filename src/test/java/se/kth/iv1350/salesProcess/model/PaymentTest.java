package se.kth.iv1350.salesProcess.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Payment instanceToTest;
    private Sale salesInfo;
    private ItemDTO item;
    private SalesItem saleItem;
    private float paidAmount = 300;

    @BeforeEach
    void setUp() {
        instanceToTest = new Payment(paidAmount);
        salesInfo = new Sale();
        item = new ItemDTO("Milk",1, 15, 25, "Green");
        saleItem = new SalesItem(1, item);
        salesInfo.editSale(saleItem);

    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        salesInfo = null;
        item = null;
        saleItem = null;

    }

    @Test
    void testCalculateChange() {
        float expected = paidAmount-item.getPrice()*(1+item.getRateVAT()/100);
        instanceToTest.calculateChange(salesInfo);
        float result = instanceToTest.getChange();

        assertEquals(expected, result, "Wrong change calculated");
    }

    @Test
    void testGetChange() {
        float expected = paidAmount-item.getPrice()*(1+item.getRateVAT()/100);
        instanceToTest.calculateChange(salesInfo);
        float result = instanceToTest.getChange();

        assertEquals(expected, result, "Wrong change calculated");
    }
}