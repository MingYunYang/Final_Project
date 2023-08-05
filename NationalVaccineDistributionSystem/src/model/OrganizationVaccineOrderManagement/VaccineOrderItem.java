package model.OrganizationVaccineOrderManagement;

import model.Vaccine.Vaccine;
import model.Vaccine.VaccineOrderDetails;

public class VaccineOrderItem {

    private VaccineOrderDetails vaccineItem;
    
    private int orderQuantity;

    public VaccineOrderItem(VaccineOrderDetails vaccineItem, int quantity){
        this.vaccineItem = vaccineItem;
        orderQuantity = quantity;
    }

    public VaccineOrderDetails getVaccineItem() {
        return vaccineItem;
    }

    public void setVaccineItem(VaccineOrderDetails vaccineItem) {
        this.vaccineItem = vaccineItem;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
   

}