package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.AdminRole;
import nvds.Role.EmployeeRole;

public class NvdsAdminOrganization extends NvdsParticipatingOrganization {

    private ArrayList<EmployeeRole> supportedRole;
    
    public NvdsAdminOrganization(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_ADMIN_ORG, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new AdminRole());
        }
        return supportedRole;
    }

    

}
