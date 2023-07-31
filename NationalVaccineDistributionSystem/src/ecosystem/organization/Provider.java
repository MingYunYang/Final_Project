package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.ProviderRole;
import ecosystem.role.Role;
import java.util.ArrayList;

public class Provider extends Organization {

    public Provider(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Provider, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ProviderRole());
        return roles;
    }

}
