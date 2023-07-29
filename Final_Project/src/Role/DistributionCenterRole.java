/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.ClinicRole.ClinicWorkArea;
import ui.DistributionCenterRole.DistributionCenterWorkArea;

/**
 *
 * @author libby
 */
public class DistributionCenterRole extends Role{
    
    public DistributionCenterRole(){
        type = RoleType.DistributionCenter_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.DistributionCenter_Role;
        return new DistributionCenterWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
