/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Contact.Contact;
import Geography.Address;
import Geography.City;
import Geography.Country;
import Geography.State;
import Role.PHDRole;
import Role.ProviderRole;
import Role.Role;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class ProviderOrganization extends Organization{
    
    public ProviderOrganization(Country country, State state, City city, Address address, Contact contact) {
        super(Organization.Type.Provider, country, state, city, address, contact);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ProviderRole());
        return roles;    
    }
    
}