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

/**
 *
 * @author libby
 */
public class ClinicRole extends Role{
    
    public ClinicRole(){
        type = RoleType.Clinic_Role;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Clinic_Role;
        return new ClinicWorkArea(userProcessContainer, Ecosystem.getInstance());
    }
    
}
