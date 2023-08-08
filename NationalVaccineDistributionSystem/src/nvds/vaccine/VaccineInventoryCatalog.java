/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.vaccine;

import nvds.order.OrderItem;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author libby
 */
public class VaccineInventoryCatalog { // for clinic & hospital
    
    private ArrayList<Vaccine> vaccineList;
    private ArrayList<OrderItem> orderItemList;
    private ArrayList<Vaccine> vaccineTypeList;
    private HashMap<Vaccine, Integer> vaccineInventoryCount;
    
    public VaccineInventoryCatalog(){
        vaccineList = new ArrayList<>();
        orderItemList = new ArrayList<>();
        vaccineTypeList = new ArrayList<>();
        vaccineInventoryCount = new HashMap<>();
    }
    
    public void populateVaccineTypeList(){
        
        vaccineTypeList.clear();
        
        for(OrderItem oi : orderItemList){
            Vaccine vaccine = oi.getVaccine();
            if(!vaccineTypeList.contains(vaccine)){
                vaccineTypeList.add(vaccine);
            }
        }
    }
    
    public int countInventory(Vaccine vaccine){
        
        int sum = 0;
        for(OrderItem oi : orderItemList){
            if(oi.getVaccine().equals(vaccine)){
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

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    

    
    
    
    
    
}
