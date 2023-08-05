package model.VaccineOrderManagement;

import model.organization.NvdsVaccineProvider;
import java.util.ArrayList;

public class MasterOrderList {

    private final ArrayList<Order> listOfOrders;

    public MasterOrderList() {
        listOfOrders = new ArrayList<>();
    }

    public Order addOrder(NvdsVaccineProvider provider) {
        Order o = new Order(provider);
        listOfOrders.add(o);
        return o;
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

}
