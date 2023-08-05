package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Address.Address;
import model.Location.City;
import model.Location.Country;
import model.Location.State;
import model.EmployeeRole.DoctorRole;
import model.EmployeeRole.MonitorRole;
import model.EmployeeRole.InventoryRole;
import model.EmployeeRole.EmployeeRole;
import model.EmployeeRole.ReviewRequestsRole;

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
