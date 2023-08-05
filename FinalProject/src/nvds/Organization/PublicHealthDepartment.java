package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.AdminRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;

public class PublicHealthDepartment extends NvdsParticipatingOrganization {
    
    private ArrayList<OrganizationEmployeeUserAccountRole> organizationSupportedRole;

    public PublicHealthDepartment(String organizatioName, Country country, State state, City city, Address address, Contact contact) {
        super(organizatioName, NvdsParticipatingOrganization.OrganizationType.PHD, country, state, city, address, contact);
    }

    @Override
    public ArrayList<OrganizationEmployeeUserAccountRole> getOrganizationSupportedRole() {
        if(organizationSupportedRole == null){
            organizationSupportedRole = new ArrayList<>();
            organizationSupportedRole.add(new AdminRole());
        }
        return organizationSupportedRole;
    }



}
