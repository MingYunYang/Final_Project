/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Contact.Contact;
import Employee.EmployeeDirectory;
import Geography.Address;
import Geography.Country;
import Geography.City;
import Geography.State;
import Role.Role;
import UserAccount.UserAccountDirectory;
import WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
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
    
    public enum Type{
        
        CDC("CDC"),
        PHD("PHD"),
        Clinic("Clinic"),
        DistributionCenter("Distribution Center"),
        Distributor("Distributor"),
        Hospital("Hospital"),
        Manufacturer("Manufacturer"),
        Provider("Provider"),
        SystemManagement("System Management");
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    
    public Organization(Type type, Country country, State state, City city, Address address, Contact contact) {
        name = type.getValue();
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.type = type;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.contact = contact;
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
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

    public void setCity(City location) {
        this.city = location;
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

    public Type getType() {
        return type;
    }
    
    @Override
    public String toString(){
     return name;
    }
    
}
