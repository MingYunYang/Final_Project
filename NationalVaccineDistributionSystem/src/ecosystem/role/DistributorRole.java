package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.distributor.DistributorWorkArea;

public class DistributorRole extends Role {

    public DistributorRole() {
        type = RoleType.Distributor_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Distributor_Role;
        return new DistributorWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
