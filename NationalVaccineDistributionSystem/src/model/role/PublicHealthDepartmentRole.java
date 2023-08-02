package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.phd.PHDWorkArea;

public class PublicHealthDepartmentRole extends Role {

    public PublicHealthDepartmentRole() {
        super(RoleType.PHD_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.PHD_Role;
        return new PHDWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
