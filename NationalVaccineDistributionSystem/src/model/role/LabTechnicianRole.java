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
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class LabTechnicianRole extends Role{
    
    public LabTechnicianRole(){
        super(Role.RoleType.LabTechnician_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem) {
        type = Role.RoleType.LabTechnician_Role;
        
        if(organization instanceof Hospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, Ecosystem.getInstance());
        }
        return null;    
    }
    
}
