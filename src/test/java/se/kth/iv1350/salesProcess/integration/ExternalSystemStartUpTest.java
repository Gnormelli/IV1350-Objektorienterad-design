package se.kth.iv1350.salesProcess.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalSystemStartUpTest {
    private ExternalSystemStartUp instanceToTest;

    ExternalAccountingSystem EAS;
    ExternalInventorySystem EIS;
    ElectronicPaymentSystem EPS;
    DiscountDatabase DDB;

    @BeforeEach
    void setUp() {
        instanceToTest = new ExternalSystemStartUp();
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testCreateExternalAccountingSystem(){
        EAS = instanceToTest.getExternalAccountingSystem();
        assertTrue(EAS instanceof ExternalAccountingSystem, "ExternalSystemStartUp did not create ExternalAccountingSystem");
    }

    @Test
    public void testCreateExternalInventorySystem(){
        EIS = instanceToTest.getExternalInventorySystem();
        assertTrue(EIS instanceof ExternalInventorySystem, "ExternalSystemStartUp did not create ExternalInventorySystem");
    }

    @Test
    public void testCreateElectronicPaymentSystem(){
        EPS = instanceToTest.getElectronicPaymentSystem();
        assertTrue(EPS instanceof ElectronicPaymentSystem, "ExternalSystemStartUp did not create ElectronicPaymentSystem");
    }

    @Test
    public void testCreateDiscountDatabase(){
        DDB = instanceToTest.getDiscountDatabase();
        assertTrue(DDB instanceof DiscountDatabase, "ExternalSystemStartUp did not create DiscountDatabase");
    }
}