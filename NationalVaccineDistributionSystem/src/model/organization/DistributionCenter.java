package model.organization;

import java.util.ArrayList;
import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.DistributionCenterRole;
import model.role.Role;

public class DistributionCenter extends Organization {
    
    private ArrayList<Role> supportedRole;

    public DistributionCenter(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.DistributionCenter, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new DistributionCenterRole());
        }
        return supportedRole;
    }

    

}
