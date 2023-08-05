package model.Organization;

import model.Contact.Contact;
import model.Geography.Address;
import model.Geography.City;
import model.Geography.Country;
import model.Geography.State;
import model.EmployeeRole.ManufacturerRole;
import model.EmployeeRole.EmployeeRole;
import java.util.ArrayList;

public class NvdsVaccineManufacturer extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsVaccineManufacturer(String name, Country country, State state, City city, Address address, Contact contact) {
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
