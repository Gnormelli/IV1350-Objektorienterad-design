package se.kth.iv1350.salesProcess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * All collects all the information of a sale to be printed on
 * the actual receipt.
 */
public class Receipt {
    private final String storeName;
    private final AddressDTO address;
    private final int checkoutNumber;
    private final Sale salesInfo;

    /**
     * Create an instance of a receipt
     *
     * @param salesInfo the sale tp create the receipt from
     */
    public Receipt(Sale salesInfo) {
        this.salesInfo = salesInfo;
        this.storeName = "The Store Name";
        this.address = new AddressDTO("Alley", "1C","103 16", "Stockholm");
        this.checkoutNumber = 1;
    }

    /**
     * Retrieve a string that is the receipt
     * @return
     */
    public String retrieveStringReceipt(){
        String stringReceipt = createStringReceipt();
        return stringReceipt;
    }

    /**
     * Create the string representation for the receipt
     *
     * @return string representation of the receipt
     */
    private String createStringReceipt(){
        StringBuilder builder = new StringBuilder();
        builder.append("    ________Receipt________    "+"\n");
        builder.append(storeName+"\n");
        builder.append(address.getStreetName()+" "+ address.getStreetNumber()+"\n");
        builder.append(address.getPostalCode()+" "+ address.getCity()+"\n");
        builder.append("Date: " + salesInfo.getSaleDate()+"     Time:"+ salesInfo.getSaleTime().getHour()+
                ":"+salesInfo.getSaleTime().getMinute()+"\n");
        builder.append("Checkout Number: "+ checkoutNumber+"\n");
        builder.append("Purchase Number: "+ salesInfo.getSalesNumber()+"\n");

        builder.append("    _______________________    "+"\n");

        for(SalesItem item: salesInfo.getItems()){
            builder.append(
                    item.getSalesItem().getName() +
                    "\t\t\t\t\t"+
                    item.totalPriceIncVATForSalesItem()+" kr "+
                    "\n"
            );
            if(item.getQuantityOfItem()>1){
                builder.append("  "+ item.getQuantityOfItem()+
                        " st x " + item.getSalesItem().getPrice() * (1+item.getSalesItem().getRateVAT()/100)
                        +
                        "\n"
                );
            }
        }
        builder.append("    _______________________    "+"\n");
        builder.append("Discounts:\n");

        for(Discount discount: salesInfo.getDiscounts()){
            if(discount.getAmountPercentageDiscount()!=0){
                builder.append(
                        discount.getDiscountItem().getSalesItem().getName() +
                                " " +
                                discount.getRuleForDiscount().getPercentageRule()+"% "+
                                "\t\t\t\t\t"+
                                "-"+discount.getAmountPercentageDiscount()+" kr "+
                                "\n"
                );
            }

            if(discount.getQuantityDiscount()!= 0){
                builder.append(
                        discount.getDiscountItem().getSalesItem().getName() +
                                " " +
                                discount.getQuantityDiscount()+"st for free"+
                                "\t\t"+
                                "-"+discount.getQuantityDiscount()*
                                (discount.getDiscountItem().getSalesItem().getPrice()*
                                (1+discount.getDiscountItem().getSalesItem().getRateVAT()/100))+" kr "+
                                "\n"
                );
            }
        }
        builder.append("    _______________________    "+"\n");
        builder.append("Summary discounts for this purchase\n");

        builder.append(
                "\t\t\t\t\t\t\t "+
                salesInfo.calculateSummaryDiscount()+" kr\n"
        );

        builder.append("    _______________________    "+"\n");

        builder.append("To pay: "+Math.round(salesInfo.calculateTotalAmountToPay())+" kr\n");
        builder.append("Change: "+Math.round(salesInfo.getPayment().getChange()) +" kr");

        return builder.toString();
    }
}
