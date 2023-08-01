package ecosystem;

import ecosystem.geographies.Contact;
import ecosystem.employee.Employee;
import ecosystem.geographies.Address;
import ecosystem.geographies.Country;
import ecosystem.geographies.City;
import ecosystem.geographies.State;
import ecosystem.order.OrderItem;
import ecosystem.organization.OrganizationDirectory;
import ecosystem.organization.AdminOrganization;
import ecosystem.organization.Clinic;
import ecosystem.organization.Manufacturer;
import ecosystem.organization.Organization;
import ecosystem.role.AdminRole;
import ecosystem.role.Role;
import ecosystem.vaccine.Vaccine;
import ecosystem.vaccine.VaccineInventoryCatalog;
import ecosystem.vaccine.VaccineItem;

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

        
        
        // TESTING: clinic ui
        Clinic clinic = (Clinic) organizationDirectory.newOrganization("Malden Clinic", Organization.Type.Clinic, usa, massachusetts, cambridge, address, contact);
        
        Employee clinicEmployee = clinic.getEmployeeDirectory().addEmployee("libby");
        Role clinicrole = clinic.getSupportedRole();
        clinic.getUserAccountDirectory().createUserAccount("clinic", "clinic", clinicEmployee, clinicrole);
        
        // create vaccine item * 5 to be addded to clinic's inventory
        VaccineInventoryCatalog clinicInventoryCatalog = clinic.getInventoryCatalog();
        Vaccine vaccine = new Vaccine("Covid-19 Vaccine", 500, 1);
        Manufacturer manufacturer = new Manufacturer("Modena", usa, massachusetts, cambridge, address, contact);
        VaccineItem vaccineItem = new VaccineItem(vaccine, manufacturer, 1);
        OrderItem oi = new OrderItem(vaccineItem, 5);
        clinicInventoryCatalog.getOrderItemList().add(oi);

        
        
        
        return ecosystem;
    }

}
