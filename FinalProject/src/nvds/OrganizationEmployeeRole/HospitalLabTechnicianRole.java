package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.hospital.HospitalWorkArea;

public class HospitalLabTechnicianRole extends OrganizationEmployeeRole {

    public HospitalLabTechnicianRole() {
        super(OrganizationEmployeeRole.OrganizationEmployeeRoleType.HOSPITAL_LAB_TECHNICIAN);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeUserAccountRoleType = OrganizationEmployeeRole.OrganizationEmployeeRoleType.HOSPITAL_LAB_TECHNICIAN;

        if ( nvdsParticipatingOrganization instanceof Hospital ) {
            return new HospitalWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        }
        return null;
    }

}
