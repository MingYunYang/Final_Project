package nvds.order;

import nvds.vaccine.Vaccine;

/**
 * @author libby
 * @author mutara
 */
public class OrderItem {

    private Vaccine vaccine;
    
    private int orderQuantity;

    public OrderItem(Vaccine vaccine, int quantity){
        this.vaccine = vaccine;
        orderQuantity = quantity;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    
    
   

}
