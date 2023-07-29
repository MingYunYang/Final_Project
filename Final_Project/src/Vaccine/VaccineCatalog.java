/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vaccine;

import Organization.ManufacturerOrganization;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class VaccineCatalog {
    
    ArrayList<Vaccine> vaccineList;
    
    public VaccineCatalog(){
        vaccineList = new ArrayList<>();
    }
    
    public Vaccine newVaccine(int price, int vaccineId, int batchId, ManufacturerOrganization manufacturer){
        Vaccine vaccine = new Vaccine(price, vaccineId, batchId, manufacturer);
        vaccineList.add(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }
    
    
    
}
