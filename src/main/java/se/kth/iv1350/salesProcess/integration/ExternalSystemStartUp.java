package se.kth.iv1350.salesProcess.integration;

/**
 * Class for starting up external systems
 */
public class ExternalSystemStartUp {
    private final ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
    private final ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
    private final ElectronicPaymentSystem electronicPaymentSystem = new ElectronicPaymentSystem();
    private final DiscountDatabase discountDatabase = DiscountDatabase.getDiscountDatabase();

    /**
     * Get the external accounting system data
     *
     * @return values in external accounting system
     */
    public ExternalAccountingSystem getExternalAccountingSystem() {
        return externalAccountingSystem;
    }

    /**
     * Get the external inventory system data
     *
     * @return values in external inventory system
     */
    public ExternalInventorySystem getExternalInventorySystem() {
        return externalInventorySystem;
    }

    /**
     * Get the external payments system data or connection
     * Undefined what the system is, but that it´s needed for electronic payment
     *
     * @return the value of external payment system
     */
    public ElectronicPaymentSystem getElectronicPaymentSystem() {
        return electronicPaymentSystem;
    }

    /**
     * Get the data from the external discount database
     *
     * @return values of discount database
     */
    public DiscountDatabase getDiscountDatabase() {
        return discountDatabase;
    }
}
