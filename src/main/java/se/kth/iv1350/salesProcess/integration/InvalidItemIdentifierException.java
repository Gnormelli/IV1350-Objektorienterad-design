package se.kth.iv1350.salesProcess.integration;

/**
 * Thrown when an itemIdentifier has been registered that is not in the ExternalInventorySystem
 */
public class InvalidItemIdentifierException extends Exception{
    private int itemIdentifier;

    /**
     * A new instance with a message specifying which item identifier could not be found is created
     * @param itemIdentifier that is not found in the database of external inventory system
     */
    public InvalidItemIdentifierException(int itemIdentifier) {
        super("The item with the item identifier " + itemIdentifier + " could not be found.");
        this.itemIdentifier = itemIdentifier;
    }

    /**
     * @return the item identifier that could not be found.
     */
    public int getItemIdentifier() {
        return itemIdentifier;
    }
}
