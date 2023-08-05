package model.organization;

import java.util.ArrayList;
import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.PublicHealthDepartmentRole;
import model.role.EmployeeRole;

public class NvdsPHD extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsPHD(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.Public_Health_Department, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new PublicHealthDepartmentRole());
        }
        return supportedRole;
    }



}
