package ecosystem.order;

import ecosystem.organization.Provider;
import ecosystem.vaccine.VaccineItem;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<OrderItem> orderItems;
    private Date orderDate;
    private Status status;
    private Provider provider;

    public enum Status {
        //Sending, Approved, Pending_Review, Review_In_Progress, Cancelled;
        Created;
    }

    public Order(Provider provider) {
        orderItems = new ArrayList<>();
        orderDate = new Date();
        status = Status.Created;
        this.provider = provider;
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

    public Provider getProviderOrganization() {
        return provider;
    }

    public void setProviderOrganization(Provider provider) {
        this.provider = provider;
    }

}
