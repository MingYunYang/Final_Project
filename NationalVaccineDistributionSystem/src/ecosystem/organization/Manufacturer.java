package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.ManufacturerRole;
import ecosystem.role.Role;
import java.util.ArrayList;

public class Manufacturer extends Organization {
    
    private Role manufacturerRole;

    public Manufacturer(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Manufacturer, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(manufacturerRole == null){
            manufacturerRole = new ManufacturerRole();
        }
        return manufacturerRole;
    }

    

}
