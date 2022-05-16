package se.kth.iv1350.salesProcess.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder for the discount database.
 */

public class DiscountDatabase {
    private static final DiscountDatabase DISCOUNT_DATABASE = new DiscountDatabase();
    private List<DiscountData> discounts = new ArrayList<>();

    /**
     * Placeholder for discount database implemented as a singleton
     */
    private DiscountDatabase(){
        addDiscountData();
    }

    /**
     * @return the only existing instance of the singleton discount database.
     */
    public static DiscountDatabase getDiscountDatabase(){
        return DISCOUNT_DATABASE;
    }

    /**
     * Placeholder for discount database before implemented as a singleton
     */
    /*public DiscountDatabase() {
        addDiscountData();
    }
     */

    /**
     * Add all the discounts to the database
     */
    private void addDiscountData() {
        discounts.add(new DiscountData(1, 10, "0", 30, 1));
        discounts.add(new DiscountData(22, 0, "2/3", 20, 22 ));
        discounts.add(new DiscountData(1, 0, "2/3", 20, 22 ));
        discounts.add(new DiscountData(1, 0, "2/3", 20, 333 ));
    }

    /**
     * Check for and retrieve all the applicable rules for the customer id
     *
     * @param customerId used to find all the rules
     * @return an <code>ArrayList<code/> of all the applicable rules for the customer.
     */
    public ArrayList checkCustomerIdentifierForApplicableRules(int customerId){
        ArrayList<DiscountRulesDTO> customerDiscounts = new ArrayList<DiscountRulesDTO>();

        for(DiscountData discountData: discounts){
            if(discountData.getCustomerId()==customerId){
                DiscountRulesDTO newRuleToAdd = new DiscountRulesDTO(discountData.percentageRule,
                        discountData.quantityToPayForRule, discountData.durationOfDiscount, discountData.itemIdentifier);
                customerDiscounts.add(newRuleToAdd);
            }
        }
        return customerDiscounts;
    }

    /**
     * Placeholder class for the discounts in the discount database
     */
    private static class DiscountData {
        private final int customerId;
        private final int percentageRule;
        private final String quantityToPayForRule;
        private final int durationOfDiscount;
        private final int itemIdentifier;


        private DiscountData(int customerId, int percentageRule, String quantityToPayForRule,
                             int durationOfDiscount, int itemIdentifier) {
            this.customerId = customerId;
            this.percentageRule = percentageRule;
            this.quantityToPayForRule = quantityToPayForRule;
            this.durationOfDiscount = durationOfDiscount;
            this.itemIdentifier = itemIdentifier;
        }

        private int getCustomerId(){return customerId;}
    }
}
