package se.kth.iv1350.salesProcess.model;

/**
 * Representation of a payment
 */
public class Payment {
    private final float paidAmount;
    private float change;

    /**
     * Creates a new instance of a payment
     *
     * @param paidAmount the paid amount
     */
    public Payment(float paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * Calculated the change for cash payment.
     *
     * @param salesInfo information of sale to calculate change for.
     */
    public void calculateChange(Sale salesInfo){
        change = paidAmount-salesInfo.calculateTotalAmountToPay();
    }

    /**
     * Get the paid amount
     *
     * @return paid amount
     */
    public float getPaidAmount() {
        return paidAmount;
    }

    /**
     * Get the change for the payment
     *
     * @return change for payment
     */
    public float getChange() {
        return change;
    }

}
