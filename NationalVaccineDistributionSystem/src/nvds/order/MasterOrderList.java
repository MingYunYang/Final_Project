package nvds.order;

import java.util.ArrayList;
import nvds.organization.Hospital;

public class MasterOrderList {

    private final ArrayList<Order> orderList;

    public MasterOrderList() {
        orderList = new ArrayList<>();
    }

    public Order addOrder(Hospital hospital) {
        Order o = new Order(hospital);
        orderList.add(o);
        return o;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

}
