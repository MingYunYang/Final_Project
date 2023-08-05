package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.VaccineInventoryManagerRole;
import nvds.OrganizationEmployeeRole.HospitalLabTechnicianRole;
import nvds.OrganizationEmployeeRole.VaccineOrderRequestsReviewerRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;

public class Hospital extends NvdsParticipatingOrganization {

    private ArrayList<OrganizationEmployeeRole> organizationSupportedRole;

    public Hospital(String organizationName , Country country , State state , City city , Address address , Contact contact) {
        super(organizationName , NvdsParticipatingOrganization.OrganizationType.HOSPITAL , country , state , city , address , contact);
        city.setAffiliateHospital(this);
    }

    @Override
    public ArrayList<OrganizationEmployeeRole> getOrganizationSupportedRole() {
        if ( organizationSupportedRole == null ) {
            organizationSupportedRole = new ArrayList<>();
            organizationSupportedRole.add(new VaccineInventoryManagerRole());
            organizationSupportedRole.add(new VaccineOrderRequestsReviewerRole());
            organizationSupportedRole.add(new HospitalLabTechnicianRole());
        }
        return organizationSupportedRole;
    }


}
