package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.distributor.DistributorWorkArea;

public class DistributorRole extends Role {

    public DistributorRole() {
        super(RoleType.Distributor_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Distributor_Role;
        return new DistributorWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
