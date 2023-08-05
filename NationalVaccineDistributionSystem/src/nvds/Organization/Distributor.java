package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.DistributorRole;
import nvds.Role.EmployeeRole;
import java.util.ArrayList;

public class Distributor extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public Distributor(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.Distributor, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new DistributorRole());
        }
        return supportedRole;
    }



}
