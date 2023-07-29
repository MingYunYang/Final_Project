/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ecosystem;

import Contact.Contact;
import Employee.Employee;
import Employee.EmployeeDirectory;
import Geography.Address;
import Geography.Country;
import Geography.City;
import Geography.State;
import Organization.OrganizationDirectory;
import Organization.SystemManagementOrganization;
import Role.SystemManagementRole;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

/**
 *
 * @author libby
 */
public class ConfigureEcosystem {
    
    public static Ecosystem configure(){
        
                
        Ecosystem ecosystem = Ecosystem.getInstance();
        OrganizationDirectory organizationDirectory = ecosystem.getOrganizationDirectory();
        
        //Create 1 country、1 state、2 city (each with 1 site)
        Country usa = new Country();
        usa.setCountryName("USA");
        ecosystem.getCountryList().add(usa);
        
        State massachusetts = usa.newState();
        massachusetts.setStateName("Massachusetts");
        
        City malden = massachusetts.newCity();
        malden.setCityName("Malden");
        City cambridge = massachusetts.newCity();
        cambridge.setCityName("Cambridge");
        
        
        //Create an address、a contact for SystemManagement Organization
        Address address = new Address("215 Kelton St", "02134");
        Contact contact = new Contact("781-921-8195");
        System.out.println(contact.getPhoneNumber());
        
        //Create a SystemManagement Organization
        SystemManagementOrganization smo = new SystemManagementOrganization(usa, massachusetts, cambridge, address, contact);
        organizationDirectory.addOrganization(smo);

        //Create an employee in SystemManagement Organization
        EmployeeDirectory ed = smo.getEmployeeDirectory();
        Employee systemManagementEmployee = ed.newEmployee("Libby");
        
        //Create a user account for this employee in SystemManagement Organization
        SystemManagementRole smr = new SystemManagementRole();
        smo.getSupportedRole().add(smr);
        
        UserAccountDirectory uad = smo.getUserAccountDirectory();
        UserAccount systemManagementUserAccount = uad.createUserAccount("system", "system", systemManagementEmployee, smr);
        
      
        

        return ecosystem;
    }
    
}
