package model.role;

import model.NationalVaccineDistributionSystem;
import model.organization.NvdsParticipatingOrganization;
import model.useraccount.UserAccount;
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
