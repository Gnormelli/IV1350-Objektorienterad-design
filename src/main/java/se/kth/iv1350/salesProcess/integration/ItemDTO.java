package se.kth.iv1350.salesProcess.integration;

/**
 * Representation of one item.
 * Information retrieved from the external inventory system.
 */
public class ItemDTO {
    private final String name;
    private final int itemIdentifier;
    private final float price;
    private final float rateVAT;
    private final String description;

    /**
     * Create one instance of a itemDTO
     *
     * @param name of the item
     * @param itemIdentifier for the item
     * @param price of the item
     * @param rateVAT of the item
     * @param description of the item
     */
    public ItemDTO(String name, int itemIdentifier, float price, float rateVAT, String description) {
        this.name = name;
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.rateVAT = rateVAT;
        this.description = description;
    }

    /**
     * Get the name of the item
     *
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Get item identifier for the item
     *
     * @return item identifier for the item
     */
    public int getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * Get price of the item
     *
     * @return price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Get rate of VAT for the item
     *
     * @return rate of VAT for the item
     */
    public float getRateVAT() {
        return rateVAT;
    }

    /**
     * Get the description for the item
     *
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }
}
