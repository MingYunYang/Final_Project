package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.AdminRole;
import model.role.Role;

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
