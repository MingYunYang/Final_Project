package model;

import java.util.ArrayList;
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

        // create admin organization
        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();
        AdminOrganization admin = new AdminOrganization("United states Department of Health and Human Services", usa, massachusetts, cambridge, address, contact);
        organizationDirectory.addOrganization(admin);

        // create an employee and user account in admin organization
        Employee adminEmployee = admin.getEmployeeDirectory().addEmployee("Admin");
        Role adminRole = admin.getSpecificRole(RoleType.System_Administration_Role);
        admin.getUserAccountDirectory().createUserAccount("admin", "admin", adminEmployee, adminRole);
        
        
        // TESTING
        Clinic clinic = (Clinic) organizationDirectory.newOrganization("Malden Clinic", Organization.Type.Clinic, usa, massachusetts, cambridge, address, contact);
        Employee clinicEmployee = clinic.getEmployeeDirectory().addEmployee("libby");
        Role inventoryRole = clinic.getSpecificRole(RoleType.Inventory_Role);
        clinic.getUserAccountDirectory().createUserAccount("inventory", "inventory", clinicEmployee, inventoryRole);
        
        VaccineInventoryCatalog clinicInventoryCatalog = clinic.getInventoryCatalog();
        Vaccine vaccine = new Vaccine("Covid-19 Vaccine", 500, 1);
        Manufacturer manufacturer = new Manufacturer("Modena", usa, massachusetts, cambridge, address, contact);
        VaccineItem vaccineItem = new VaccineItem(vaccine, manufacturer, 1);
        OrderItem oi = new OrderItem(vaccineItem, 5);
        clinicInventoryCatalog.getOrderItemList().add(oi);

        return ecosystem;
    }

}
