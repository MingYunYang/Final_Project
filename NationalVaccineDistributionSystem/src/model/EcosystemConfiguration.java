package model;

import model.geography.Contact;
import model.employee.Employee;
import model.geography.Address;
import model.geography.Country;
import model.geography.City;
import model.geography.State;
import model.organization.OrganizationDirectory;
import model.organization.AdminOrganization;
import model.role.Role;

public class EcosystemConfiguration {

    public static Ecosystem configure() {

        Ecosystem ecosystem = Ecosystem.getInstance();

        // create country
        Country usa = ecosystem.addCountry("United States");

        // create state in country
        State massachusetts = usa.addState("Massachusetts");

        // create cities in state
        City cambridge = massachusetts.addCity("Cambridge");
        massachusetts.addCity("Boston");
        massachusetts.addCity("attleboro");

        State washington = usa.addState("Washington");
        washington.addCity("Seattle");
        washington.addCity("Olimpya");

        State california = usa.addState("california");
        california.addCity("Sacramento");
        california.addCity("Los angeles");

        State newyork = usa.addState("New york");
        newyork.addCity("Albany");
        newyork.addCity("New york city");

        // create admin address in cambridge city
        Address address = cambridge.addAddress("215 Kelton St", "02134");

        // create contact at address
        Contact contact = address.addContact("781-921-8195");

        // create ecosystem organization directory and admin organization
        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();

        // create admin organization
        AdminOrganization admin = new AdminOrganization("United states Department of Health and Human Services", usa, massachusetts, cambridge, address, contact);
        organizationDirectory.addOrganization(admin);

        // create employee in admin organization
        Employee adminEmployee = admin.getEmployeeDirectory().addEmployee("Admin");

        // create user account for admin employee
        Role role = admin.getSupportedRole();
        admin.getUserAccountDirectory().createUserAccount("admin", "admin", adminEmployee, role);

        return ecosystem;
    }

}
