package ecosystem.order;

import ecosystem.vaccine.Vaccine;

public class OrderItem {

    private Vaccine vaccine;

    private int quantity;

    public OrderItem(Vaccine vaccine, int quantity) {
        this.vaccine = vaccine;
        this.quantity = quantity;
    }

    public int getOrderItemTotal() {
        return vaccine.getPrice() * quantity;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
