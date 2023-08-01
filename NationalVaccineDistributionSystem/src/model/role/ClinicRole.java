package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.clinic.ClinicWorkArea;

public class ClinicRole extends Role {

    public ClinicRole() {
        type = RoleType.Clinic_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Clinic_Role;
        return new ClinicWorkArea(userProcessContainer, account, organization, Ecosystem.getInstance());
    }

}
