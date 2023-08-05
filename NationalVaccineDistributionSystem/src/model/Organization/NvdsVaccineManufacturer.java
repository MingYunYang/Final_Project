package model.Organization;

import model.Contact.Contact;
import model.Address.Address;
import model.Location.City;
import model.Location.Country;
import model.Location.State;
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
