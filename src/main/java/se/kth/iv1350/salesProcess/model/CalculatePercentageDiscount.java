package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.DiscountRulesDTO;

/**
 * A <code>DiscountStrategy<code/> that calculated discount with the rule of percentage
 */
class CalculatePercentageDiscount implements DiscountStrategy{
    CalculatePercentageDiscount() {
    }

    /**
     * Calculate percentage discount.
     * @param discountItem applicable for discount.
     * @param ruleForDiscount the rule to apply.
     * @return the price of the item times the percentage discount.
     */
    @Override
    public float calculate(SalesItem discountItem, DiscountRulesDTO ruleForDiscount) {
        float price = discountItem.totalPriceIncVATForSalesItem();
        float percentage = ruleForDiscount.getPercentageRule();
        return price*(percentage/100);
    }
}
