package se.kth.iv1350.salesProcess.view;

import se.kth.iv1350.salesProcess.controller.Controller;
import se.kth.iv1350.salesProcess.controller.OperationFailedException;
import se.kth.iv1350.salesProcess.integration.*;
import se.kth.iv1350.salesProcess.model.*;
import se.kth.iv1350.salesProcess.util.AuditTrailLogHandler;
import se.kth.iv1350.salesProcess.util.TotalRevenueFileOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A placeholder for the real view with hardcoded calls to simulate the
 * system operations to the controller.
 */
public class View {
    private final Controller contr;
    private List<RegisteredItemDTO> basketOfItems;
    private AuditTrailLogHandler logger;

    /**
     * Constructor for the view.
     *
     * @param contr is the controller in the architectural pattern.
     */
    public View(Controller contr) throws IOException {
        this.contr = contr;
        this.logger = new AuditTrailLogHandler();
        contr.addObserver(new TotalRevenueView());
        contr.addObserver(new TotalRevenueFileOutput());
    }

    /**
     * Placeholder that simulates user input to this program.
     */
    public void simulatorOfExecution(Scanner scan){
        SalesItem addedItem;

        contr.startNewSale();
        System.out.println("A new sale has been started.");

        basketOfItems = new ArrayList<>();
        addBasketOfItems();
        for(RegisteredItemDTO item : basketOfItems) {
            try {
                addedItem = contr.addItemToSale(item);
                System.out.println(printUpdateInList(addedItem));
            } catch (InvalidItemIdentifierException excp) {
                ErrorMessageHandler.buildPrintErrorMessage(excp.getMessage());
            } catch (OperationFailedException excp) {
                writeInUIAndLog("Item could not be added.",
                        (Exception) excp.getCause());
            }
        }

        float totalPriceIncVAT = contr.endSale();
        System.out.println("Total price inc VAT for purchase: " + totalPriceIncVAT + " kr");

        boolean wantsDiscount = askIfCustomerWantsDiscount(scan);
        if(wantsDiscount){
            float amountToPay = contr.requestDiscount(1);
            System.out.println("Total amount to pay incl discount: " + amountToPay + " kr");
        }

        float paidAmount = 400;
        System.out.println("Paid amount: " + paidAmount + " kr");
        contr.enterCashPayment(paidAmount);

    }

    /**
     * Print the update in the list of items
     * @param addedItem the item that has been added
     * @return string of update in list.
     */
    private String printUpdateInList(SalesItem addedItem){
        int quantity = addedItem.getQuantityOfItem();
        String itemName = addedItem.getSalesItem().getName();
        float priceExclVAT = addedItem.totalPriceExclVATForSalesItem();
        float VAT = addedItem.totalVATForSalesItem();
        float priceIncVAt = addedItem.totalPriceIncVATForSalesItem();

        StringBuilder builder = new StringBuilder();
        builder.append("Item name: ").append(itemName).append(", ");
        builder.append("Quantity: " + quantity + ", ");
        builder.append("Prince Excl VAT : " + priceExclVAT + "kr, ");
        builder.append("VAT: " + VAT + "kr, ");
        builder.append("Total price inc VAT For item: " + priceIncVAt + "kr");

        return builder.toString();
    }

    /**
     * Cashier asks customer if they want discount
     * @param scan scanner for the program
     * @return boolean igf they want discount
     */
    private boolean askIfCustomerWantsDiscount(Scanner scan){
        System.out.println("Customer wants discount? Enter YES or NO: \n");
        String wantDiscountString = scan.nextLine();
        boolean wantDiscount;

        if (wantDiscountString.equals("YES")){
            wantDiscount = true;
        }else{
            wantDiscount = false;
        }
        return wantDiscount;
    }

    /**
     * Placeholder for the basket of items to be added to the sale
     */
    private void addBasketOfItems(){
        basketOfItems.add(new RegisteredItemDTO(3,55555));
        basketOfItems.add(new RegisteredItemDTO(2,333));
        basketOfItems.add(new RegisteredItemDTO(3,55555));
        basketOfItems.add(new RegisteredItemDTO(1,666666));
        basketOfItems.add(new RegisteredItemDTO(1,123456));
        basketOfItems.add(new RegisteredItemDTO(1,333));
        basketOfItems.add(new RegisteredItemDTO(2,1));
        basketOfItems.add(new RegisteredItemDTO(1,666666));
        basketOfItems.add(new RegisteredItemDTO(1,123456));
        basketOfItems.add(new RegisteredItemDTO(1,55555));
    }

    /**
     * Method for directing error messaging output
     * @param UiError to be displayed on UI but now in console
     * @param excp to be entered in log file
     */
    private void writeInUIAndLog(String UiError, Exception excp ){
        ErrorMessageHandler.buildPrintErrorMessage(UiError);
        logger.makeALog(String.valueOf(excp));
    }
}
