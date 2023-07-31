package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.Role;
import java.util.ArrayList;

public class AdminOrganization extends Organization {

    public AdminOrganization(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.SystemAdmin, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        return roles;
    }

}
