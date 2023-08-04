/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.role;

import javax.swing.JPanel;
import model.Ecosystem;
import model.organization.Clinic;
import model.organization.Hospital;
import model.organization.Organization;
import model.useraccount.UserAccount;
import ui.clinic.ClinicWorkArea;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class ReviewRequestsRole extends Role{
    
    public ReviewRequestsRole(){
        super(RoleType.Review_Requests_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = RoleType.Review_Requests_Role;
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, Ecosystem.getInstance());
        } else if(organization instanceof Hospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, Ecosystem.getInstance());
        } 
        return null;
    }
    
}
