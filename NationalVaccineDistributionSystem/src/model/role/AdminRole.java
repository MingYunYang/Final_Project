package model.role;

import model.NationalVaccineDistributionSystem;
import model.organization.NvdsParticipatingOrganization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.admin.AdminWorkArea;

public class AdminRole extends EmployeeRole {

    public AdminRole() {
        super(RoleType.NVDS_ADMIN_ORG_ADMIN_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.NVDS_ADMIN_ORG_ADMIN_ROLE;
        return new AdminWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
