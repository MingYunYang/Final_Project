package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.clinic.ClinicWorkArea;

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
