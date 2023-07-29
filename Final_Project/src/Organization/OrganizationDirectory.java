/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import Contact.Contact;
import Geography.Address;
import Geography.City;
import Geography.Country;
import Geography.State;
import Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }
    
    public void addOrganization(Organization organization) {
        organizationList.add(organization);
    }
    
    public void removeOrganization(Organization organization){
        organizationList.remove(organization);
    }
    
    public Organization newOrganization(Type type, Country country, State state, City city, Address address, Contact contact){
        
        Organization organization = null;
        
        if (type.getValue().equals(Type.CDC.getValue())){
            organization = new CDCOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Clinic.getValue())){
            organization = new ClinicOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DistributionCenter.getValue())){
            organization = new DistributionCenterOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Distributor.getValue())){
            organization = new DistributorOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Hospital.getValue())){
            organization = new HospitalOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Manufacturer.getValue())){
            organization = new ManufacturerOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PHD.getValue())){
            organization = new PHDOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Provider.getValue())){
            organization = new ProviderOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.SystemManagement.getValue())){
            organization = new SystemManagementOrganization(country, state, city, address, contact);
            organizationList.add(organization);
        }
        return organization;
    }
    
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
}
