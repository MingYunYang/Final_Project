package nvds.order;

import nvds.vaccine.VaccineItem;
import java.util.ArrayList;
import java.util.Date;
import nvds.organization.Hospital;

public class Order {

    private ArrayList<OrderItem> orderItems;
    private Date orderDate;
    private Status status;
    private Hospital hospital;

    public enum Status {

        CREATED("Order created");

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

    public Order(Hospital hospital) {
        orderItems = new ArrayList<>();
        orderDate = new Date();
        status = Status.CREATED;
        this.hospital = hospital;
    }

    public OrderItem newOrderItem(VaccineItem vaccineItem, int quantity) {
        OrderItem oi = new OrderItem(vaccineItem, quantity);
        orderItems.add(oi);
        return oi;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    

}
