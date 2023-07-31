package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.adminorganization.SystemAdminWorkArea;

public class AdminRole extends Role {

    public AdminRole() {
        type = RoleType.System_Administration_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.System_Administration_Role;
        return new SystemAdminWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
