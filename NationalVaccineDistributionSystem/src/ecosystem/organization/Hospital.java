package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.role.HospitalRole;
import ecosystem.role.Role;

public class Hospital extends Organization {
    
    private Role hospitalRole;

    public Hospital(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Hospital, country, state, city, address, contact);
    }

    @Override
    public Role getSupportedRole() {
        if(hospitalRole == null){
            hospitalRole = new HospitalRole();
        }
        return hospitalRole;
    }



}
