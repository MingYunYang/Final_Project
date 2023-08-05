package model.OrganizationVaccineOrderManagement;

import model.Organization.NvdsVaccineProvider;
import model.Vaccine.VaccineOrderDetails;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<VaccineOrderItem> orderItems;
    private Date orderDate;
    private Status status;
    private NvdsVaccineProvider provider;

    public enum Status {
        //Sending, Approved, Pending_Review, Review_In_Progress, Cancelled;
        Created;
    }

    public Order(NvdsVaccineProvider provider) {
        orderItems = new ArrayList<>();
        orderDate = new Date();
        status = Status.Created;
        this.provider = provider;
    }

    public VaccineOrderItem newOrderItem(VaccineOrderDetails vaccineItem, int quantity) {
        VaccineOrderItem oi = new VaccineOrderItem(vaccineItem, quantity);
        orderItems.add(oi);
        return oi;
    }

    public ArrayList<VaccineOrderItem> getOrderItems() {
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

    public NvdsVaccineProvider getProviderOrganization() {
        return provider;
    }

    public void setProviderOrganization(NvdsVaccineProvider provider) {
        this.provider = provider;
    }

}
