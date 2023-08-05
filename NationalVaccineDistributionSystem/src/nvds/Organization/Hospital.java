package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.InventoryRole;
import nvds.Role.LabTechnicianRole;
import nvds.Role.MonitorRole;
import nvds.Role.ReviewRequestsRole;
import nvds.Role.EmployeeRole;

public class Hospital extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public Hospital(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_HOSPITAL_ORG, country, state, city, address, contact);
        city.setAffiliateHospital(this);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new MonitorRole());
            supportedRole.add(new InventoryRole());
            supportedRole.add(new ReviewRequestsRole());
            supportedRole.add(new LabTechnicianRole());
        }
        return supportedRole;
    }



}
