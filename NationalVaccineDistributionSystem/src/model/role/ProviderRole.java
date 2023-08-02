package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.provider.ProviderWorkArea;

public class ProviderRole extends Role {

    public ProviderRole() {
        super(RoleType.Provider_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Provider_Role;
        return new ProviderWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
