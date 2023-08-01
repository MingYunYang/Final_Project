package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.ClinicRole;
import ecosystem.role.Role;

public class Clinic extends Organization {
    
    private Role clinicRole;

    public Clinic(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Clinic, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(clinicRole == null){
            clinicRole = new ClinicRole();
        }
        return clinicRole;
    }
    
    

    

}
