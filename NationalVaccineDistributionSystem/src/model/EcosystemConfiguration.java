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
import model.organization.Hospital;
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

        Country usa = ecosystem.addCountry("United States");

        State massachusetts = usa.addState("Massachusetts");
        City cambridge = massachusetts.addCity("Cambridge");
        City boston = massachusetts.addCity("Boston");

        State washington = usa.addState("Washington");
        washington.addCity("Seattle");
        washington.addCity("Olimpya");

        State california = usa.addState("California");
        california.addCity("Sacramento");
        california.addCity("Los Angeles");

        State newyork = usa.addState("New York");
        newyork.addCity("Albany");
        newyork.addCity("New York");

        Address address = cambridge.addAddress("215 Kelton St" , "02134");
        Contact contact = address.addContact("781-921-8195");

        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();
        AdminOrganization adminOrganization = new AdminOrganization("US Dept. of Health and Human Services" , usa , massachusetts , cambridge , address , contact);
        organizationDirectory.addOrganization(adminOrganization);

        Employee adminEmployee = adminOrganization.getEmployeeDirectory().addEmployee("Admin");
        Role adminRole = adminOrganization.getSpecificRole(RoleType.System_Administration_Role);
        adminOrganization.getUserAccountDirectory().createUserAccount("admin" , "admin" , adminEmployee , adminRole);

        
        
        // TESTING
        // create 1 clinic and add 3 roles in it
        Clinic clinic = ( Clinic ) organizationDirectory.newOrganization("Cambridge Clinic" , Organization.Type.Clinic , usa , massachusetts , cambridge , address , contact);

        Employee clinicEmployee1 = clinic.getEmployeeDirectory().addEmployee("libby");
        Role inventoryRole = clinic.getSpecificRole(RoleType.Vaccine_Inventory_Management_Role);
        clinic.getUserAccountDirectory().createUserAccount("1" , "1" , clinicEmployee1 , inventoryRole);

        Employee clinicEmployee2 = clinic.getEmployeeDirectory().addEmployee("william");
        Role reviewRequestsRole = clinic.getSpecificRole(RoleType.Review_Requests_Role);
        clinic.getUserAccountDirectory().createUserAccount("2" , "2" , clinicEmployee2 , reviewRequestsRole);

        Employee clinicEmployee3 = clinic.getEmployeeDirectory().addEmployee("john");
        Role doctorRole = clinic.getSpecificRole(RoleType.Doctor_Role);
        clinic.getUserAccountDirectory().createUserAccount("3" , "3" , clinicEmployee3 , doctorRole);

        VaccineInventoryCatalog clinicInventoryCatalog = clinic.getInventoryCatalog();
        Vaccine vaccine = new Vaccine("Covid-19 Vaccine" , 500 , 1);
        Manufacturer manufacturer = new Manufacturer("Modena" , usa , massachusetts , cambridge , address , contact);
        VaccineItem vaccineItem = new VaccineItem(vaccine , manufacturer , 1);
        OrderItem oi = new OrderItem(vaccineItem , 5);
        clinicInventoryCatalog.getOrderItemList().add(oi);

        // add 1 hospital and add 3 roles in it
        Hospital hospital = ( Hospital ) organizationDirectory.newOrganization("Cambridge Hospital" , Organization.Type.Hospital , usa , massachusetts , cambridge , address , contact);

        Employee hospitalEmployee1 = hospital.getEmployeeDirectory().addEmployee("hospital employee 1");
        Role hospitalInventoryRole = hospital.getSpecificRole(RoleType.Vaccine_Inventory_Management_Role);
        hospital.getUserAccountDirectory().createUserAccount("4" , "4" , hospitalEmployee1 , hospitalInventoryRole);

        Employee hospitalEmployee2 = hospital.getEmployeeDirectory().addEmployee("hospital employee 2");
        Role hospitalReviewRequestsRole = hospital.getSpecificRole(RoleType.Review_Requests_Role);
        hospital.getUserAccountDirectory().createUserAccount("5" , "5" , hospitalEmployee2 , hospitalReviewRequestsRole);

        Employee hospitalEmployee3 = hospital.getEmployeeDirectory().addEmployee("hospital employee 3");
        Role hospitalLabRole = hospital.getSpecificRole(RoleType.LabTechnician_Role);
        hospital.getUserAccountDirectory().createUserAccount("6" , "6" , hospitalEmployee3 , hospitalLabRole);
        
        
        
        
        return ecosystem;
    }

}
