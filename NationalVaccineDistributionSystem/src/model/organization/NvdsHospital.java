package model.organization;

import java.util.ArrayList;
import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.InventoryRole;
import model.role.LabTechnicianRole;
import model.role.MonitorRole;
import model.role.ReviewRequestsRole;
import model.role.EmployeeRole;

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
