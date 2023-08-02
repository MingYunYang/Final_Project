/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.role;

import javax.swing.JPanel;
import model.Ecosystem;
import model.organization.Clinic;
import model.organization.Organization;
import model.useraccount.UserAccount;
import ui.clinic.ClinicWorkArea;

/**
 *
 * @author libby
 */
public class ReviewRole extends Role{
    
    public ReviewRole(){
        super(RoleType.Review_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Review_Role;
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, Ecosystem.getInstance());
        } //如果organization是hospital，就會new出hospital的頁面，以此類推，待完成...
        return null;
    }
    
}
