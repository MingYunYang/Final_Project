package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.manufacturer.ManufacturerWorkArea;

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
