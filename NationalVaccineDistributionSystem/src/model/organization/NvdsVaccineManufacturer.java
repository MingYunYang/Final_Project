package model.organization;

import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.ManufacturerRole;
import model.role.EmployeeRole;
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
