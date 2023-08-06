package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;

public class DoctorRole extends OrganizationEmployeeRole {

    public DoctorRole() {
        super(OrganizationEmployeeRoleType.CLINIC_LAB_TECHNICIAN);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeUserAccountRoleType = OrganizationEmployeeRoleType.CLINIC_LAB_TECHNICIAN;

        if ( nvdsParticipatingOrganization instanceof Clinic ) {
            return new ClinicWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        }
        return null;
    }

}
