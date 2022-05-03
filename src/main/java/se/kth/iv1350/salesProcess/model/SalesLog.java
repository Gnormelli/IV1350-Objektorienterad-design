package se.kth.iv1350.salesProcess.model;

import se.kth.iv1350.salesProcess.integration.ExternalAccountingSystem;
import se.kth.iv1350.salesProcess.integration.ExternalInventorySystem;
import se.kth.iv1350.salesProcess.integration.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the sales log
 */
public class SalesLog {
    private final List<Sale> salesLogList;
    private final ExternalInventorySystem EIS;
    private final ExternalAccountingSystem EAS;


    /**
     * Create an instance of the sales log
     *  @param EIS is the external inventory system
     * @param EAS is the external accounting system
     */
    public SalesLog(ExternalInventorySystem EIS, ExternalAccountingSystem EAS) {
        salesLogList = new ArrayList<>();
        this.EIS = EIS;
        this.EAS = EAS;
    }


    /**
     * Add a sale to the sales log
     *
     * @param salesInfo to be added to the sales log
     */
    public void logSale(Sale salesInfo) {
        salesInfo.setSalesNumber(salesLogList.size()+1);
        salesLogList.add(salesInfo);
    }

    /**
     *  Update the sale in the external Systems
     *
     * @param salesInfo Sale with information to update
     */
    public void updateSaleInSystems(Sale salesInfo) {
        salesLogList.set(salesLogList.size()-1, salesInfo);

        EIS.updateInventorySystem(salesInfo);
        EAS.updateAccountingSystem(salesInfo);
    }
}
