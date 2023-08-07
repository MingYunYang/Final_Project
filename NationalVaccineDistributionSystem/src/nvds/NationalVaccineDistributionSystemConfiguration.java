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
import nvds.organization.NVDSAdmin;
import nvds.organization.Clinic;
import nvds.organization.Hospital;
import nvds.organization.Manufacturer;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;
import nvds.vaccine.VaccineItem;

public class NationalVaccineDistributionSystemConfiguration {

    public static NationalVaccineDistributionSystem configure() {

        NationalVaccineDistributionSystem nationalVaccineDistributionSystem = NationalVaccineDistributionSystem.getInstance();

        Country usa = nationalVaccineDistributionSystem.addCountry("United States");

        State massachusetts = usa.addState("Massachusetts");
        City cambridge = massachusetts.addCity("Cambridge");
        City boston = massachusetts.addCity("Boston");
        City attleboro = massachusetts.addCity("Attleboro");

        Address address = cambridge.addAddress("215 Kelton St" , "02134");
        Contact contact = address.addContact("781-921-8195");

        OrganizationDirectory organizationDirectory = nationalVaccineDistributionSystem.getOrganizationDirectory();
        NVDSAdmin adminOrganization = new NVDSAdmin("US Dept. of Health and Human Services" , usa , massachusetts , cambridge , address , contact);
        organizationDirectory.addOrganization(adminOrganization); //要把這裡改用新方法

        Employee adminEmployee = adminOrganization.getEmployeeDirectory().addEmployee("admin employee 1");
        Role adminRole = adminOrganization.getSpecificRole(RoleType.NVDS_ADMIN);
        adminOrganization.getUserAccountDirectory().createUserAccount("admin" , "admin" , adminEmployee , adminRole);

        
        
        // TESTING
        // create 1 clinic and add 3 roles in it
        Clinic havardSquareClinic = ( Clinic ) organizationDirectory.newOrganization("Havard Square Clinic" , Organization.Type.Clinic , usa , massachusetts , cambridge , address , contact);

        Employee clinicEmployee1 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 1");
        Role clinicInventoryRole = havardSquareClinic.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic inventory" , "clinic inventory" , clinicEmployee1 , clinicInventoryRole);

        Employee clinicEmployee2 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 2");
        Role clinicReviewRequestsRole = havardSquareClinic.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic review" , "clinic review" , clinicEmployee2 , clinicReviewRequestsRole);

        Employee clinicEmployee3 = havardSquareClinic.getEmployeeDirectory().addEmployee("clinic employee 3");
        Role clinicDoctorRole = havardSquareClinic.getSpecificRole(RoleType.CLINIC_DOCTOR);
        havardSquareClinic.getUserAccountDirectory().createUserAccount("clinic doctor" , "clinic doctor" , clinicEmployee3 , clinicDoctorRole);

        // create vaccine item to be added to the invantory catalog of the clinic
        VaccineInventoryCatalog clinicInventoryCatalog = havardSquareClinic.getInventoryCatalog();
        Vaccine vaccine = new Vaccine("Covid-19 Vaccine" , 500 , 1);
        Manufacturer manufacturer = new Manufacturer("Modena" , usa , massachusetts , cambridge , address , contact);
        VaccineItem vaccineItem = new VaccineItem(vaccine , manufacturer , 1);
        OrderItem oi = new OrderItem(vaccineItem , 5);
        clinicInventoryCatalog.getOrderItemList().add(oi);

        // create 1 hospital and add 3 roles in it
        Hospital cambridgeHospital = ( Hospital ) organizationDirectory.newOrganization("Cambridge Hospital" , Organization.Type.Hospital , usa , massachusetts , cambridge , address , contact);

        Employee hospitalEmployee1 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 1");
        Role hospitalInventoryRole = cambridgeHospital.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital inventory" , "hospital inventory" , hospitalEmployee1 , hospitalInventoryRole);

        Employee hospitalEmployee2 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 2");
        Role hospitalReviewRequestsRole = cambridgeHospital.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital review" , "hospital review" , hospitalEmployee2 , hospitalReviewRequestsRole);

        Employee hospitalEmployee3 = cambridgeHospital.getEmployeeDirectory().addEmployee("hospital employee 3");
        Role hospitalLabRole = cambridgeHospital.getSpecificRole(RoleType.HOSPITAL_LAB_TECHNICIAN);
        cambridgeHospital.getUserAccountDirectory().createUserAccount("hospital lab" , "hospital lab" , hospitalEmployee3 , hospitalLabRole);
        
        // create 1 CDC and add 1 role in it
        CDC usaCDC = ( CDC ) organizationDirectory.newOrganization("USA CDC" , Organization.Type.CDC , usa , massachusetts , cambridge , address , contact);
        Employee cdcEmployee1 = usaCDC.getEmployeeDirectory().addEmployee("cdc employee 1");
        Role cdcAdverseEventHandlerRole = usaCDC.getSpecificRole(RoleType.CDC_ADVERSE_EVENT_HANDLER);
        usaCDC.getUserAccountDirectory().createUserAccount("cdc" , "cdc" , cdcEmployee1 , cdcAdverseEventHandlerRole);
        
        return nationalVaccineDistributionSystem;
    }

}
