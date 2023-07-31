package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.publichealthdepartment.PHDWorkArea;

public class PublicHealthDepartmentRole extends Role {

    public PublicHealthDepartmentRole() {
        type = RoleType.PHD_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.PHD_Role;
        return new PHDWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
