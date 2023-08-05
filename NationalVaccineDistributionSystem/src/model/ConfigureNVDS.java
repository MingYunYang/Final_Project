package model;

import model.Contact.Contact;
import model.Employee.Employee;
import model.Address.Address;
import model.Location.Country;
import model.Location.City;
import model.Location.State;
import model.OrganizationVaccineOrderManagement.VaccineOrderItem;
import model.Organization.NvdsParticipatingOrganizationsDirectory;
import model.Organization.NvdsAdminOrganization;
import model.Organization.NvdsClinic;
import model.Organization.NvdsHospital;
import model.Organization.NvdsVaccineManufacturer;
import model.Organization.NvdsParticipatingOrganization;
import model.EmployeeRole.EmployeeRole;
import model.EmployeeRole.EmployeeRole.RoleType;
import model.Vaccine.Vaccine;
import model.Vaccine.VaccineInventoryCatalog;
import model.Vaccine.VaccineOrderDetails;

public class ConfigureNVDS {

    public static NationalVaccineDistributionSystem configure() {

        NationalVaccineDistributionSystem nationalVaccineDistributionSystem
                = NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance();

        // NVDS Participating Country 1: USA
        Country usa = nationalVaccineDistributionSystem.addNewParticipatingCountry("United States");
        // NVDS Participating Country 1: USA - State 1: Massachussets
        State massachussets = usa.addState("Massachusetts");
        // NVDS Participating country 1: USA - State 1: Massachussets - City 1: Boston
        massachussets.addCity("Boston");
        // NVDS Participating Country 1: USA - State 1: Massachussets - City 2: Attleboro
        massachussets.addCity("Attleboro");
        // NVDS Participating Country 1: USA - State 1: Massachussets - City 3: Cambridge
        City cambridge = massachussets.addCity("Cambridge");

        // ADD NVDS Admin orgainzation nvdsAdminOrganizationAddress(street and postal code), 
        // in NVDS Participating Country 1: USA - State 1: Massachussets City 3: Cambridge
        Address nvdsAdminOrganizationAddress = cambridge.addAddress("215 Kelton St" , "02134");
        // ADD NVDS Admin NvdsParticipatingOrganization Contact phone number
        Contact nvdsAdminOrganizationContact = nvdsAdminOrganizationAddress.addContact("781-921-8195");

        // Create NVDS orgainization directory
        NvdsParticipatingOrganizationsDirectory nvdsParticipatingOrganizationsDirectory
                = nationalVaccineDistributionSystem.getNvdsListOfParticipatingOrganizations();

        // Create an NVDS admin organization to manage the NVDS and add it to the NVDS organization directory
        // Organization name, Country to which the organization belongs, state in the country, city in the state, 
        // address in the city and Contact phone number of the organization
        NvdsAdminOrganization nvdsAdminOrganization
                = ( NvdsAdminOrganization ) nvdsParticipatingOrganizationsDirectory.
                        addNewNvdsAdminOrganization("US Dept. of Health and Human Services" ,
                                NvdsParticipatingOrganization.OrganizationType.NVDS_ADMIN_ORG ,
                                usa , massachussets ,
                                cambridge ,
                                nvdsAdminOrganizationAddress ,
                                nvdsAdminOrganizationContact
                        );

        // Create NVDS admin organization Employees
        // This employee in the NVDS admin organization, will be responsible for managing the whole NVDS system
        Employee ming
                = nvdsAdminOrganization.getEmployeeDirectory().addNewEmployee("Ming Yun Yang");
        Employee william
                = nvdsAdminOrganization.getEmployeeDirectory().addNewEmployee("Tugume William Mutara");

        // Get NVDS admin organization supported employee roles and assign each adminOrganization Employee a role
        // This role depaends on the roles that an organization supports
        // This account is for MING
        EmployeeRole admin1 = nvdsAdminOrganization.setSupportedEmployeeRole(RoleType.NVDS_ADMIN_ORG_ADMIN_ROLE);
        // Create user account for MING an employee of the admin organization
        nvdsAdminOrganization.getUserAccountDirectory()
                .createUserAccount(
                        "ming" ,
                        "ming" ,
                        ming ,
                        admin1
                );

        // This account is for William
        EmployeeRole admin2 = nvdsAdminOrganization.setSupportedEmployeeRole(RoleType.NVDS_ADMIN_ORG_ADMIN_ROLE);
        // Create user account for MING an employee of the admin organization
        // This employee in the NVDS admin organization, will be responsible for managing the whole NVDS 
        nvdsAdminOrganization.getUserAccountDirectory()
                .createUserAccount(
                        "william" ,
                        "william" ,
                        william ,
                        admin2
                );

        // TESTING NVDS CLINIC ORGANIZATION
        // create 1 clinic organization for testing: 
        // havardSquareClinic in cambridge massachussets and add 3 employees and their roles in havard square clinic
        NvdsClinic havardSquareClinic
                = ( NvdsClinic ) nvdsParticipatingOrganizationsDirectory.
                        addNewNvdsClinicOrganization("Havard square clinic" ,
                                NvdsParticipatingOrganization.OrganizationType.NVDS_CLINIC_ORG ,
                                usa , massachussets ,
                                cambridge ,
                                nvdsAdminOrganizationAddress ,
                                nvdsAdminOrganizationContact
                        );

        // Employee 1 and thier role and user account
        Employee archil
                = havardSquareClinic.getEmployeeDirectory().addNewEmployee("Archil: CE");
        // get supported role
        EmployeeRole clinicVaccineInventoryManagementRole = havardSquareClinic.setSupportedEmployeeRole(RoleType.VACCINE_INVENTORY_MANAGEMENT_ROLE);
        // create user acount
        havardSquareClinic.getUserAccountDirectory().createUserAccount("archil" ,
                "archil" ,
                archil ,
                clinicVaccineInventoryManagementRole
        );

        // Employee 2 and their role and user account
        Employee kal
                = havardSquareClinic.getEmployeeDirectory().addNewEmployee("Kal: CE");
        // get supported role
        EmployeeRole clinicReviewVaccineOrderRequestRole = havardSquareClinic.setSupportedEmployeeRole(RoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE);
        // create user account
        havardSquareClinic.getUserAccountDirectory().createUserAccount("kal" ,
                "kal" ,
                kal ,
                clinicReviewVaccineOrderRequestRole);

        // Employee 3 and their role and user account
        Employee meg = havardSquareClinic.getEmployeeDirectory().addNewEmployee("Meghana: CE");
        // get supported roles
        EmployeeRole clinicDoctorRole = havardSquareClinic.setSupportedEmployeeRole(RoleType.CLINIC_DOCTOR_ROLE);
        // create user account
        havardSquareClinic.getUserAccountDirectory().createUserAccount(
                "meg" ,
                "meg" ,
                meg ,
                clinicDoctorRole);

        // Clinic covid19Vaccine inventory catalog for havard square clinic
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = havardSquareClinic.getVaccineInventoryCatalog();
        // Create a new Vaccine
        Vaccine covid19Vaccine = new Vaccine("Covid-19 Vaccine" , 500 , 1);
        // Create the covid19Vaccine modena
        NvdsVaccineManufacturer modena
                = new NvdsVaccineManufacturer(
                        "Modena" ,
                        usa ,
                        massachussets ,
                        cambridge ,
                        nvdsAdminOrganizationAddress ,
                        nvdsAdminOrganizationContact
                );
        // Create a new covid19Vaccine order details
        VaccineOrderDetails modenaCovid19Vaccine = new VaccineOrderDetails(covid19Vaccine , modena , 1);
        // And vaccine order details to order item and add quantity for each vaccine order
        VaccineOrderItem modenaCovid19VaccineOrderAndQuantity = new VaccineOrderItem(modenaCovid19Vaccine , 500);
        clinicVaccineInventoryCatalog.getVaccineOrderItemList().add(modenaCovid19VaccineOrderAndQuantity);

        // TESTING NVDS HOSPITAL ORGANIZATION
        // Create 1 cambridgeHospital and add 3 roles in it
        NvdsHospital cambridgeHospital
                = ( NvdsHospital ) nvdsParticipatingOrganizationsDirectory
                        .addNewNvdsHospitalOrganization("CHA Cambridge Hospital" ,
                                NvdsParticipatingOrganization.OrganizationType.NVDS_HOSPITAL_ORG ,
                                usa ,
                                massachussets ,
                                cambridge ,
                                nvdsAdminOrganizationAddress ,
                                nvdsAdminOrganizationContact
                        );

        // Hospital employees and there roles
        // Employee 1 and role
        Employee rose
                = cambridgeHospital.getEmployeeDirectory().addNewEmployee("Rose: HE");
        // get supported role
        EmployeeRole hospitalVaccineInventoryManagementRole = cambridgeHospital.setSupportedEmployeeRole(RoleType.VACCINE_INVENTORY_MANAGEMENT_ROLE);
        // create user account
        cambridgeHospital.getUserAccountDirectory().createUserAccount("rose" ,
                "rose" ,
                rose ,
                hospitalVaccineInventoryManagementRole
        );

        // Employee 2 and role
        Employee jack
                = cambridgeHospital.getEmployeeDirectory().addNewEmployee("Jack: HE");
        // get supported role
        EmployeeRole hospitalReviewVaccineOrderRequestRole = cambridgeHospital.setSupportedEmployeeRole(RoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE);
        // create user account
        cambridgeHospital.getUserAccountDirectory().createUserAccount("jack" ,
                "jack" ,
                jack ,
                hospitalReviewVaccineOrderRequestRole);

        // Emloyee 3 and role
        Employee joana
                = cambridgeHospital.getEmployeeDirectory().addNewEmployee("Joana");
        // get supported role
        EmployeeRole hospitalLabRole = cambridgeHospital.setSupportedEmployeeRole(RoleType.HOSPITAL_LAB_TECHNICIAN_ROLE);
        // create user account
        cambridgeHospital.getUserAccountDirectory().createUserAccount(
                "joana" ,
                "joana" ,
                joana ,
                hospitalLabRole);


        return nationalVaccineDistributionSystem;
    }

}
