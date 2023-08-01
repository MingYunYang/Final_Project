/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecosystem.vaccine;

import ecosystem.order.OrderItem;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author libby
 */
public class VaccineInventoryCatalog { // similar to the concept of OrderHistory
    
    private ArrayList<OrderItem> orderItemList;
    private ArrayList<Vaccine> vaccineTypeList;
    private HashMap<Vaccine, Integer> vaccineInventoryCount;
    
    public VaccineInventoryCatalog(){
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

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public ArrayList<Vaccine> getVaccineTypeList() {
        return vaccineTypeList;
    }

    public HashMap<Vaccine, Integer> getVaccineInventoryCount() {
        return vaccineInventoryCount;
    }
    
    
    
}
