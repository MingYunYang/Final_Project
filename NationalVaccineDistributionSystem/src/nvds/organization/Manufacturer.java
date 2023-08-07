package nvds.organization;

import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.Role;
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

        }
        return supportedRole;
    }

    

}