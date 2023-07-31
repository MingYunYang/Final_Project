package ecosystem;

import ecosystem.geographies.Contact;
import ecosystem.employee.Employee;
import ecosystem.geographies.Address;
import ecosystem.geographies.Country;
import ecosystem.geographies.City;
import ecosystem.geographies.State;
import ecosystem.organization.OrganizationDirectory;
import ecosystem.organization.AdminOrganization;
import ecosystem.role.AdminRole;

public class ConfigureEcosystem {

    public static Ecosystem configure() {

        Ecosystem ecosystem = Ecosystem.getInstance();

        // create country
        Country usa = ecosystem.addCountry("United States");

        // create state in country
        State massachusetts = usa.addState("Massachusetts");

        // create city in state
        City cambridge = massachusetts.addCity("Cambridge");

        // create address in city
        Address address = cambridge.addAddress("215 Kelton St", "02134");

        // create contact at address
        Contact contact = address.addContact("781-921-8195");

        // Create ecosystem organization directory and admin organization
        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();

        // Create admin organization
        AdminOrganization admin = new AdminOrganization("United states Department of Health and Human Services", usa, massachusetts, cambridge, address, contact);
        organizationDirectory.addOrganization(admin);

        // create employee in admin organization
        Employee adminEmployee = admin.getEmployeeDirectory().addEmployee("Admin");

        // create user account for admin employee
        admin.getUserAccountDirectory().createUserAccount("admin", "admin", adminEmployee, new AdminRole());

        return ecosystem;
    }

}
