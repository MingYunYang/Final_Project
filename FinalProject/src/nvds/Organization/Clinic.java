package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.DoctorRole;
import nvds.OrganizationEmployeeRole.VaccineInventoryManagerRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;
import nvds.OrganizationEmployeeRole.VaccineOrderRequestsReviewerRole;

public class Clinic extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeUserAccountRole> organizationSupportedRole;

    public Clinic(String organizationName , Country country , State state , City city , Address address , Contact contact) {
        super(organizationName , NvdsParticipatingOrganization.OrganizationType.CLINIC , country , state , city , address , contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeUserAccountRole> getOrganizationSupportedRole() {
        if ( organizationSupportedRole == null ) {
            organizationSupportedRole = new ArrayList<>();
            organizationSupportedRole.add(new DoctorRole());
            organizationSupportedRole.add(new VaccineInventoryManagerRole());
            organizationSupportedRole.add(new VaccineOrderRequestsReviewerRole());
        }
        return organizationSupportedRole;
    }


}
