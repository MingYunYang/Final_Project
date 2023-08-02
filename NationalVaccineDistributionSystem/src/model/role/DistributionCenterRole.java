package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.distributioncenter.DistributionCenterWorkArea;

public class DistributionCenterRole extends Role {

    public DistributionCenterRole() {
        super(RoleType.DistributionCenter_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.DistributionCenter_Role;
        return new DistributionCenterWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
