package model.organization;

import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.PublicHealthDepartmentRole;
import model.role.Role;

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
