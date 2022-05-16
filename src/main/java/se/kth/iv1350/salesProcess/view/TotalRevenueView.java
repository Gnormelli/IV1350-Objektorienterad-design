package se.kth.iv1350.salesProcess.view;

/**
 * Prints log messages to the console on the screen.
 */
public class TotalRevenueView extends TotalRevenueDisplay{

    /**
     * String is printed to console.
     *
     * @param msg to be printed.
     */
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }

}
