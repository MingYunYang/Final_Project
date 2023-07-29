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
import Role.DistributionCenterRole;
import Role.Role;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class DistributionCenterOrganization extends Organization{
    
    public DistributionCenterOrganization(Country country, State state, City city, Address address, Contact contact) {
        super(Organization.Type.DistributionCenter, country, state, city, address, contact);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributionCenterRole());
        return roles;
    }
    
}
