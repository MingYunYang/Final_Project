/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Organization.ProviderOrganization;
import Vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class MasterOrderList {
    
    private ArrayList<Order> orderList;
    
    public MasterOrderList(){
        orderList = new ArrayList<>();
    }
    
    public Order newOrder(ProviderOrganization provider, Vaccine orderVaccine, int orderQuantity){
        Order o = new Order(provider, orderVaccine, orderQuantity);
        orderList.add(o);
        return o;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    
    
    
}
