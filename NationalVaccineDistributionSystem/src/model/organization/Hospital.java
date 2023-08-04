package model.organization;

import java.util.ArrayList;
import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.InventoryRole;
import model.role.LabTechnicianRole;
import model.role.MonitorRole;
import model.role.ReviewRequestsRole;
import model.role.Role;

public class Hospital extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Hospital(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Hospital, country, state, city, address, contact);
        city.setAffiliateHospital(this);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
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
