package model.EmployeeRole;

import model.NationalVaccineDistributionSystem;
import model.Organization.NvdsParticipatingOrganization;
import model.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.cdc.CDCWorkArea;

public class CDCRole extends EmployeeRole {

    public CDCRole() {
        super(RoleType.CDC_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.CDC_Role;
        return new CDCWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
