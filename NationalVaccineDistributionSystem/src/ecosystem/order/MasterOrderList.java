package ecosystem.order;

import ecosystem.organization.Provider;
import ecosystem.vaccine.Vaccine;
import java.util.ArrayList;

public class MasterOrderList {

    private final ArrayList<Order> listOfOrders;

    public MasterOrderList() {
        listOfOrders = new ArrayList<>();
    }

    public Order addOrder(Provider provider, Vaccine orderVaccine, int orderQuantity) {
        Order o = new Order(provider, orderVaccine, orderQuantity);
        listOfOrders.add(o);
        return o;
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

}
