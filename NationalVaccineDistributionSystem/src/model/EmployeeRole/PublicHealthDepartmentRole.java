package model.EmployeeRole;

import model.NationalVaccineDistributionSystem;
import model.Organization.NvdsParticipatingOrganization;
import model.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.phd.PHDWorkArea;

public class PublicHealthDepartmentRole extends EmployeeRole {

    public PublicHealthDepartmentRole() {
        super(RoleType.PHD_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.PHD_Role;
        return new PHDWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
