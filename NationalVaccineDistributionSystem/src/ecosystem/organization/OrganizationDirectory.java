package ecosystem.organization;

import ecosystem.geographies.Contact;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.organization.Organization.Type;
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

    public Organization addOrganization(String name, Type type, Country country, State state, City city, Address address, Contact contact) {

        Organization organization = null;

        if (type.getValue().equals(Type.CDC.getValue())) {
            organization = new CDC(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Clinic.getValue())) {
            organization = new Clinic(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.DistributionCenter.getValue())) {
            organization = new DistributionCenter(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Distributor.getValue())) {
            organization = new Distributor(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Hospital.getValue())) {
            organization = new Hospital(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Manufacturer.getValue())) {
            organization = new Manufacturer(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.PUBLIC_HEALTH_DEPARTMENT.getValue())) {
            organization = new PublicHealthDepartment(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.Provider.getValue())) {
            organization = new Provider(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        } else if (type.getValue().equals(Type.SystemAdmin.getValue())) {
            organization = new AdminOrganization(name, country, state, city, address, contact);
            listOfOrganizations.add(organization);
        }
        return organization;
    }

}
