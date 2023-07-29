/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.SystemManagementRole.SystemManagementWorkArea;

/**
 *
 * @author libby
 */
public class SystemManagementRole extends Role{
    
    public SystemManagementRole(){
        type = RoleType.SystemManagement_Role;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.SystemManagement_Role;
        return new SystemManagementWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
