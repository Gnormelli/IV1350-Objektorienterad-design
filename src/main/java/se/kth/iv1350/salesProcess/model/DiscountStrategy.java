package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.DiscountRulesDTO;

/**
 * Interface for calculating discount. Implemented in classes to provide
 * calculation of discount algorithm.
 */
public interface DiscountStrategy {

    /**
     * Calculate the discount for SalesItem using DiscountRuleDTO
     * @param discountItem that is to be discounted for.
     * @param ruleForDiscount to apply on item.
     * @return amount that is to be discounted.
     */
    float calculateDiscount(SalesItem discountItem, DiscountRulesDTO ruleForDiscount);
}
