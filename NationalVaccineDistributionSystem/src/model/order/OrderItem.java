package model.order;

import model.vaccine.Vaccine;
import model.vaccine.VaccineItem;

public class OrderItem {

    private VaccineItem vaccineItem;
    
    private int orderQuantity;

    public OrderItem(VaccineItem vaccineItem, int quantity){
        this.vaccineItem = vaccineItem;
        orderQuantity = quantity;
    }

    public VaccineItem getVaccineItem() {
        return vaccineItem;
    }

    public void setVaccineItem(VaccineItem vaccineItem) {
        this.vaccineItem = vaccineItem;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
   

}
