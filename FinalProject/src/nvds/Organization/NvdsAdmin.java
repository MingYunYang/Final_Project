package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.AdminRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;

public class NvdsAdmin extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeUserAccountRole> supportedRole;
    
    public NvdsAdmin(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_ADMIN, country, state, city, address, contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeUserAccountRole> getOrganizationSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new AdminRole());
        }
        return supportedRole;
    }

    

}
