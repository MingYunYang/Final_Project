package model.organization;

import java.util.ArrayList;
import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.CDCRole;
import model.role.Role;

public class CDC extends Organization {
    
    private ArrayList<Role> supportedRole;

    public CDC(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.CDC, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new CDCRole());
        }
        return supportedRole;
    }


    

}
