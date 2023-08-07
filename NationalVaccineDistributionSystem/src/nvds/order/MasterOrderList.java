package nvds.order;

import java.util.ArrayList;
import nvds.organization.Hospital;

public class MasterOrderList {

    private final ArrayList<Order> listOfOrders;

    public MasterOrderList() {
        listOfOrders = new ArrayList<>();
    }

    public Order addOrder(Hospital hospital) {
        Order o = new Order(hospital);
        listOfOrders.add(o);
        return o;
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

}
