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
public class VaccineInventoryCatalog {
    
    private ArrayList<VaccineItem> vaccineItemList; // for manufacturer
    private ArrayList<OrderItem> orderItemList; // for clinic、hospital
    private ArrayList<Vaccine> vaccineTypeList;
    private HashMap<Vaccine, Integer> vaccineInventoryCount;
    
    public VaccineInventoryCatalog(){
        vaccineItemList = new ArrayList<>();
        orderItemList = new ArrayList<>();
        vaccineTypeList = new ArrayList<>();
        vaccineInventoryCount = new HashMap<>();
    }
    
    public void populateVaccineTypeList(){
        
        vaccineTypeList.clear();
        
        for(OrderItem oi : orderItemList){
            Vaccine vaccine = oi.getVaccineItem().getVaccine();
            if(!vaccineTypeList.contains(vaccine)){
                vaccineTypeList.add(vaccine);
            }
        }
    }
    
    public int countInventory(Vaccine vaccine){
        
        int sum = 0;
        for(OrderItem oi : orderItemList){
            if(oi.getVaccineItem().getVaccine().equals(vaccine)){
                sum = sum + oi.getOrderQuantity();
            }
        }
        return sum;
    }
    
    public void populateVaccineInventoryCount(){
        
        vaccineInventoryCount.clear();
        
        for(Vaccine vaccine : vaccineTypeList){
            int count = countInventory(vaccine);
            vaccineInventoryCount.put(vaccine, count);
        }
    }
    
    public String getInventoryStatus(Vaccine vaccine){
    
        int inventory = vaccineInventoryCount.get(vaccine);
        if(inventory < 50){
            return "Insufficient";
        }
        return "Sufficient";
    }
    
    public void newVaccineItem(int quantity, Vaccine vaccine, Manufacturer manufacturer, int batchID){
        
        for(int i = 0; i < quantity; i++){
            VaccineItem vi = new VaccineItem(vaccine, manufacturer, batchID);
            vaccineItemList.add(vi);
        }
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public ArrayList<Vaccine> getVaccineTypeList() {
        return vaccineTypeList;
    }

    public HashMap<Vaccine, Integer> getVaccineInventoryCount() {
        return vaccineInventoryCount;
    }

    public ArrayList<VaccineItem> getVaccineItemList() {
        return vaccineItemList;
    }
    
    
    
    
    
}
