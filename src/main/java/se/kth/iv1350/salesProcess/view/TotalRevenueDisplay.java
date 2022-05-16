package se.kth.iv1350.salesProcess.view;

import se.kth.iv1350.salesProcess.integration.Observer;
import se.kth.iv1350.salesProcess.util.LoggerInterface;

/**
 * Show running total of revenue for sales
 */
public abstract class TotalRevenueDisplay implements Observer, LoggerInterface {
    private float totalRevenue;

    @Override
    public void settledSale(float income ) {
        calculateTotalRevenue(income);
        log("The total revenue for all sales is: " + totalRevenue + " kr");
    }

    /**
     * Calculates new total revenue
     * @param priceOfSettledSale is the total amount of the price for the sales.
     */
    private void calculateTotalRevenue(float  priceOfSettledSale){
        totalRevenue = totalRevenue + priceOfSettledSale;
    }

}
