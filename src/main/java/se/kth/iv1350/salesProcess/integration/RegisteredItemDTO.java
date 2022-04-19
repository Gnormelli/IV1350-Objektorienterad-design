package se.kth.iv1350.salesProcess.integration;

/**
 * Represent registered item identifier and quantity in the view, ready
 * for processing in the program.
 */
public class RegisteredItemDTO {
    private final int quantity;
    private final int itemIdentifier;

    /**
     * Constructor for the instantiation of one item to search for.
     * 
     * @param quantity  how many of the item for sale have been registered
     * @param itemIdentifier item identifier specifies a type of item for sale
     */
    public RegisteredItemDTO(int quantity, int itemIdentifier) {
        this.quantity = quantity;
        this.itemIdentifier = itemIdentifier;
    }

    /**
     * Get the item identifier.
     *
     * @return the value of item identifier
     */
    public int getItemIdentifier(){
        return itemIdentifier;
    }

    /**
     * Get quantity of item.
     *
     * @return value of quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }
}
