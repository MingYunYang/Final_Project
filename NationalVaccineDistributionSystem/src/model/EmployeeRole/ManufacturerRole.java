package model.EmployeeRole;

import model.NationalVaccineDistributionSystem;
import model.Organization.NvdsParticipatingOrganization;
import model.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.manufacturer.ManufacturerWorkArea;

public class ManufacturerRole extends EmployeeRole {

    public ManufacturerRole() {
        super(RoleType.Manufacturer_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.Manufacturer_Role;
        return new ManufacturerWorkArea(userProcessContainer, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
    }

}
