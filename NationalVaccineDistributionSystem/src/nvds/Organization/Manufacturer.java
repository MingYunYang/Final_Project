package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Role.ManufacturerRole;
import nvds.Role.EmployeeRole;
import java.util.ArrayList;

public class Manufacturer extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public Manufacturer(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.Manufacturer, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new ManufacturerRole());
        }
        return supportedRole;
    }

    

}
