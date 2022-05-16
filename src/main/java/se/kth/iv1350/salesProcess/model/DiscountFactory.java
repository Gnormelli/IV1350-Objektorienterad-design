package se.kth.iv1350.salesProcess.model;

/**
 * Singleton of factory instance used for calculation of discount. All instances
 * must use <code>DiscountStrategy</code>.
 */
public class DiscountFactory {
    private static final DiscountFactory DISCOUNT_FACTORY = new DiscountFactory();
    private CalculatePercentageDiscount CPD = new CalculatePercentageDiscount();
    private CalculateQuantityDiscount CQD = new CalculateQuantityDiscount();

    /**
     * Create instance of factory constructor
     */
    private DiscountFactory(){}

    /**
     * @return only instance of this singleton
     */
    public static DiscountFactory getDiscountFactory(){
        return DISCOUNT_FACTORY;
    }

    /**
     * @return calculation of percentage discount implementation so <code>DiscountStrategy</code>
     * can run algorithm.
     */
    public CalculatePercentageDiscount getCPD() {
        return CPD;
    }

    /**
     * @return calculation of quantity discount implementation so <code>DiscountStrategy</code>
     * can run algorithm.
     */
    public CalculateQuantityDiscount getCQD() {
        return CQD;
    }

}
