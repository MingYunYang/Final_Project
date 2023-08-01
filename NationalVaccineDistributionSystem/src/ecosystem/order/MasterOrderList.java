package ecosystem.order;

import ecosystem.organization.Provider;
import java.util.ArrayList;

public class MasterOrderList {

    private final ArrayList<Order> listOfOrders;

    public MasterOrderList() {
        listOfOrders = new ArrayList<>();
    }

    public Order addOrder(Provider provider) {
        Order o = new Order(provider);
        listOfOrders.add(o);
        return o;
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

}
