/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.PHDRole.PHDWorkArea;

/**
 *
 * @author libby
 */
public class PHDRole extends Role{
    
    public PHDRole(){
        type = RoleType.PHD_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.PHD_Role;
        return new PHDWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
