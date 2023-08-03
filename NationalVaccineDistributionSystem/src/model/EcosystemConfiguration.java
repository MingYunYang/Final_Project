package model;

import model.geography.Contact;
import model.employee.Employee;
import model.geography.Address;
import model.geography.Country;
import model.geography.City;
import model.geography.State;
import model.order.OrderItem;
import model.organization.OrganizationDirectory;
import model.organization.AdminOrganization;
import model.organization.Clinic;
import model.organization.Manufacturer;
import model.organization.Organization;
import model.role.Role;
import model.role.Role.RoleType;
import model.vaccine.Vaccine;
import model.vaccine.VaccineInventoryCatalog;
import model.vaccine.VaccineItem;

/**
 * The EcosystemConfiguration class serves as a utility class for creating and
 * populating the Ecosystem with its organizations, states, cities, addresses,
 * and contacts.
 *
 * @author tugum
 */
public class EcosystemConfiguration {

    // This is a static method in the ecosystem configuration class used to create the ecosystem and it's organizations
    public static Ecosystem configure() {

        // So now we create an object the ecosystem class to store the only instance of the Ecosystem class
        // If no instance is found, it creates a new one as found below.
        Ecosystem ecosystem = Ecosystem.getInstance();

        // create country
        Country usa = ecosystem.addCountry("United States");

        /**
         * Create states and add two cities to each state
         */
        State massachusetts = usa.addState("Massachusetts");
        City cambridge = massachusetts.addCity("Cambridge");
        massachusetts.addCity("Boston");
        massachusetts.addCity("Attleboro");

        State washington = usa.addState("Washington");
        washington.addCity("Seattle");
        washington.addCity("Olimpya");

        State california = usa.addState("California");
        california.addCity("Sacramento");
        california.addCity("Los Angeles");

        State newyork = usa.addState("New York");
        newyork.addCity("Albany");
        newyork.addCity("New York");

        // create admin address in cambridge city
        Address address = cambridge.addAddress("215 Kelton St", "02134");

        // create contact at address
        Contact contact = address.addContact("781-921-8195");

        // Initialize the ecosystem organization directory
        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();

        // Create the ecosystem admin organization and add it to the ecosystem organization directory
        AdminOrganization admin = new AdminOrganization("US Dept. of Health and Human Services", usa, massachusetts, cambridge, address, contact);

        // Add the admin organization to the ecosystem organization directory
        organizationDirectory.addOrganization(admin);

        // Create an employee in admin organization and add it the employee to the admin employee directory
        Employee adminEmployee = admin.getEmployeeDirectory().addEmployee("Admin");

        // Create a spcified role for the admin organization employee
        Role adminRole = admin.getSpecificRole(RoleType.System_Administration_Role);

        // Create a user account for the employee admin
        admin.getUserAccountDirectory().createUserAccount("admin", "admin", adminEmployee, adminRole);

        // Creating a clinic in the ecosystem for testing
        Clinic clinic = (Clinic) organizationDirectory.newOrganization("Malden Clinic", Organization.Type.Clinic, usa, massachusetts, cambridge, address, contact);

        // Create an employee in the clinic and add to the clinic employee directory
        Employee clinicEmployee = clinic.getEmployeeDirectory().addEmployee("libby");

        // Get the specified role for the employee in the clinic organization
        Role inventoryRole = clinic.getSpecificRole(RoleType.Inventory_Role);

        // Create user account for the clinic employee
        clinic.getUserAccountDirectory().createUserAccount("inventory", "inventory", clinicEmployee, inventoryRole);

        // Create vaccine inventory catalog object for the clinic vaccine inventory catalog
        VaccineInventoryCatalog clinicInventoryCatalog = clinic.getInventoryCatalog();

        // Create a vaccine 
        Vaccine vaccine = new Vaccine("Covid-19 Vaccine", 500, 1);

        // Create a vaccine maufacturer in the ecosystem of national vaccine distribution system
        Manufacturer manufacturer = new Manufacturer("Modena", usa, massachusetts, cambridge, address, contact);

        // Create a vaccine with it's vaccine, manufacturer and batch id
        VaccineItem vaccineItem = new VaccineItem(vaccine, manufacturer, 1);

        // Create order item to add to the total order for vaccine and add the vaccine item and quantity of the vaccine item
        OrderItem oi = new OrderItem(vaccineItem, 5);

        // Get order orderItemlist of the clinic inventory catalog and add the order item
        clinicInventoryCatalog.getOrderItemList().add(oi);

        // return the instance of the ecosystem
        return ecosystem;
    }

}
