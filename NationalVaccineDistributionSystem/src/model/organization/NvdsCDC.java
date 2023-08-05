package model.organization;

import java.util.ArrayList;
import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.CDCRole;
import model.role.EmployeeRole;

public class NvdsCDC extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsCDC(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.CDC, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new CDCRole());
        }
        return supportedRole;
    }


    

}
