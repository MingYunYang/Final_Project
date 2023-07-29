/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.CDCRole.CDCWorkArea;

/**
 *
 * @author libby
 */
public class CDCRole extends Role{

    public CDCRole(){
        type = RoleType.CDC_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.CDC_Role;
        return new CDCWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}