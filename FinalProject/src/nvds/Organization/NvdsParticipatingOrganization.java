package nvds.Organization;

import java.util.ArrayList;
import nvds.Contact.Contact;
import nvds.Employee.EmployeeDirectory;
import nvds.Geography.Address;
import nvds.Geography.Country;
import nvds.Geography.City;
import nvds.Geography.State;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole.OrganizationEmployeeRoleType;
import nvds.Useraccount.UserAccountDirectory;
import nvds.VaccineManagement.VaccineInventoryCatalog;
import nvds.WorkQueue.WorkQueue;

public abstract class NvdsParticipatingOrganization {

    private String organizationName;

    private WorkQueue organizationWorkQueue;

    private EmployeeDirectory employeeDirectory;

    private UserAccountDirectory userAccountDirectory;

    private VaccineInventoryCatalog vaccineInventoryCatalog;

    private OrganizationType typeOfOrganization;

    private Country organizationCountry;

    private State organizationState;

    private City oragnizationCity;

    private Address organizationAddress;

    private Contact organizationContact;

    public abstract ArrayList<OrganizationEmployeeRole> getOrganizationSupportedRole();

    public enum OrganizationType {

        CDC("Centers For Disease Control And Prevention"),
        PHD("Public Health Department"),
        CLINIC("Clinic"),
        VACCINE_DISTRIBUTION_CENTER("Vaccine Distribution Center"),
        VACCINE_DISTRIBUTOR("Vaccine Distributor"),
        HOSPITAL("Hospital"),
        VACCINE_MANUFACTURER("Vaccine Manufacturer"),
        Provider("Vaccine Provider"),
        NVDS_ADMIN("National Vaccine Distribution System Admin");

        private final String value;

        private OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public NvdsParticipatingOrganization(String organizationName , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        this.organizationName = organizationName;
        this.typeOfOrganization = type;
        organizationWorkQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.organizationCountry = country;
        this.organizationState = state;
        this.oragnizationCity = city;
        this.organizationAddress = address;
        this.organizationContact = contact;

        getOrganizationSupportedRole();
    }

    public OrganizationEmployeeRole getSpecificRole(OrganizationEmployeeRoleType roleType) {
        for ( OrganizationEmployeeRole role : getOrganizationSupportedRole() ) {
            if ( role.organizationEmployeeUserAccountRoleType == roleType ) {
                return role;
            }
        }
        return null;
    }

    // not every organization has inventory catalog
    // if needed, call this method when the organization object is created (OrganizationDirectory - addOrganization())
    public VaccineInventoryCatalog createVaccineInventoryCatalog() {
        if ( vaccineInventoryCatalog == null ) {
            vaccineInventoryCatalog = new VaccineInventoryCatalog();
        }
        return vaccineInventoryCatalog;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public WorkQueue getOrganizationWorkQueue() {
        return organizationWorkQueue;
    }

    public void setOrganizationWorkQueue(WorkQueue organizationWorkQueue) {
        this.organizationWorkQueue = organizationWorkQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public VaccineInventoryCatalog getVaccineInventoryCatalog() {
        return vaccineInventoryCatalog;
    }

    public OrganizationType getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(OrganizationType typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public Country getOrganizationCountry() {
        return organizationCountry;
    }

    public void setOrganizationCountry(Country organizationCountry) {
        this.organizationCountry = organizationCountry;
    }

    public State getOrganizationState() {
        return organizationState;
    }

    public void setOrganizationState(State organizationState) {
        this.organizationState = organizationState;
    }

    public City getOrganizationCity() {
        return oragnizationCity;
    }

    public void setOragnizationCity(City oragnizationCity) {
        this.oragnizationCity = oragnizationCity;
    }

    public Address getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(Address organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public Contact getOrganizationContact() {
        return organizationContact;
    }

    public void setOrganizationContact(Contact organizationContact) {
        this.organizationContact = organizationContact;
    }

    @Override
    public String toString() {
        return organizationName;
    }

}
