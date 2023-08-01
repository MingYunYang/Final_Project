package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.manufacturer.ManufacturerWorkArea;

public class ManufacturerRole extends Role {

    public ManufacturerRole() {
        type = RoleType.Manufacturer_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Manufacturer_Role;
        return new ManufacturerWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
