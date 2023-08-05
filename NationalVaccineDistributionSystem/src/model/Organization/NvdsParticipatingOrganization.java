package model.Organization;

import java.util.ArrayList;
import model.Contact.Contact;
import model.Employee.EmployeeDirectory;
import model.Address.Address;
import model.Location.Country;
import model.Location.City;
import model.Location.State;
import model.EmployeeRole.EmployeeRole;
import model.EmployeeRole.EmployeeRole.RoleType;
import model.UserAccount.UserAccountDirectory;
import model.Vaccine.VaccineInventoryCatalog;
import nvds.Workqueue.WorkQueue;

public abstract class NvdsParticipatingOrganization {

    private String organizationName;

    private WorkQueue workQueue;

    private EmployeeDirectory employeeDirectory;

    private UserAccountDirectory userAccountDirectory;
    
    private VaccineInventoryCatalog inventoryCatalog;

    private OrganizationType type;

    private Country country;

    private State state;

    private City city;

    private Address address;

    private Contact contact;

    public abstract ArrayList<EmployeeRole> getSupportedRole();

    public enum OrganizationType {

        CDC("Centers For Disease Control And Prevention"),
        Public_Health_Department("Public Health Department"),
        NVDS_CLINIC_ORG("Clinic"),
        DistributionCenter("Distribution Center"),
        Distributor("Distributor"),
        NVDS_HOSPITAL_ORG("Hospital"),
        Manufacturer("Manufacturer"),
        Provider("Provider"),
        NVDS_ADMIN_ORG("System Admininistration");

        private final String value;

        private OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        @Override 
        public String toString(){
            return value;
        }

    }

    public NvdsParticipatingOrganization(String name, OrganizationType type, Country country, State state, City city, Address address, Contact contact) {
        this.organizationName = name;
        this.type = type;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.contact = contact;
        
        getSupportedRole();
    }
    
    public EmployeeRole setSupportedEmployeeRole(RoleType roleType){ 
        for(EmployeeRole role : getSupportedRole()){
            if(role.type == roleType){
                return role;
            }
        }
        return null;
    }
    
    // not every organization has inventory catalog
    // if needed, call this method when the organization object is created (OrganizationDirectory - addOrganization())
    public VaccineInventoryCatalog createVaccineInventoryCatalog(){
        if(inventoryCatalog == null){
            inventoryCatalog = new VaccineInventoryCatalog();
        }
        return inventoryCatalog;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
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
        return inventoryCatalog;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return organizationName;
    }

}
