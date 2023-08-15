package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.Role;
import nvds.role.VaccineRequestReviewerRole;

/**
 * @author libby
 * @author mutara
 */
public class PublicHealthDepartment extends Organization {
    
    private ArrayList<Role> supportedRole;

    public PublicHealthDepartment(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Public_Health_Department, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new VaccineRequestReviewerRole());
        }
        return supportedRole;
    }



}
