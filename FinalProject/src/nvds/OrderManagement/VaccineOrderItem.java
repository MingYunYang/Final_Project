package nvds.OrderManagement;

import nvds.VaccineManagement.VaccineOrderDetails;

public class VaccineOrderItem {

    private VaccineOrderDetails vaccineOrderDetails;

    private int orderQuantity;

    public VaccineOrderItem(VaccineOrderDetails vaccineOrderDetails , int orderQuantity) {
        this.vaccineOrderDetails = vaccineOrderDetails;
        this.orderQuantity = orderQuantity;
    }

    public VaccineOrderDetails getVaccineOrderDetails() {
        return vaccineOrderDetails;
    }

    public void setVaccineOrderDetails(VaccineOrderDetails vaccineOrderDetails) {
        this.vaccineOrderDetails = vaccineOrderDetails;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }


}
