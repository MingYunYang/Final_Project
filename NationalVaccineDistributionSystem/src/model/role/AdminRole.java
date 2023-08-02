package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.admin.AdminWorkArea;

public class AdminRole extends Role {

    public AdminRole() {
        super(RoleType.System_Administration_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.System_Administration_Role;
        return new AdminWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
