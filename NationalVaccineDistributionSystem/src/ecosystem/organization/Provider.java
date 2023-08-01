package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.ProviderRole;
import ecosystem.role.Role;

public class Provider extends Organization {
    
    private Role providerRole;

    public Provider(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Provider, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(providerRole == null){
            providerRole = new ProviderRole();
        }
        return providerRole;
    }

 

}
