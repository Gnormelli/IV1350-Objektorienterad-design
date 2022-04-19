package se.kth.iv1350.salesProcess.integration;

import java.util.ArrayList;
import java.util.List;

/**
 *  Placeholder for inventory system that holds the items possible to buy.
 */
public class ExternalInventorySystem {
    private List<itemData> databaseItems = new ArrayList<>();

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
        for(itemData item :databaseItems){
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
        databaseItems.add(new itemData("Milk", 1, 15, 12.5f,"1,5% Fet, green"));
        databaseItems.add(new itemData("Pop-corn", 22, 30, 12.5f,"Sea salted"));
        databaseItems.add(new itemData("Hamburger", 333, 50, 12.5f,"Cow"));
        databaseItems.add(new itemData("Toilet paper", 4444, 25, 25f,"Extra soft"));
        databaseItems.add(new itemData("Dishrag", 55555, 15, 25f,"Blue"));
    }

    /**
     * Placeholder item data from the database
     */
    private static class itemData {
        private String name;
        private int itemIdentifier;
        private float price;
        private float rateVAT;
        private String description;

        public itemData(String name, int itemIdentifier, float price,
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
