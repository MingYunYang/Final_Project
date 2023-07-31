package ecosystem.order;

import ecosystem.organization.Provider;
import ecosystem.vaccine.Vaccine;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private final ArrayList<OrderItem> orderItems;

    private Date orderDate;

    private Status status;

    private Provider provider;

    private int orderQuantity;

    public enum Status {

        //Sending, Approved, Pending_Review, Review_In_Progress, Cancelled;
        Created;

    }

    public Order(Provider p, Vaccine v, int quantity) {
        orderItems = new ArrayList<>();
        orderDate = new Date();
        status = Status.Created;
        provider = p;
        orderQuantity = quantity;
    }

    public OrderItem addOrderItem(Vaccine vaccine, int quantity) {
        OrderItem oi = new OrderItem(vaccine, quantity);
        orderItems.add(oi);
        return oi;
    }

    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
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

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int vaccineQuantity) {
        this.orderQuantity = vaccineQuantity;
    }

}
