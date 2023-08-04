package model.organization;

import java.util.ArrayList;
import model.geography.Contact;
import model.geography.Address;
import model.geography.City;
import model.geography.Country;
import model.geography.State;
import model.role.DoctorRole;
import model.role.MonitorRole;
import model.role.InventoryRole;
import model.role.Role;
import model.role.ReviewRequestsRole;

public class Clinic extends Organization {
    
    private ArrayList<Role> supportedRole;

    public Clinic(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.Clinic, country, state, city, address, contact);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
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
