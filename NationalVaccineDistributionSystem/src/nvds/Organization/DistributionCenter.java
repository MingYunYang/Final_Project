package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.DistributionCenterRole;
import nvds.Role.EmployeeRole;

public class DistributionCenter extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public DistributionCenter(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.DistributionCenter, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new DistributionCenterRole());
        }
        return supportedRole;
    }

    

}
