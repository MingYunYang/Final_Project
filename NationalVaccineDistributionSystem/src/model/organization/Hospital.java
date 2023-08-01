package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.HospitalRole;
import model.role.Role;

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
