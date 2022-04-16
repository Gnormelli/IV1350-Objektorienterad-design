package se.kth.iv1350.salesProcess.integration;

/**
 * Represents the rules for discount on items.
 */
public class DiscountRulesDTO {
    private final int percentageRule;
    private final float quantityToPayForRule;
    private final int durationOfDiscount;
    private final ItemDTO discountItem;

    /**
     *
     * Constructor for one instance of discount for item
     *
     * @param percentageRule to apply
     * @param quantityToPayForRule to apply
     * @param durationOfDiscount to see if discount valid
     * @param discountItem instance of one item that discount applies to 
     */

    public DiscountRulesDTO(int percentageRule, float quantityToPayForRule, int durationOfDiscount, ItemDTO discountItem) {
        this.percentageRule = percentageRule;
        this.quantityToPayForRule = quantityToPayForRule;
        this.durationOfDiscount = durationOfDiscount;
        this.discountItem = discountItem;
    }


    /**
     * Get the percentage discount rule
     *
     * @return value of percentage discount
     */
    public int getPercentageRule() {
        return percentageRule;
    }

    /**
     * Get the quantity to pay for of an item
     *
     * @return value of the quantity to pay for
     */
    public float getQuantityToPayForRule() {
        return quantityToPayForRule;
    }

    /**
     * Get the duration of the discount
     *
     * @return value of the duration of discount
     */
    public int getDurationOfDiscount() {
        return durationOfDiscount;
    }

    /**
     * get the item whit discount
     *
     * @return the item with discount
     */
    public ItemDTO getDiscountItem() {
        return discountItem;
    }
}
