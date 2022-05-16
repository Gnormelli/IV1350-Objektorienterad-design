package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.DiscountRulesDTO;
import static java.lang.Integer.parseInt;

/**
 * A <code>DiscountStrategy<code/> that calculated discount with the rule of item quantity
 */
class CalculateQuantityDiscount implements DiscountStrategy{
    private int quantityDiscount;

    CalculateQuantityDiscount(){
    }

    @Override
    public float calculateDiscount(SalesItem discountItem, DiscountRulesDTO ruleForDiscount) {
        this.quantityDiscount = numberOfItemsForDiscount(discountItem, ruleForDiscount);
        float priceIncVAT = discountItem.getSalesItem().getPrice()*
                (1+discountItem.getSalesItem().getRateVAT()/100);
        return priceIncVAT*quantityDiscount;
    }

    /**
     * Previously implemented in <code>Discount<code/>
     * Used to convert the rule from string to integers and apply the rule to
     * get the number of items that can be deducted for in discount
     * @return number of items to deduct for in discount
     */
    private int numberOfItemsForDiscount(SalesItem discountItem, DiscountRulesDTO ruleForDiscount){
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
     * Needed to make the discount have the quantity
     * @return the quantity of item for the discount
     */
    public int getQuantityDiscount() {
        return quantityDiscount;
    }
}
