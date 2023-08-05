package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.AdminRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;
import java.util.ArrayList;

public class VaccineManufacturer extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeUserAccountRole> supportedRole;

    public VaccineManufacturer(String organizationName , Country country , State state , City city , Address address , Contact contact) {
        super(organizationName , NvdsParticipatingOrganization.OrganizationType.VACCINE_MANUFACTURER , country , state , city , address , contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeUserAccountRole> getOrganizationSupportedRole() {
        if ( supportedRole == null ) {
            supportedRole = new ArrayList<>();
            supportedRole.add(new AdminRole());
        }
        return supportedRole;
    }


}
