package nvds.Role;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.ui.distributioncenter.DistributionCenterWorkArea;

public class DistributionCenterRole extends EmployeeRole {

    public DistributionCenterRole() {
        super(EmployeeRoleType.DistributionCenter_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRoleType.DistributionCenter_Role;
        return new DistributionCenterWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
