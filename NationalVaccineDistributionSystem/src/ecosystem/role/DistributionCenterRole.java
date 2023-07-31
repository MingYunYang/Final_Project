package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.distributioncenter.DistributionCenterWorkArea;

public class DistributionCenterRole extends Role {

    public DistributionCenterRole() {
        type = RoleType.DistributionCenter_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.DistributionCenter_Role;
        return new DistributionCenterWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
