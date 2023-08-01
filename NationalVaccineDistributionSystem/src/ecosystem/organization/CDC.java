package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.CDCRole;
import ecosystem.role.Role;

public class CDC extends Organization {
    
    private Role CDCRole;

    public CDC(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.CDC, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(CDCRole == null){
            CDCRole = new CDCRole();
        }
        return CDCRole;
    }


}
