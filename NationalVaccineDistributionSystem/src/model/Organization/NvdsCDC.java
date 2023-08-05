package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Geography.Address;
import model.Geography.City;
import model.Geography.Country;
import model.Geography.State;
import model.EmployeeRole.CDCRole;
import model.EmployeeRole.EmployeeRole;

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
