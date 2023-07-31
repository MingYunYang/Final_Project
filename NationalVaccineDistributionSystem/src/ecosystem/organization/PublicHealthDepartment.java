package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.PublicHealthDepartmentRole;
import ecosystem.role.Role;
import java.util.ArrayList;

public class PublicHealthDepartment extends Organization {

    public PublicHealthDepartment(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.PUBLIC_HEALTH_DEPARTMENT, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PublicHealthDepartmentRole());
        return roles;
    }

}
