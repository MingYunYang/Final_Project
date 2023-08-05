package nvds.OrderManagement;

import nvds.Organization.VaccineProvider;
import nvds.VaccineManagement.VaccineOrderDetails;
import java.util.ArrayList;
import java.util.Date;

public class VaccineOrder {

    private final ArrayList<VaccineOrderItem> listOfVaccineOrderItems;

    private Date orderDate;

    private Status orderStatus;

    private VaccineProvider vaccineProvider;

    public enum Status {

        ORDER_CREATED_SUCCESSFULLY("Order successfully created");

        private final String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public VaccineOrder(VaccineProvider vaccineProvider) {
        this.listOfVaccineOrderItems = new ArrayList<>();
        orderDate = new Date();
        this.vaccineProvider = vaccineProvider;
    }

    public VaccineOrderItem addNewVaccineOrderItem(VaccineOrderDetails vaccineOrderDetails , int orderQuantity) {
        VaccineOrderItem vaccineOrderItem = new VaccineOrderItem(vaccineOrderDetails , orderQuantity);
        listOfVaccineOrderItems.add(vaccineOrderItem);
        return vaccineOrderItem;
    }

    public ArrayList<VaccineOrderItem> getListOfVaccineOrderItems() {
        return listOfVaccineOrderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public VaccineProvider getVaccineProvider() {
        return vaccineProvider;
    }

    public void setVaccineProvider(VaccineProvider provider) {
        this.vaccineProvider = provider;
    }

}
