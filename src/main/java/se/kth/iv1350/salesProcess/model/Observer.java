package se.kth.iv1350.salesProcess.model;

/**
 * Observing interface for classes to get notified of settlement of sale with payment.
 */
public interface Observer {

    /**
     * Invoked when sale is paid for and receipt is to be printed.
     *
     * @param salesInfo Sale that is settled.
     */
    void settledSale(Sale salesInfo );
}
