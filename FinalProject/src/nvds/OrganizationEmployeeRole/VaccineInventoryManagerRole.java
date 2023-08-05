package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;
import nvds.ui.hospital.HospitalWorkArea;

public class VaccineInventoryManagerRole extends OrganizationEmployeeRole {

    public VaccineInventoryManagerRole() {
        super(OrganizationEmployeeRoleType.VACCINE_INVENTORY_MANAGER);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeRoleType = OrganizationEmployeeRoleType.VACCINE_INVENTORY_MANAGER;

        if ( nvdsParticipatingOrganization instanceof Clinic ) {
            return new ClinicWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getNvdsSingleInstance());
        } else if ( nvdsParticipatingOrganization instanceof Hospital ) {
            return new HospitalWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getNvdsSingleInstance());
        }
        return null;
    }

}
