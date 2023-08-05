package nvds.Role;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.ui.distributor.DistributorWorkArea;

public class DistributorRole extends EmployeeRole {

    public DistributorRole() {
        super(EmployeeRoleType.Distributor_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRoleType.Distributor_Role;
        return new DistributorWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
