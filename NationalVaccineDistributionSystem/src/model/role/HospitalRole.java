package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.hospital.HospitalWorkArea;

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
