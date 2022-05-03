package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.ItemDTO;

/**
 * Representation of one type of item in the sale and how many of them.
 * Can be seen as an element in a list.
 */
public class SalesItem {
    private int quantityOfItem;
    private ItemDTO salesItem;

    /**
     * Creates one instance of sales item.
     *
     * @param quantityOfItem is the quantity
     * @param salesItem that is being sold
     */
    public SalesItem(int quantityOfItem, ItemDTO salesItem) {
        this.quantityOfItem = quantityOfItem;
        this.salesItem = salesItem;
    }

    /**
     * Add to the quantity of item.
     *
     * @param quantityOfItem in the sales item.
     */
    public void addQuantityOfItem(int quantityOfItem) {
        this.quantityOfItem = this.quantityOfItem + quantityOfItem;
    }

    /**
     * Calculates the price of the type of items including VAT
     *
     * @return the price including VAT
     */
    public float totalPriceIncVATForSalesItem(){
        float vat = salesItem.getPrice()*(salesItem.getRateVAT()/100);
        return (vat + salesItem.getPrice())*quantityOfItem;
    }

    /**
     * Calculates the price of the type of items excluding VAT
     *
     * @return the price excluding VAT
     */
    public float totalPriceExclVATForSalesItem(){
        return salesItem.getPrice()*quantityOfItem;
    }

    /**
     * calculates the total VAT for the type of items
     *
     * @return VAT for the type of items
     */
    public float totalVATForSalesItem(){
        return (salesItem.getPrice()*(salesItem.getRateVAT()/100))*quantityOfItem;
    }

    /**
     * Get the quantity of an item type
     *
     * @return quantity of item
     */
    public int getQuantityOfItem() {
        return quantityOfItem;
    }

    /**
     * Get the item in the element
     *
     * @return the item
     */
    public ItemDTO getSalesItem() {
        return salesItem;
    }
}
