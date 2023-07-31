package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.hospital.HospitalWorkArea;

public class HospitalRole extends Role {

    public HospitalRole() {
        type = RoleType.Hospital_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Hospital_Role;
        return new HospitalWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
