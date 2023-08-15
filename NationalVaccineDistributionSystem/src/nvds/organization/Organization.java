package nvds.organization;

import java.util.ArrayList;
import nvds.geography.Contact;
import nvds.employee.EmployeeDirectory;
import nvds.geography.Address;
import nvds.geography.Country;
import nvds.geography.City;
import nvds.geography.State;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.useraccount.UserAccountDirectory;
import nvds.vaccine.VaccineInventoryCatalog;
import nvds.workqueue.WorkQueue;

public abstract class Organization {

    private String organizationName;

    private WorkQueue workQueue;

    private EmployeeDirectory employeeDirectory;

    private UserAccountDirectory userAccountDirectory;
    
    private VaccineInventoryCatalog inventoryCatalog;

    private Type type;

    private Country country;

    private State state;

    private City city;

    private Address address;

    private Contact contact;

    public abstract ArrayList<Role> getSupportedRole();

    public enum Type {

        CDC("Centers For Disease Control And Prevention"),
        Public_Health_Department("Public Health Department"),
        Clinic("Clinic"),
        DistributionCenter("Distribution Center"),
        Distributor("Distributor"),
        Hospital("Hospital"),
        Manufacturer("Manufacturer"),
        NVDS_Admin("National Vaccine Distribution System Admin");

        private final String value;

        private Type(String value) {
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

    public Organization(String name, Type type, Country country, State state, City city, Address address, Contact contact) {
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
    
    public Role getSpecificRole(RoleType roleType){ 
        for(Role role : getSupportedRole()){
            if(role.getType() == roleType){
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

    public VaccineInventoryCatalog getInventoryCatalog() {
        return inventoryCatalog;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
