package se.kth.iv1350.salesProcess.integration;

import se.kth.iv1350.salesProcess.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 *  Placeholder for inventory system that holds the items possible to buy.
 */
public class ExternalInventorySystem {
    private List<ItemData> inventoryItems = new ArrayList<>();

    ExternalInventorySystem(){
        addItem();
    }

    /**
     * Checks in the placeholder database for the item identifier.
     *
     * @param registeredItemDTO to check if the item is in external inventory system.
     * @return itemDTO if found or null.
     */
    public ItemDTO findItemInInventory(RegisteredItemDTO registeredItemDTO) {
        for(ItemData item : inventoryItems){
            if(item.getItemIdentifier() == registeredItemDTO.getItemIdentifier()){
                return new ItemDTO(item.name, item.itemIdentifier,item.price,
                        item.rateVAT, item.description);
            }
        }
        return null;
    }

    /**
     * Placeholder data in database
     */
    private void addItem(){
        inventoryItems.add(new ItemData("Milk", 1, 15, 12.5f,"1,5% Fet, green"));
        inventoryItems.add(new ItemData("Pop-corn", 22, 30, 12.5f,"Sea salted"));
        inventoryItems.add(new ItemData("Hamburger", 333, 50, 12.5f,"Cow"));
        inventoryItems.add(new ItemData("Toilet paper", 4444, 25, 25f,"Extra soft"));
        inventoryItems.add(new ItemData("Dishrag", 55555, 15, 25f,"Blue"));
    }

    /**
     * Used to update the external inventory system with the
     * information of what items have been sold
     * @param salesInfo All information of the sale
     */
    public void updateInventorySystem(Sale salesInfo) {
    }

    /**
     * Placeholder class for item data from the inventory database
     */
    private static class ItemData {
        private final String name;
        private final int itemIdentifier;
        private final float price;
        private final float rateVAT;
        private final String description;

        public ItemData(String name, int itemIdentifier, float price,
                        float rateVAT, String description) {
            this.name = name;
            this.itemIdentifier = itemIdentifier;
            this.price = price;
            this.rateVAT = rateVAT;
            this.description = description;
        }

        public int getItemIdentifier() {
            return itemIdentifier;
        }
    }
}
