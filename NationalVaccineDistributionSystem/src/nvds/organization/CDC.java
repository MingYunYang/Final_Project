package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.CDCAdverseEventHandlerRole;
import nvds.role.CDCCatalogAndAllocationHandlerRole;
import nvds.role.Role;
import nvds.role.VaccineRequestReviewerRole;
import nvds.vaccine.VaccineCatalog;

/**
 * @author libby
 * @author mutara
 */
public class CDC extends Organization {
    
    private ArrayList<Role> supportedRole;
    private VaccineCatalog vaccineCatalog;

    public CDC(String name, Country country, State state, City city, Address address, Contact contact) {
        super(name, Organization.Type.CDC, country, state, city, address, contact);
        vaccineCatalog = new VaccineCatalog();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        if(supportedRole == null){
            supportedRole = new ArrayList<>();
            supportedRole.add(new CDCAdverseEventHandlerRole());
            supportedRole.add(new CDCCatalogAndAllocationHandlerRole()); 
            supportedRole.add(new VaccineRequestReviewerRole()); 
            
        }
        return supportedRole;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    
    
    
    


    

}
