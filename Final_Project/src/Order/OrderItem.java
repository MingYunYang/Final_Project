/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Vaccine.Vaccine;

/**
 *
 * @author libby
 */
public class OrderItem {
    
    Vaccine actualVaccine;
    int actualQuantity;
    
    public OrderItem(Vaccine vaccine, int quantity){
        actualVaccine = vaccine;
        actualQuantity = quantity;
    }
    
    public int getOrderItemTotal() {
        return actualVaccine.getPrice() * actualQuantity;
    }

    public Vaccine getActualVaccine() {
        return actualVaccine;
    }

    public void setActualVaccine(Vaccine actualVaccine) {
        this.actualVaccine = actualVaccine;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    
    
    
    
}
