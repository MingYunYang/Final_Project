/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.DistributorRole.DistributorWorkArea;

/**
 *
 * @author libby
 */
public class DistributorRole extends Role{
    
    public DistributorRole(){
        type = RoleType.Distributor_Role;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Distributor_Role;
        return new DistributorWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
