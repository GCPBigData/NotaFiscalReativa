package br.googolplex.paymentservice.dto;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
public class PaymentInformation {

    private String tableNumber;
    private int totalCost;

    public PaymentInformation() {
    }

    public PaymentInformation(String tableNumber, int totalCost) {
        this.tableNumber = tableNumber;
        this.totalCost = totalCost;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "tableNumber='" + tableNumber + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
