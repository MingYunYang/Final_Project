package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.CDCAdverseEventHandlerRole;
import nvds.role.Role;
import nvds.vaccine.VaccineCatalog;

public class CDC extends Organization {
    
    private ArrayList<Role> supportedRole;
    private VaccineCatalog vaccineCatalog;

    public CDC(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.CDC, country, state, city, address, contact);
        VaccineCatalog vaccineCatalog = new VaccineCatalog();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new CDCAdverseEventHandlerRole());
        }
        return supportedRole;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }
    
    


    

}
