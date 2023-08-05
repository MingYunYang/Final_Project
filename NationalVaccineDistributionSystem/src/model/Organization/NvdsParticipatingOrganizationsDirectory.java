package model.Organization;

import model.Contact.Contact;
import model.Address.Address;
import model.Location.City;
import model.Location.Country;
import model.Location.State;
import model.Organization.NvdsParticipatingOrganization.OrganizationType;
import java.util.ArrayList;

public class NvdsParticipatingOrganizationsDirectory {

    private final ArrayList<NvdsParticipatingOrganization> listOfOrganizations;

    public NvdsParticipatingOrganizationsDirectory() {
        listOfOrganizations = new ArrayList<>();
    }

    public void removeOrganization(NvdsParticipatingOrganization organization) {
        listOfOrganizations.remove(organization);
    }

    public ArrayList<NvdsParticipatingOrganization> getListOfOrganizations() {
        return listOfOrganizations;
    }

    public NvdsParticipatingOrganization addNewNvdsClinicOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.NVDS_CLINIC_ORG.getValue()) ) {
            throw new IllegalArgumentException("Type must be Clinic for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsClinic(name , country , state , city , address , contact);
        organization.createVaccineInventoryCatalog();
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsHospitalOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.NVDS_HOSPITAL_ORG.getValue()) ) {
            throw new IllegalArgumentException("Type must be Hospital for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsHospital(name , country , state , city , address , contact);
        organization.createVaccineInventoryCatalog();
        listOfOrganizations.add(organization);
        return organization;
    }


    public NvdsParticipatingOrganization addNewNvdsCDC(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.CDC.getValue()) ) {
            throw new IllegalArgumentException("Type must be CDC for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsCDC(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsDistributionCenter(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.DistributionCenter.getValue()) ) {
            throw new IllegalArgumentException("Type must be DistributionCenter for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsVaccineDistributionCenter(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsVaccineDistributorOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.Distributor.getValue()) ) {
            throw new IllegalArgumentException("Type must be Distributor for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsVaccineDistributor(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsVaccineManufacturerOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.Manufacturer.getValue()) ) {
            throw new IllegalArgumentException("Type must be Manufacturer for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsVaccineManufacturer(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsPHD(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.Public_Health_Department.getValue()) ) {
            throw new IllegalArgumentException("Type must be Public_Health_Department for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsPHD(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsProviderOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.Provider.getValue()) ) {
            throw new IllegalArgumentException("Type must be Provider for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsVaccineProvider(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }

    public NvdsParticipatingOrganization addNewNvdsAdminOrganization(String name , OrganizationType type , Country country , State state , City city , Address address , Contact contact) {
        if (  ! type.getValue().equals(OrganizationType.NVDS_ADMIN_ORG.getValue()) ) {
            throw new IllegalArgumentException("Type must be SystemAdmin for this method.");
        }
        NvdsParticipatingOrganization organization = new NvdsAdminOrganization(name , country , state , city , address , contact);
        listOfOrganizations.add(organization);
        return organization;
    }


    public NvdsParticipatingOrganization getAffiliateHospital(City city) {
        for ( NvdsParticipatingOrganization organization : listOfOrganizations ) {
            if ( organization.getCity().equals(city) && organization.getType().equals(OrganizationType.NVDS_HOSPITAL_ORG) ) {
                return organization;
            }
        }
        return null;
    }

}
