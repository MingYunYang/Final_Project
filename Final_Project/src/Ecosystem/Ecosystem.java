/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ecosystem;

import Geography.Country;
import Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class Ecosystem {
    
    private static Ecosystem ecosystem;
    private OrganizationDirectory organizationDirectory;
    private ArrayList<Country> countryList;
    
    public static Ecosystem getInstance() { //lazy initialization
        if (ecosystem == null) {
            ecosystem = new Ecosystem();
        }
        return ecosystem;
    }
    
    private Ecosystem() { //lazy initialization - private constructor
        organizationDirectory = new OrganizationDirectory();
        countryList = new ArrayList<>();
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }
    
    
    
    

    
    
    

    
    
    
    
    
}
