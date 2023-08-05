package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.DoctorRole;
import nvds.Role.MonitorRole;
import nvds.Role.InventoryRole;
import nvds.Role.EmployeeRole;
import nvds.Role.ReviewRequestsRole;

public class Clinic extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public Clinic(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_CLINIC_ORG, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new DoctorRole());
            supportedRole.add(new MonitorRole());
            supportedRole.add(new InventoryRole());
            supportedRole.add(new ReviewRequestsRole());
        }
        return supportedRole;
    }
    


}
