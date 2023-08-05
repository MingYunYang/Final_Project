package nvds;

import nvds.Contact.Contact;
import nvds.Employee.Employee;
import nvds.Geography.Address;
import nvds.Geography.Country;
import nvds.Geography.City;
import nvds.Geography.State;
import nvds.OrderManagement.VaccineOrderItem;
import nvds.Organization.NvdsParticipatingOrganizationsDirectory;
import nvds.Organization.NvdsAdmin;
import nvds.Organization.Clinic;
import nvds.Organization.Hospital;
import nvds.Organization.VaccineManufacturer;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole.OrganizationEmployeeRoleType;
import nvds.VaccineManagement.Vaccine;
import nvds.VaccineManagement.VaccineInventoryCatalog;
import nvds.VaccineManagement.VaccineOrderDetails;

public class NationalVaccineDistributionSystemConfiguration {

    public static NationalVaccineDistributionSystem configure() {

        NationalVaccineDistributionSystem nationalVaccineDistributionSystem
                = NationalVaccineDistributionSystem.getSingleInstance();

        // Create the geographical information(country, state, city, address)and contact information first
        // NVDS Participating Country 1: USA
        Country usa = nationalVaccineDistributionSystem.addParticipatingCountry("United States");
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

        // Create NVDS organization directory to store list of participating organizations, 
        // their geography, address and contact information.
        NvdsParticipatingOrganizationsDirectory nvdsParticipatingOrganizationsDirectory
                = nationalVaccineDistributionSystem.getParticipatingOrganizations();


        // Create an NVDS admin organization to manage the NVDS and add it to the NVDS organization directory
        // Organization name, Country to which the organization belongs, state in the country, city in the state, 
        // address in the city and Contact phone number of the organization
        NvdsAdmin nvdsAdminOrganization
                = ( NvdsAdmin ) nvdsParticipatingOrganizationsDirectory.
                        addNewNvdsAdminOrganization("US Dept. of Health and Human Services" ,
                                NvdsParticipatingOrganization.OrganizationType.NVDS_ADMIN ,
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
        OrganizationEmployeeRole admin1 = nvdsAdminOrganization.getSpecificRole(OrganizationEmployeeRoleType.ORGANIZATION_ADMIN);
        // Create user account for MING an employee of the admin organization
        nvdsAdminOrganization.getUserAccountDirectory()
                .createUserAccount(
                        "ming" ,
                        "ming" ,
                        ming ,
                        admin1
                );

        // This account is for William
        OrganizationEmployeeRole admin2 = nvdsAdminOrganization.getSpecificRole(OrganizationEmployeeRoleType.ORGANIZATION_ADMIN);
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
        Clinic havardSquareClinic
                = ( Clinic ) nvdsParticipatingOrganizationsDirectory.
                        addNewNvdsClinicOrganization("Havard square clinic" ,
                                NvdsParticipatingOrganization.OrganizationType.CLINIC ,
                                usa , massachussets ,
                                cambridge ,
                                nvdsAdminOrganizationAddress ,
                                nvdsAdminOrganizationContact
                        );

        // Employee 1 and thier role and user account
        Employee archil
                = havardSquareClinic.getEmployeeDirectory().addNewEmployee("Archil: CE");
        // get supported role
        OrganizationEmployeeRole clinicVaccineInventoryManagementRole = havardSquareClinic.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_INVENTORY_MANAGER);
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
        OrganizationEmployeeRole clinicReviewVaccineOrderRequestRole = havardSquareClinic.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER);
        // create user account
        havardSquareClinic.getUserAccountDirectory().createUserAccount("kal" ,
                "kal" ,
                kal ,
                clinicReviewVaccineOrderRequestRole);

        // Employee 3 and their role and user account
        Employee meg = havardSquareClinic.getEmployeeDirectory().addNewEmployee("Meghana: CE");
        // get supported roles
        OrganizationEmployeeRole clinicDoctorRole = havardSquareClinic.getSpecificRole(OrganizationEmployeeRoleType.ORGANIZATION_DOCTOR);
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
        VaccineManufacturer modena
                = new VaccineManufacturer(
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
        Hospital cambridgeHospital
                = ( Hospital ) nvdsParticipatingOrganizationsDirectory
                        .addNewNvdsHospitalOrganization("CHA Cambridge Hospital" ,
                                NvdsParticipatingOrganization.OrganizationType.HOSPITAL ,
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
        OrganizationEmployeeRole hospitalVaccineInventoryManagementRole = cambridgeHospital.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_INVENTORY_MANAGER);
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
        OrganizationEmployeeRole hospitalReviewVaccineOrderRequestRole = cambridgeHospital.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER);
        // create user account
        cambridgeHospital.getUserAccountDirectory().createUserAccount("jack" ,
                "jack" ,
                jack ,
                hospitalReviewVaccineOrderRequestRole);

        // Emloyee 3 and role
        Employee joana
                = cambridgeHospital.getEmployeeDirectory().addNewEmployee("Joana");
        // get supported role
        OrganizationEmployeeRole hospitalLabRole = cambridgeHospital.getSpecificRole(OrganizationEmployeeRoleType.HOSPITAL_LAB_TECHNICIAN_ROLE);
        // create user account
        cambridgeHospital.getUserAccountDirectory().createUserAccount(
                "joana" ,
                "joana" ,
                joana ,
                hospitalLabRole);


        return nationalVaccineDistributionSystem;
    }

}
