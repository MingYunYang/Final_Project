package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.cdc.CDCWorkArea;

public class CDCRole extends Role {

    public CDCRole() {
        super(RoleType.CDC_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.CDC_Role;
        return new CDCWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
