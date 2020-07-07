package br.googolplex.client.dto;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
public class Order {

    private String tableNumber;
    private String coffeeType;
    private int amount;

    public Order() {
    }

    public Order(String tableNumber, String coffeeType, int amount) {
        this.tableNumber = tableNumber;
        this.coffeeType = coffeeType;
        this.amount = amount;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "tableNumber='" + tableNumber + '\'' +
                ", coffeeType='" + coffeeType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
