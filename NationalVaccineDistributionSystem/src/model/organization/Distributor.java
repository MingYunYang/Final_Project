package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.DistributorRole;
import model.role.Role;
import java.util.ArrayList;

public class Distributor extends Organization {
    
    private Role distributorRole;

    public Distributor(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Distributor, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(distributorRole == null){
            distributorRole = new DistributorRole();
        }
        return distributorRole;
    }



}
