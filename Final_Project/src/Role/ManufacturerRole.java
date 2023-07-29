/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.ManufacturerRole.ManufacturerWorkArea;

/**
 *
 * @author libby
 */
public class ManufacturerRole extends Role{
    
    public ManufacturerRole(){
        type = RoleType.Manufacturer_Role;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Manufacturer_Role;
        return new ManufacturerWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
