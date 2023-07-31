package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.provider.ProviderWorkArea;

public class ProviderRole extends Role {

    public ProviderRole() {
        type = RoleType.Provider_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Provider_Role;
        return new ProviderWorkArea(userProcessContainer, Ecosystem.getInstance());
    }

}
