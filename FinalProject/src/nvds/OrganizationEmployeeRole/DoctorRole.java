package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;

public class DoctorRole extends OrganizationEmployeeUserAccountRole {

    public DoctorRole() {
        super(OrganizationEmployeeRoleType.ORGANIZATION_DOCTOR);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeUserAccountRoleType = OrganizationEmployeeRoleType.ORGANIZATION_DOCTOR;

        if ( nvdsParticipatingOrganization instanceof Clinic ) {
            return new ClinicWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        }
        return null;
    }

}
