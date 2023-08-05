package model.EmployeeRole;

import model.NationalVaccineDistributionSystem;
import model.Organization.NvdsParticipatingOrganization;
import model.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.provider.ProviderWorkArea;

public class ProviderRole extends EmployeeRole {

    public ProviderRole() {
        super(RoleType.Provider_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.Provider_Role;
        return new ProviderWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
