package nvds.organization;

import nvds.geography.Contact;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.organization.Organization.Type;
import java.util.ArrayList;

public class OrganizationDirectory {

    private final ArrayList<Organization> listOfOrganizations;

    public OrganizationDirectory() {
        listOfOrganizations = new ArrayList<>();
    }

    public void addOrganization(Organization organization) {
        listOfOrganizations.add(organization);
    }

    public void removeOrganization(Organization organization) {
        listOfOrganizations.remove(organization);
    }

    public ArrayList<Organization> getListOfOrganizations() {
        return listOfOrganizations;
    }

    public Organization newOrganization(String name, Type type, Country country, State state, City city, Address address, Contact contact) {

        Organization organization = null;

        if (type.getValue().equals(Type.CDC.getValue())) {
            organization = new CDC(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Clinic.getValue())) {
            organization = new Clinic(name, country, state, city, address, contact);
            organization.createVaccineInventoryCatalog();
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.DistributionCenter.getValue())) {
            organization = new DistributionCenter(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Distributor.getValue())) {
            organization = new Distributor(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Hospital.getValue())) {
            organization = new Hospital(name, country, state, city, address, contact);
            organization.createVaccineInventoryCatalog();
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Manufacturer.getValue())) {
            organization = new Manufacturer(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Public_Health_Department.getValue())) {
            organization = new PublicHealthDepartment(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.NVDS_Admin.getValue())) {
            organization = new NVDSAdmin(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        }
        return organization;
    }
    
    public Organization getAffiliateHospital(City city){
        for(Organization organization : listOfOrganizations){
            if(organization.getCity().equals(city) && organization.getType().equals(Type.Hospital)){
                return organization;
            }
        }
        return null;
    }

}
