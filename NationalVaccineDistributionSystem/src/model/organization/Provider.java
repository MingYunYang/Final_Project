package model.organization;

import java.util.ArrayList;
import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.ProviderRole;
import model.role.Role;

public class Provider extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Provider(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Provider, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new ProviderRole());
        }
        return supportedRole;
    }

 

}
