package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.role.ClinicDoctorRole;
import nvds.role.VaccineInventoryManagerRole;
import nvds.role.Role;
import nvds.role.VaccineRequestReviewerRole;
import nvds.vaccine.VaccineCatalog;

public class Clinic extends Organization {

    private ArrayList<Role> supportedRole;
    private VaccineCatalog clinicVaccineCatalog;

    public Clinic ( String name, Country country, State state, City city, Address address, Contact contact ) {
        super( name, Organization.Type.Clinic, country, state, city, address, contact );
    }

    @Override
    public ArrayList<Role> getSupportedRole () {
        if ( supportedRole == null ) {
            supportedRole = new ArrayList<>();
            supportedRole.add( new ClinicDoctorRole() );
            supportedRole.add( new VaccineInventoryManagerRole() );
            supportedRole.add( new VaccineRequestReviewerRole() );
        }
        return supportedRole;
    }

    public VaccineCatalog getClinicVaccineCatalog () {
        return clinicVaccineCatalog;
    }

    public void setClinicVaccineCatalog ( VaccineCatalog clinicVaccineCatalog ) {
        this.clinicVaccineCatalog = clinicVaccineCatalog;
    }

}
