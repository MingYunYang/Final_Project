package nvds;

import nvds.geography.Contact;
import nvds.employee.Employee;
import nvds.geography.Address;
import nvds.geography.Country;
import nvds.geography.City;
import nvds.geography.State;
import nvds.order.OrderItem;
import nvds.organization.CDC;
import nvds.organization.OrganizationDirectory;
import nvds.organization.Clinic;
import nvds.organization.Hospital;
import nvds.organization.Manufacturer;
import nvds.organization.NVDSAdmin;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.vaccine.Batch;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineCatalog;
import nvds.vaccine.VaccineInventoryCatalog;

public class NationalVaccineDistributionSystemConfiguration {

    public static NationalVaccineDistributionSystem configure() {

        NationalVaccineDistributionSystem nationalVaccineDistributionSystem = NationalVaccineDistributionSystem.getInstance();

        Country usa = nationalVaccineDistributionSystem.addCountry("United States");
        State massachusetts = usa.addState("Massachusetts", 500);
        City cambridge = massachusetts.addCity("Cambridge");
        Address cambridgeAddress = cambridge.addAddress("215 Kelton St" , "02134");
        Contact cambridgeContact = cambridgeAddress.addContact("781-921-8195");
        
        State newyork = usa.addState("New Work", 600);
        City buffalo = newyork.addCity("Buffalo");
        Address buffaloAddress = buffalo.addAddress("39 Florence St" , "03158");
        Contact buffalocContact = buffaloAddress.addContact("654-998-237");

        OrganizationDirectory organizationDirectory = nationalVaccineDistributionSystem.getOrganizationDirectory();
        
        // create 1 nvds admin and add 1 role in it
        NVDSAdmin nvdsAdmin = new NVDSAdmin("US Dept. of Health and Human Services" , usa , massachusetts , cambridge , cambridgeAddress , cambridgeContact);
        organizationDirectory.addOrganization(nvdsAdmin); //要把這裡改用新方法

        Employee adminEmployee = nvdsAdmin.getEmployeeDirectory().addEmployee("admin employee 1");
        Role adminRole = nvdsAdmin.getSpecificRole(RoleType.NVDS_ADMIN);
        nvdsAdmin.getUserAccountDirectory().createUserAccount("admin" , "admin" , adminEmployee , adminRole);


        // TESTING
        // create 1 clinic and add 3 roles in it
        Clinic havardSquareClinic = ( Clinic ) organizationDirectory.newOrganization("Havard Square Clinic" , Organization.Type.Clinic , usa , massachusetts , cambridge , cambridgeAddress , cambridgeContact);

        Employee clinicEmployee1 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 1");
        Role clinicInventoryRole = havardSquareClinic.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic inventory" , "clinic inventory" , clinicEmployee1 , clinicInventoryRole);

        Employee clinicEmployee2 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 2");
        Role clinicReviewRequestsRole = havardSquareClinic.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic review" , "clinic review" , clinicEmployee2 , clinicReviewRequestsRole);

        Employee clinicEmployee3 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 3");
        Role clinicDoctorRole = havardSquareClinic.getSpecificRole(RoleType.CLINIC_DOCTOR);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic doctor" , "clinic doctor" , clinicEmployee3 , clinicDoctorRole);

        // create 1 hospital and add 3 roles in it
        Hospital cambridgeHospital = ( Hospital ) organizationDirectory.newOrganization("Cambridge Hospital" , Organization.Type.Hospital , usa , massachusetts , cambridge , cambridgeAddress , cambridgeContact);

        Employee hospitalEmployee1 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 1");
        Role hospitalInventoryRole = cambridgeHospital.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital inventory" , "hospital inventory" , hospitalEmployee1 , hospitalInventoryRole);

        Employee hospitalEmployee2 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 2");
        Role hospitalReviewRequestsRole = cambridgeHospital.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital review" , "hospital review" , hospitalEmployee2 , hospitalReviewRequestsRole);

        Employee hospitalEmployee3 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 3");
        Role hospitalLabRole = cambridgeHospital.getSpecificRole(RoleType.HOSPITAL_LAB_TECHNICIAN);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital lab" , "hospital lab" , hospitalEmployee3 , hospitalLabRole);

        // create 1 CDC and add 4 roles in it
        CDC usaCDC = ( CDC ) organizationDirectory.newOrganization("United States CDC" , Organization.Type.CDC , usa , massachusetts , cambridge , cambridgeAddress , cambridgeContact);
        
        Employee cdcEmployee1 = usaCDC.getEmployeeDirectory().addEmployee("cdc employee 1");
        Role cdcAdverseEventHandlerRole = usaCDC.getSpecificRole(RoleType.CDC_ADVERSE_EVENT_HANDLER);
        usaCDC.getUserAccountDirectory().createUserAccount("cdc adverse" , "cdc adverse" , cdcEmployee1 , cdcAdverseEventHandlerRole);

        // create  employee 2
        Employee cdcEmployee2 = usaCDC.getEmployeeDirectory().addEmployee("cdc employee 2");
        Role cdcVaccineInventoryManagerRole = usaCDC.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        usaCDC.getUserAccountDirectory().createUserAccount("cdc inventory" , "cdc inventory" , cdcEmployee2 , cdcVaccineInventoryManagerRole);

        // create  employee 3
        Employee cdcEmployee3 = usaCDC.getEmployeeDirectory().addEmployee("cdc employee 3");
        Role cdcVaccineRequestReviewerRole = usaCDC.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        usaCDC.getUserAccountDirectory().createUserAccount("cdc review" , "cdc review" , cdcEmployee3 , cdcVaccineRequestReviewerRole);
        
        // create  employee 4
        Employee cdcEmployee4 = usaCDC.getEmployeeDirectory().addEmployee("cdc employee 4");
        Role cdcCatalogAndAllocationHandlerRole = usaCDC.getSpecificRole(RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER);
        usaCDC.getUserAccountDirectory().createUserAccount("cdc allocation" , "cdc allocation" , cdcEmployee4 , cdcCatalogAndAllocationHandlerRole);

        // create 1 Manufacturer and add 1 role in it
        Manufacturer manufacturer = (Manufacturer) organizationDirectory.newOrganization("Modena", Organization.Type.Manufacturer, usa, massachusetts , cambridge , cambridgeAddress , cambridgeContact);
        
        Employee manufacturerEmployee1 = manufacturer.getEmployeeDirectory().addEmployee("manufacturer employee 1");
        Role manufacturerVaccineInventoryManagerRole = manufacturer.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        manufacturer.getUserAccountDirectory().createUserAccount("manufacturer" , "manufacturer" , manufacturerEmployee1 , manufacturerVaccineInventoryManagerRole);
        
        
        
        // create vaccine for testing
        // create 1 type of vaccine "Covid-19 Vaccine"
        VaccineInventoryCatalog clinicInventoryCatalog = havardSquareClinic.getInventoryCatalog();
        VaccineCatalog vaccineCatalog = usaCDC.getVaccineCatalog();
        Batch batch = new Batch(12, 23, "XXX", 012345, 10);
        String batchId1 = batch.getBatchId();
        Vaccine vaccine = vaccineCatalog.newVaccine("Covid-19 Vaccine", 500, manufacturer, batch, "2023/06/06", "2024/06/06");
        

        OrderItem oi1 = new OrderItem(vaccine , 1);
        clinicInventoryCatalog.getOrderItemList().add(oi1);

        return nationalVaccineDistributionSystem;
    }

}
