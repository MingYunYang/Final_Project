package nvds.VaccineManagement;

import nvds.OrderManagement.VaccineOrderItem;
import java.util.ArrayList;
import java.util.HashMap;

public class VaccineInventoryCatalog {

    private final ArrayList<VaccineOrderItem> listVaccineOrderItems;

    private final ArrayList<Vaccine> vaccineTypeList;

    private final HashMap<Vaccine , Integer> vaccineInventoryCount;

    public VaccineInventoryCatalog() {
        listVaccineOrderItems = new ArrayList<>();
        vaccineTypeList = new ArrayList<>();
        vaccineInventoryCount = new HashMap<>();
    }

    public void populateVaccineTypeList() {

        vaccineTypeList.clear();

        for ( VaccineOrderItem oi : listVaccineOrderItems ) {
            Vaccine vaccine = oi.getVaccineOrderDetails().getVaccine();
            if (  ! vaccineTypeList.contains(vaccine) ) {
                vaccineTypeList.add(vaccine);
            }
        }
    }

    public int countInventory(Vaccine vaccine) {

        int sum = 0;
        for ( VaccineOrderItem oi : listVaccineOrderItems ) {
            if ( oi.getVaccineOrderDetails().getVaccine().equals(vaccine) ) {
                sum = sum + oi.getOrderQuantity();
            }
        }
        return sum;
    }

    public void populateVaccineInventoryCount() {

        vaccineInventoryCount.clear();

        for ( Vaccine vaccine : vaccineTypeList ) {
            int count = countInventory(vaccine);
            vaccineInventoryCount.put(vaccine , count);
        }
    }

    public String getInventoryStatus(Vaccine vaccine) {

        int inventory = vaccineInventoryCount.get(vaccine);
        if ( inventory < 50 ) {
            return "Insufficient";
        }
        return "Sufficient";
    }

    public ArrayList<VaccineOrderItem> getVaccineOrderItemList() {
        return listVaccineOrderItems;
    }

    public ArrayList<Vaccine> getVaccineTypeList() {
        return vaccineTypeList;
    }

    public HashMap<Vaccine , Integer> getVaccineInventoryCount() {
        return vaccineInventoryCount;
    }


}
