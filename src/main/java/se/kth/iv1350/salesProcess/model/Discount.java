package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.DiscountRulesDTO;

import static java.lang.Integer.parseInt;

/**
 * Represents the actual discount to be applied on a sale
 */
public class Discount {
    private final SalesItem discountItem;
    private final DiscountRulesDTO ruleForDiscount;
    private final float amountPercentageDiscount;
    private final int quantityDiscount;
    private final float amountQuantityDiscount;

    /**
     * Create an instance of a discount
     * @param discountItem is the item which the discount will be deducted from
     * @param ruleForDiscount the rule to be applied to do the discount
     *
     */
    public Discount(SalesItem discountItem, DiscountRulesDTO ruleForDiscount) {
        this.discountItem = discountItem;
        this.ruleForDiscount = ruleForDiscount;
        this.amountPercentageDiscount = amountPercentageItemDiscount();
        this.quantityDiscount = numberOfItemsForDiscount();
        this.amountQuantityDiscount = amountQuantityDiscount();
    }

    /**
     * Used to set the discountable amount from the percentage rule.
     * @return the amount from the percentage rule
     */
    private float amountPercentageItemDiscount(){
        float price = discountItem.totalPriceIncVATForSalesItem();
        float percentage = ruleForDiscount.getPercentageRule();
        return price*(percentage/100);
    }

    /**
     * Used to set the amount from the using the quantity discount rule
     * @return the amount for the discount using the quantity rule
     */
    private float amountQuantityDiscount(){
        float priceIncVAT = discountItem.getSalesItem().getPrice()*
                (1+discountItem.getSalesItem().getRateVAT()/100);
        return priceIncVAT*quantityDiscount;
    }

    /**
     * Used to convert the rule from string to integers and apply the rule to
     * get the number of items that can be deducted for in discount
     * @return number of items to deduct for in discount
     */
    private int numberOfItemsForDiscount(){
        int quantityOfItem = discountItem.getQuantityOfItem();
        String toPayFor = ruleForDiscount.getQuantityToPayForRule();
        String[] fraction = new String[0];
        int numerator;
        int denominator;
        int discountQuantity = 0;

        if (toPayFor.contains("0")){
            if(toPayFor.contains("/")){
                fraction = toPayFor.split("/", 2);
            } else return 0;
        } else if(toPayFor.contains("/")){
            fraction = toPayFor.split("/", 2);
        }

        numerator = parseInt(fraction[0]);
        denominator = parseInt(fraction[1]);

        if(numerator<quantityOfItem && denominator==quantityOfItem){
            discountQuantity = (denominator-numerator);
        }

        return discountQuantity;
    }

    /**
     * Get the amount of the quantity discount
     * @return amount quantity discount
     */
    public float getAmountQuantityDiscount() {
        return amountQuantityDiscount;
    }

    /**
     * Get the amount for the percentage discount
     * @return the amount for percentage discount
     */
    public float getAmountPercentageDiscount() {
        return amountPercentageDiscount;
    }

    /**
     * Get the amount for the quantity discount
     * @return the amount for the quantity discount
     */
    public int getQuantityDiscount() {
        return quantityDiscount;
    }

    /**
     * Get the discount item
     * @return  the sales item which has discount
     */
    public SalesItem getDiscountItem() {
        return discountItem;
    }

    /**
     * Get the rule applied for the discount
     *
     * @return the discountRuleDTO
     */
    public DiscountRulesDTO getRuleForDiscount() {
        return ruleForDiscount;
    }

}
