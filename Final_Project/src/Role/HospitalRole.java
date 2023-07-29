/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.HospitalRole.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class HospitalRole extends Role{
    
    public HospitalRole(){
        type = RoleType.Hospital_Role;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Hospital_Role;
        return new HospitalWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
