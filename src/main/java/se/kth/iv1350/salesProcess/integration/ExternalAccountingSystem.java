package se.kth.iv1350.salesProcess.integration;

import se.kth.iv1350.salesProcess.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder for external accounting system where updates of the
 * accounting information of sales are sent to.
 */
public class ExternalAccountingSystem {
    private List<BookKeepingEntry> bookKeeping = new ArrayList<>();

    /**
     * Placeholder for the update of the external accounting system.
     * Not implemented due to no specification of what information
     * to update the external system with.
     *
     * @param salesInfo to take accounting information from.
     */
    public void updateAccountingSystem(Sale salesInfo) {

    }

    /**
     * Placeholder class for item data from the database
     */
    private static class BookKeepingEntry {
        private final String name;
        private final int itemIdentifier;
        private final float price;
        private final float rateVAT;
        private final String description;

        public BookKeepingEntry(String name, int itemIdentifier, float price,
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

