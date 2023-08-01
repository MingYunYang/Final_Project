package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.ClinicRole;
import model.role.Role;

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
