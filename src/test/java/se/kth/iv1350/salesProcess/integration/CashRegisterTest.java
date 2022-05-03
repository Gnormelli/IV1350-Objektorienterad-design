package se.kth.iv1350.salesProcess.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.salesProcess.model.Payment;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    CashRegister instanceToTest;
    CashRegister toCompair;
    Payment payment;
    int amountPaid;

    @BeforeEach
    void setUp() {
        instanceToTest=new CashRegister();
        toCompair = new CashRegister();
        amountPaid = 100;
        payment=new Payment(amountPaid);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        toCompair = null;
        payment = null;
    }

    @Test
    void testAddPayment() {
        toCompair.addPayment(payment);
        instanceToTest.addPayment(payment);
        Double expected = toCompair.getCashBalance();
        Double result = instanceToTest.getCashBalance();
        assertEquals(expected, result, "The to cash registers are not adding the same");
    }
}