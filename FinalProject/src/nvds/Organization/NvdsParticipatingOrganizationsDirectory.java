package nvds.Organization;

import nvds.Contact.Contact;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Organization.NvdsParticipatingOrganization.OrganizationType;
import java.util.ArrayList;

public class NvdsParticipatingOrganizationsDirectory {

    private final ArrayList<NvdsParticipatingOrganization> listOfParticipatingOrganizations;

    public NvdsParticipatingOrganizationsDirectory() {
        listOfParticipatingOrganizations = new ArrayList<>();
    }

    public ArrayList<NvdsParticipatingOrganization> getListOfParticipatingOrganizations() {
        return listOfParticipatingOrganizations;
    }

    public NvdsParticipatingOrganization addNewNvdsClinicOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.CLINIC.getValue()) ) {
            throw new IllegalArgumentException("Type must be Clinic for this method.");
        }
        NvdsParticipatingOrganization organization = new Clinic(name , country , state , city , address , contact);
        organization.createVaccineInventoryCatalog();
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsHospitalOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.HOSPITAL.getValue()) ) {
            throw new IllegalArgumentException("Type must be Hospital for this method.");
        }
        NvdsParticipatingOrganization organization = new Hospital(name , country , state , city , address , contact);
        organization.createVaccineInventoryCatalog();
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }


    public NvdsParticipatingOrganization addNewNvdsCDC(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.CDC.getValue()) ) {
            throw new IllegalArgumentException("Type must be CDC for this method.");
        }
        NvdsParticipatingOrganization organization = new CDC(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsDistributionCenter(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.VACCINE_DISTRIBUTION_CENTER.getValue()) ) {
            throw new IllegalArgumentException("Type must be DistributionCenter for this method.");
        }
        NvdsParticipatingOrganization organization = new VaccineDistributionCenter(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsVaccineDistributorOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.VACCINE_DISTRIBUTOR.getValue()) ) {
            throw new IllegalArgumentException("Type must be Distributor for this method.");
        }
        NvdsParticipatingOrganization organization = new VaccineDistributor(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsVaccineManufacturerOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.VACCINE_MANUFACTURER.getValue()) ) {
            throw new IllegalArgumentException("Type must be Manufacturer for this method.");
        }
        NvdsParticipatingOrganization organization = new Manufacturer(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsPHD(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.PHD.getValue()) ) {
            throw new IllegalArgumentException("Type must be Public_Health_Department for this method.");
        }
        NvdsParticipatingOrganization organization = new PublicHealthDepartment(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsProviderOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.Provider.getValue()) ) {
            throw new IllegalArgumentException("Type must be Provider for this method.");
        }
        NvdsParticipatingOrganization organization = new VaccineProvider(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsAdminOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.NVDS_ADMIN.getValue()) ) {
            throw new IllegalArgumentException("Type must be SystemAdmin for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsAdmin(name , country , state , city , address , contact);
        listOfParticipatingOrganizations.add(organization);
        return organization;
    }


    public NvdsParticipatingOrganization getAffiliateHospital(City organizationCity) {
        for ( NvdsParticipatingOrganization organization : listOfParticipatingOrganizations ) {
            if ( organization.getOrganizationCity().equals(organizationCity) && organization.getTypeOfOrganization().equals(OrganizationType.HOSPITAL) ) {
                return organization;
            }
        }
        return null;
    }

}
