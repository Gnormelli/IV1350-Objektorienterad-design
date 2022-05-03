package se.kth.iv1350.salesProcess.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.integration.CashRegister;
import se.kth.iv1350.salesProcess.integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private Receipt instanceToTest;
    private  String storeName;
    private  AddressDTO address;
    private  int checkoutNumber;
    private  Sale salesInfo;
    private SalesItem salesItem;
    private int quantityOfItem;
    private ItemDTO item;
    private Payment payment;
    private float amountToPay;

    @BeforeEach
    void setUp() {
        salesInfo = new Sale();
        storeName = "The Store Name";
        address = new AddressDTO("Alley", "1C","103 16", "Stockholm");
        checkoutNumber = 1;
        quantityOfItem = 7;
        item = new ItemDTO("Milk",1, 15, 25, "Green");
        salesItem = new SalesItem(quantityOfItem, item);
        amountToPay = 300;
        payment = new Payment(amountToPay);

        salesInfo.editSale(salesItem);
        salesInfo.pay(payment);

        instanceToTest = new Receipt(salesInfo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateStringReceipt() {
        String expected = storeName+"\n" + address.getStreetName()+" " + address.getStreetNumber()+ "\n"
                + address.getPostalCode() + " " + address.getCity() + "\n"
                + "Date: " + salesInfo.getSaleDate()+"     Time:"+ salesInfo.getSaleTime().getHour()
                + ":"+salesInfo.getSaleTime().getMinute()+"\n"
                + "Checkout Number: "+ checkoutNumber+"\n"
                +"Purchase Number: "+ salesInfo.getSalesNumber()+"\n";
        String result = instanceToTest.createStringReceipt();
        assertTrue(result.contains(expected), "wrong print out");
        assertTrue(result.contains(item.getName()));
        assertTrue(result.contains(Float.toString(salesItem.totalPriceIncVATForSalesItem())));
        assertTrue(result.contains(Float.toString(salesInfo.calculateTotalAmountToPay())));
        assertTrue(result.contains(Integer.toString(Math.round(payment.getChange()))));
    }
}