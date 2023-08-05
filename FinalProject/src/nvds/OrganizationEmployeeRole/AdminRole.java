package nvds.OrganizationEmployeeRole;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.ui.admin.AdminWorkArea;

public class AdminRole extends OrganizationEmployeeRole {

    public AdminRole() {
        super(OrganizationEmployeeRoleType.ORGANIZATION_ADMIN);
    }

    @Override
    public JPanel createWorkArea(JPanel accountUserProcessContainer , UserAccount employeeUserAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeRoleType = OrganizationEmployeeRoleType.ORGANIZATION_ADMIN;
        return new AdminWorkArea(accountUserProcessContainer , NationalVaccineDistributionSystem.getNvdsSingleInstance());
    }

}
