package nvds.OrderManagement;

import nvds.Organization.VaccineProvider;
import java.util.ArrayList;

public class MasterVaccineOrderList {

    private final ArrayList<VaccineOrder> listOfAllVaccineOrders;

    public MasterVaccineOrderList() {
        listOfAllVaccineOrders = new ArrayList<>();
    }

    public VaccineOrder addNewVaccineOrder(VaccineProvider vaccineProvider) {
        VaccineOrder vaccineOrder = new VaccineOrder(vaccineProvider);
        listOfAllVaccineOrders.add(vaccineOrder);
        return vaccineOrder;
    }

    public ArrayList<VaccineOrder> getListOfAllVaccineOrders() {
        return listOfAllVaccineOrders;
    }

}
