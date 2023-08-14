package nvds.order;

import java.util.ArrayList;
import java.util.Date;
import nvds.organization.Hospital;
import nvds.vaccine.Vaccine;

public class Order {

    private final ArrayList<OrderItem> orderItemList;

    private Date date;

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
        orderItemList = new ArrayList<>();
        date = new Date();
        status = Status.CREATED;
        this.hospital = hospital;
    }

    public OrderItem newOrderItem(Vaccine vaccine , int quantity) {
        OrderItem oi = new OrderItem(vaccine , quantity);
        orderItemList.add(oi);
        return oi;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
