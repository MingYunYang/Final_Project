package model.organization;

import java.util.ArrayList;
import model.GeographicalConfiguration.Contact;
import model.GeographicalConfiguration.Address;
import model.GeographicalConfiguration.City;
import model.GeographicalConfiguration.Country;
import model.GeographicalConfiguration.State;
import model.role.DoctorRole;
import model.role.MonitorRole;
import model.role.InventoryRole;
import model.role.EmployeeRole;
import model.role.ReviewRequestsRole;

public class NvdsClinic extends NvdsParticipatingOrganization {
    
    private ArrayList<EmployeeRole> supportedRole;

    public NvdsClinic(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, NvdsParticipatingOrganization.OrganizationType.NVDS_CLINIC_ORG, country, state, city, address, contact);
    }

    @Override
    public ArrayList<EmployeeRole> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new DoctorRole());
            supportedRole.add(new MonitorRole());
            supportedRole.add(new InventoryRole());
            supportedRole.add(new ReviewRequestsRole());
        }
        return supportedRole;
    }
    


}
