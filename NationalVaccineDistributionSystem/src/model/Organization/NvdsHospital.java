package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Geography.Address;
import model.Geography.City;
import model.Geography.Country;
import model.Geography.State;
import model.EmployeeRole.InventoryRole;
import model.EmployeeRole.LabTechnicianRole;
import model.EmployeeRole.MonitorRole;
import model.EmployeeRole.ReviewRequestsRole;
import model.EmployeeRole.EmployeeRole;

public class NvdsHospital extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsHospital(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_HOSPITAL_ORG, country, state, city, address, contact);
        city.setAffiliateHospital(this);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new MonitorRole());
            supportedRole.add(new InventoryRole());
            supportedRole.add(new ReviewRequestsRole());
            supportedRole.add(new LabTechnicianRole());
        }
        return supportedRole;
    }



}
