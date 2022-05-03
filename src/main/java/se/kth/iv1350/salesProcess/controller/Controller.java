package se.kth.iv1350.salesProcess.controller;

import java.util.ArrayList;
import se.kth.iv1350.salesProcess.integration.*;
import se.kth.iv1350.salesProcess.integration.CashRegister;
import se.kth.iv1350.salesProcess.model.*;

/**
 * The controller class for this application.
 * Makes all the calls to the model from the view through this controller.
 * <p>
 * To make a sale first the <code>startNewSale</code> has to be called. Then items
 * has to be added to the sale through <code>addItemToSale</code> followed by <code>endSale</code>
 * and <code>enterCashPayment</code>
 * </p>
 * <ol>
 * <li><code>startNewSale</code>
 * <li><code>addItemToSale</code>
 * <li><code>endSale</code>
 * <li><code>enterCashPayment</code>
 * </ol>
 * All ca
 */
public class Controller {
    private final ExternalInventorySystem EIS;
    private final ExternalAccountingSystem EAS;
    private final DiscountDatabase DDB;
    private final ElectronicPaymentSystem EPS;
    private final Printer printer;
    private final CashRegister cashRegister;
    private Sale salesInfo;
    private final SalesLog salesLog;

    /**
     * Create an instance of the controller
     *
     * @param creator with all the external systems and databases that can be accessed
     * @param printer interface to the printer device
     * @param cashRegister interface to the cash register device
     */
    public Controller(ExternalSystemStartUp creator, Printer printer, CashRegister cashRegister) {
        this.EAS = creator.getExternalAccountingSystem();
        this.EIS = creator.getExternalInventorySystem();
        this.DDB = creator.getDiscountDatabase();
        this.EPS = creator.getElectronicPaymentSystem();
        this.printer = printer;
        this.cashRegister = cashRegister;
        this.salesLog = new SalesLog(EIS, EAS, printer);
    }

    /**
     * Starts a new sale. Called before adding anything to the sale.
     */
    public void startNewSale(){
        salesInfo = new Sale();
    }

    /**
     * Search for a matching item identifier in external inventory system
     *
     * @param registeredItemDTO This object has the search criteria. Ignore
     *                          fields in object that has <code>null</code> or
     *                          <code>0</code>.
     * @return itemDTO from the database that has matching item identifier
     */
    public SalesItem addItemToSale(RegisteredItemDTO registeredItemDTO){
         ItemDTO itemDTO = EIS.findItemInInventory(registeredItemDTO);
         SalesItem newItem = new SalesItem(registeredItemDTO.getQuantity(), itemDTO);
         return salesInfo.editSale(newItem);
    }

    /**
     * End sale by logging the sale and return the total price
     * including VAT to pay with no discount deducted.
     *
     * @return Total price including the VAT for the sale
     */
    public float endSale() {
        float totalPriceIncVAT = salesInfo.calculateTotalPriceIncVAT();
        salesLog.logSale(salesInfo);

        return totalPriceIncVAT;
    }

    /**
     * Takes customer identifier and returns the total
     * discount deducted amount to pay for the sale.
     *
     * @param customerIdentifier provided by customer
     * @return the amount to pay with deducted discount.
     */
    public float requestDiscount(int customerIdentifier){
        ArrayList<DiscountRulesDTO> applicableDiscountRuleDTOs = DDB.checkCustomerIdentifierForApplicableRules(customerIdentifier);
        salesInfo.createDiscountsForSale(applicableDiscountRuleDTOs);

        return salesInfo.calculateTotalAmountToPay();
    }


    /**
     * Used to enter the cash payment for the sale. Updates the balance in
     * cash register. Updates the sale in external systems which also prints
     * the receipt.
     *
     * @param paidAmount is the amount the customer pays
     */
    public void enterCashPayment(float paidAmount) {
        Payment payment = new Payment(paidAmount);

        salesInfo.pay(payment);
        cashRegister.addPayment(payment);
        salesLog.updateSaleInSystems(salesInfo);

        Receipt receipt = new Receipt(salesInfo);
        printer.printReceipt(receipt);
    }
}
