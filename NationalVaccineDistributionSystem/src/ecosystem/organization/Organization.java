package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.employee.EmployeeDirectory;
import ecosystem.geographies.Address;
import ecosystem.geographies.Country;
import ecosystem.geographies.City;
import ecosystem.geographies.State;
import ecosystem.role.Role;
import ecosystem.useraccount.UserAccountDirectory;
import ecosystem.workqueue.WorkQueue;
import java.util.ArrayList;

public abstract class Organization {

    private String name;

    private WorkQueue workQueue;

    private EmployeeDirectory employeeDirectory;

    private UserAccountDirectory userAccountDirectory;

    private Type type;

    private Country country;

    private State state;

    private City city;

    private Address address;

    private Contact contact;

    public abstract ArrayList<Role> getSupportedRole();

    public enum Type {

        CDC("Centers for disease control and prevention"),
        PUBLIC_HEALTH_DEPARTMENT("Public health department"),
        Clinic("Clinic"),
        DistributionCenter("Distribution Center"),
        Distributor("Distributor"),
        Hospital("Hospital"),
        Manufacturer("Manufacturer"),
        Provider("Provider"),
        SystemAdmin("Ecosystem admininistration");

        private final String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public Organization(String name, Type type, Country country, State state, City city, Address address, Contact contact) {
        this.name = name;
        this.type = type;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name;
    }

}
