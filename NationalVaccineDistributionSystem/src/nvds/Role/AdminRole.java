package nvds.Role;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.ui.admin.AdminWorkArea;

public class AdminRole extends EmployeeRole {

    public AdminRole() {
        super(EmployeeRoleType.NVDS_ADMIN_ORG_ADMIN_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer , UserAccount account , NvdsParticipatingOrganization organization , NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRoleType.NVDS_ADMIN_ORG_ADMIN_ROLE;
        return new AdminWorkArea(userProcessContainer , NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
