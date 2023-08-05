package model.role;

import model.NationalVaccineDistributionSystem;
import model.organization.NvdsParticipatingOrganization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.distributor.DistributorWorkArea;

public class DistributorRole extends EmployeeRole {

    public DistributorRole() {
        super(RoleType.Distributor_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.Distributor_Role;
        return new DistributorWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
