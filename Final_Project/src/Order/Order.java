/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Organization.ProviderOrganization;
import Vaccine.Vaccine;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author libby
 */
public class Order {

    ArrayList<OrderItem> orderItems;
    Date orderDate;
    Status status;
    ProviderOrganization provider;
    Vaccine orderVaccine;
    int orderQuantity;
    
    public enum Status {
        //Sending, Approved, Pending_Review, Review_In_Progress, Cancelled;
        Created;
    }

    public Order(ProviderOrganization p, Vaccine v, int quantity) {
        orderItems = new ArrayList<>();
        orderDate = new Date();
        status = Status.Created;
        provider = p;
        orderVaccine = v;
        orderQuantity = quantity;
    }

    public OrderItem newOrderItem(Vaccine vaccine, int quantity) {
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

    public ProviderOrganization getProviderOrganization() {
        return provider;
    }

    public void setProviderOrganization(ProviderOrganization provider) {
        this.provider = provider;
    }

    public Vaccine getOrderVaccine() {
        return orderVaccine;
    }

    public void setOrderVaccine(Vaccine vaccine) {
        this.orderVaccine = vaccine;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int vaccineQuantity) {
        this.orderQuantity = vaccineQuantity;
    }

    

}
