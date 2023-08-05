package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import java.util.ArrayList;
import nvds.OrganizationEmployeeRole.AdminRole;

public class VaccineDistributor extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeRole> organizationSupportedRole;

    public VaccineDistributor(String organizationName , Country country , State state , City city , Address address , Contact contact) {
        super(organizationName , NvdsParticipatingOrganization.OrganizationType.VACCINE_DISTRIBUTOR , country , state , city , address , contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeRole> getOrganizationSupportedRole() {
        if ( organizationSupportedRole == null ) {
            organizationSupportedRole = new ArrayList<>();
            organizationSupportedRole.add(new AdminRole());
        }
        return organizationSupportedRole;
    }


}
