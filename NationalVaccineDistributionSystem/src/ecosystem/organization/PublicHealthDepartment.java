package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.PublicHealthDepartmentRole;
import ecosystem.role.Role;

public class PublicHealthDepartment extends Organization {
    
    private Role publicHealthDepartmentRole;

    public PublicHealthDepartment(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Public_Health_Department, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(publicHealthDepartmentRole == null){
            publicHealthDepartmentRole = new PublicHealthDepartmentRole();
        }
        return publicHealthDepartmentRole;
    }



}
