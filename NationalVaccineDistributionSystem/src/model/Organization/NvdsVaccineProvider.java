package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Address.Address;
import model.Location.City;
import model.Location.Country;
import model.Location.State;
import model.EmployeeRole.ProviderRole;
import model.EmployeeRole.EmployeeRole;

public class NvdsVaccineProvider extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsVaccineProvider(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.Provider, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new ProviderRole());
        }
        return supportedRole;
    }

 

}
