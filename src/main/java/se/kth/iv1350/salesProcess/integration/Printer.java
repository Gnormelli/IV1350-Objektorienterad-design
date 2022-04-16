package se.kth.iv1350.salesProcess.integration;

import se.kth.iv1350.salesProcess.model.Receipt;

/**
 * Interface to the printer device. Placeholder that prints in
 * the terminal.
 */
public class Printer {

    public Printer(){}

    /**
     * Print the receipt. This is placeholder only printing using
     * <code>System.out</code> instead of real printer device.
     *
     * @param receipt the receipt of the sale
     */
    public void printReceipt(Receipt receipt){
        System.out.println();
    }
}
