package nvds.role;

import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.admin.AdminWorkArea;

/**
 * @author libby
 * @author mutara
 */
public class NVDSAdminRole extends Role {

    public NVDSAdminRole() {
        super(RoleType.NVDS_ADMIN);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        setType( RoleType.NVDS_ADMIN );
        return new AdminWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getInstance());
    }

}
