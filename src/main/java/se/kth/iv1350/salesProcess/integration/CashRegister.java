package se.kth.iv1350.salesProcess.integration;

import se.kth.iv1350.salesProcess.model.Payment;

/**
 * A representation of the cash register. Every register has one instance.
 * This is the interface to that cash register device.
 */
public class CashRegister extends Publisher {
    private double cashBalance;

    /**
     * Create an instance of the cash register.
     * Default is to have a cash balance of 1000
     */
    public CashRegister() {
        this.cashBalance = 1000;
    }

    /**
     * add the payment to the register and update balance in register.
     * @param payment to be added
     */
    public void addPayment(Payment payment) {
        float income = (payment.getPaidAmount() - payment.getChange());
        cashBalance = cashBalance+income;
        notifyObservers(income);
    }

    /**
     * Get the cashBalance
     * @return Cash balance in register
     */
    public double getCashBalance() {
        return cashBalance;
    }

}
