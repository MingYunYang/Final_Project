package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;
import java.util.ArrayList;
import nvds.OrganizationEmployeeRole.AdminRole;

public class VaccineDistributor extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeUserAccountRole> organizationSupportedRole;

    public VaccineDistributor(String organizationName , Country country , State state , City city , Address address , Contact contact) {
        super(organizationName , NvdsParticipatingOrganization.OrganizationType.VACCINE_DISTRIBUTOR , country , state , city , address , contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeUserAccountRole> getOrganizationSupportedRole() {
        if ( organizationSupportedRole == null ) {
            organizationSupportedRole = new ArrayList<>();
            organizationSupportedRole.add(new AdminRole());
        }
        return organizationSupportedRole;
    }


}
