package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.AdminRole;
import ecosystem.role.Role;

public class AdminOrganization extends Organization {

    private Role adminRole;
    
    public AdminOrganization(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.SystemAdmin, country, state, city, address, contact);
    }
    
    @Override
    public Role getSupportedRole() {
        if (adminRole == null) {
            adminRole = new AdminRole();
        }
        return adminRole; 
    }
    

}
