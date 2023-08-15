package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.VaccineInventoryManagerRole;
import nvds.role.HospitalLabTechnicianRole;
import nvds.role.VaccineRequestReviewerRole;
import nvds.role.Role;

/**
 * @author libby
 * @author mutara
 */
public class Hospital extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Hospital(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Hospital, country, state, city, address, contact);
        city.setAffiliatedHospital(this);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new VaccineInventoryManagerRole());
            supportedRole.add(new VaccineRequestReviewerRole());
            supportedRole.add(new HospitalLabTechnicianRole());
        }
        return supportedRole;
    }



}
