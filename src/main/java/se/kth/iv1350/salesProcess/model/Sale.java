package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.DiscountRulesDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents one particular sales transaction, where items are added.
 * Discounts can be applied and payments received.
 */
public class Sale {
    private final LocalTime saleTime;
    private final LocalDate saleDate;
    private int salesNumber;
    private ArrayList<SalesItem> items;
    private ArrayList<Discount> discounts;
    private Payment payment;

    /**
     * Create one instance of a sale
     */
    public Sale() {
        this.saleTime = LocalTime.now();
        this.saleDate = LocalDate.now();
        this.items = new ArrayList<SalesItem>();
        this.discounts = new ArrayList<Discount>();
    }

    /**
     * Edits the sale by deciding on updating item quantity or adding the item to sale.
     *
     * @param newItem the new item decide to add or update quantity in the sale
     */
    public SalesItem editSale(SalesItem newItem){
        SalesItem addedItem = null;
        boolean updatedList = false;
        int listIndex = 0;
        for (SalesItem itemInList: items){
            if(itemInList.getSalesItem().getItemIdentifier()==newItem.getSalesItem().getItemIdentifier()){
                addedItem = updateItemQuantityInSale(newItem, listIndex);
                updatedList= true;
            }
            listIndex=listIndex+1;
        }

        if(!updatedList){
            addItemInList(newItem);
            addedItem = newItem;
        }
        return addedItem;
    }

    /**
     * Add a new item to the list of items in the sale
     *
     * @param newItem for sale to add in the list
     */
    private void addItemInList(SalesItem newItem) {
        items.add(newItem);
    }

    /**
     * Update quantity of a sales item in the list that is for sale
     *
     * @param newItem the type of item what is to be added
     * @param listIndex is the list index of the type of item to update.
     */
    private SalesItem updateItemQuantityInSale(SalesItem newItem, int listIndex){
        SalesItem itemInList = items.get(listIndex);
        itemInList.addQuantityOfItem(newItem.getQuantityOfItem());

        return itemInList;
    }

    /**
     * Calculate the total price including VAT.
     * Gives the side effect of setting the total price of the sale and
     * the total VAT of the sale.
     *
     * @return the total price including VAT of the sale.
     */
    public float calculateTotalPriceIncVAT(){
        float totalPriceExclVATForSale = 0;
        float totalVATForSale = 0;
        for (SalesItem itemInList : items ){
            totalPriceExclVATForSale = totalPriceExclVATForSale + itemInList.totalPriceExclVATForSalesItem();
            totalVATForSale = totalVATForSale + itemInList.totalVATForSalesItem();
        }
        return totalPriceExclVATForSale + totalVATForSale;
    }

    /**
     * Calculate the sum of the discounts in sale
     * @return the sum of the discounts
     */
    public float calculateSummaryDiscount(){
        float pricePercentage = 0;
        float priceQuantity = 0;

        for (Discount elem : discounts){

            if(elem.getAmountPercentageDiscount()!=0){
                pricePercentage = pricePercentage + elem.getAmountPercentageDiscount();
            }

            if(elem.getAmountQuantityDiscount()!=0){
                priceQuantity = priceQuantity + elem.getAmountQuantityDiscount();
            }
        }

        return pricePercentage + priceQuantity;
    }

    /**
     *  Calculate the total amount to pay including VAT and deducted discount
     *
     * @return the amount to pay
     */
    public float calculateTotalAmountToPay(){
        float totalAmount = calculateTotalPriceIncVAT();
        float toDeduct = calculateSummaryDiscount();

        return totalAmount-toDeduct;
    }

    /**
     * Pay for the sale
     *
     * @param payment with the amount to pay for the sale
     */
    public void pay(Payment payment){
        payment.calculateChange(this);
        this.payment = payment;
    }

    /**
     * Create and add the discounts for the sale
     * @param applicableDiscountRuleDTOs are the rules to apply if possible
     */
    public void createDiscountsForSale(ArrayList<DiscountRulesDTO> applicableDiscountRuleDTOs) {
        for(DiscountRulesDTO discountRules: applicableDiscountRuleDTOs){
            for(SalesItem salesItem : items){
                if(discountRules.getDiscountItemIdentifier()==salesItem.getSalesItem().getItemIdentifier()){
                    discounts.add(new Discount(salesItem,discountRules));
                }
            }
        }
    }

    /**
     * Get the time of sale
     *
     * @return time of the sale
     */
    public LocalTime getSaleTime() {
        return saleTime;
    }

    /**
     * Get date of sale
     *
     * @return date of the sale
     */
    public LocalDate getSaleDate() {
        return saleDate;
    }

    /**
     * Get list of the items in the sale
     * @return list of items
     */
    public ArrayList<SalesItem> getItems() {
        return items;
    }

    /**
     * Get the list of all the discounts for the sale
     *
     * @return list of discounts
     */
    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    /**
     * Get the payment for the sale
     * @return payment for the sale
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Set number for the sale
     * @param number integer set for the number of the sale
     */
    public void setSalesNumber(int number) {
        this.salesNumber = number;
    }

    /**
     * Get the number of the sale
     *
     * @return returns number of sales
     */
    public int getSalesNumber() {
        return salesNumber;
    }
}
