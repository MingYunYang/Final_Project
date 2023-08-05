package model.organization;

import java.util.ArrayList;
import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.AdminRole;
import model.role.EmployeeRole;

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
