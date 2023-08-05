package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.hospital.HospitalWorkArea;

public class HospitalLabTechnicianRole extends OrganizationEmployeeRole {

    public HospitalLabTechnicianRole() {
        super(OrganizationEmployeeRole.OrganizationEmployeeRoleType.HOSPITAL_LAB_TECHNICIAN_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeRoleType = OrganizationEmployeeRole.OrganizationEmployeeRoleType.HOSPITAL_LAB_TECHNICIAN_ROLE;

        if ( nvdsParticipatingOrganization instanceof Hospital ) {
            return new HospitalWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getNvdsSingleInstance());
        }
        return null;
    }

}
