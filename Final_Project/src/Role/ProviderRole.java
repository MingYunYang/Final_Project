/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.ProviderRole.ProviderWorkArea;

/**
 *
 * @author libby
 */
public class ProviderRole extends Role{
    
    public ProviderRole(){
        type = RoleType.Provider_Role;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Provider_Role;
        return new ProviderWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
