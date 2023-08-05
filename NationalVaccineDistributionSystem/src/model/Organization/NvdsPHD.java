package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Geography.Address;
import model.Geography.City;
import model.Geography.Country;
import model.Geography.State;
import model.EmployeeRole.PublicHealthDepartmentRole;
import model.EmployeeRole.EmployeeRole;

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
