package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.DistributionCenterRole;
import model.role.Role;

public class DistributionCenter extends Organization {
    
    private Role distributionCenterRole;

    public DistributionCenter(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.DistributionCenter, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(distributionCenterRole == null){
            distributionCenterRole = new DistributionCenterRole();
        }
        return distributionCenterRole;
    }

    

}
