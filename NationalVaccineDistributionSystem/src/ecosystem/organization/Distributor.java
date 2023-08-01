package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.DistributorRole;
import ecosystem.role.Role;
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
