package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.ManufacturerRole;
import model.role.Role;
import java.util.ArrayList;

public class Manufacturer extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Manufacturer(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Manufacturer, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new ManufacturerRole());
        }
        return supportedRole;
    }

    

}
