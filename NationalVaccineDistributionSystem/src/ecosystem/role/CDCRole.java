package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userInterface.cdc.CDCWorkArea;

public class CDCRole extends Role {

    public CDCRole() {
        type = RoleType.CDC_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.CDC_Role;
        return new CDCWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
