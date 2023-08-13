/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.vaccine;

import nvds.order.OrderItem;
import java.util.ArrayList;
import java.util.HashMap;
import nvds.organization.Manufacturer;

/**
 *
 * @author libby
 */
public class VaccineInventoryCatalog { // for clinic, hospital, manufacturer,cdc

    private final ArrayList<Batch> batchList; // for manufacturer, cdc 儲存製造的疫苗
    private final ArrayList<OrderItem> orderItemList; // for clinic, hospital 儲存收到的疫苗
    private final ArrayList<Vaccine> vaccineTypeList;
    private final HashMap<Vaccine, Integer> vaccineInventoryCount;

    public VaccineInventoryCatalog () {
        batchList = new ArrayList<>();
        orderItemList = new ArrayList<>();
        vaccineTypeList = new ArrayList<>();
        vaccineInventoryCount = new HashMap<>();
    }

    public void populateVaccineTypeList () {

        vaccineTypeList.clear();

        for ( Batch batch : batchList ) {
            Vaccine vaccine = batch.getVaccine();
            if ( !vaccineTypeList.contains( vaccine ) ) {
                vaccineTypeList.add( vaccine );
            }
        }
    }

    public int countInventory ( Vaccine vaccine ) {

        int sum = 0;
        for ( Batch batch : batchList ) {
            if ( batch.getVaccine().equals( vaccine ) ) {
                sum = sum + batch.getQuantity(); // availability for clinic
            }
        }
        return sum;
    }

    public void populateVaccineInventoryCount () {

        vaccineInventoryCount.clear();

        for ( Vaccine vaccine : vaccineTypeList ) {
            int count = countInventory( vaccine );
            vaccineInventoryCount.put( vaccine, count );
        }
    }

    public String getInventoryStatus ( Vaccine vaccine ) {
        Integer inventoryCount = vaccineInventoryCount.get( vaccine );
        if ( inventoryCount == null ) {
            // Handle the case when the vaccine is not found in the inventory
            return "Unknown"; // Or any other handling logic
        }
        int inventory = inventoryCount;
        if ( inventory < 50 ) {
            return "Insufficient";
        }
        return "Sufficient";
    }

    public ArrayList<OrderItem> getOrderItemList () {
        return orderItemList;
    }

    public ArrayList<Vaccine> getVaccineTypeList () {
        return vaccineTypeList;
    }

    public HashMap<Vaccine, Integer> getVaccineInventoryCount () {
        return vaccineInventoryCount;
    }

    public ArrayList<Batch> getBatchList () {
        return batchList;
    }

    public Batch addBatch ( Vaccine vaccine, String batchId, int quantity, Manufacturer manufacturer, String manufactureDate, String expirationDate ) {
        Batch batch = new Batch( vaccine, batchId, quantity, manufacturer, manufactureDate, expirationDate );
        batchList.add( batch );
        return batch;
    }

}
