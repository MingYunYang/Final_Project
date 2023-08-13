/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class HospitalLabTechnicianRole extends Role{
    
    public HospitalLabTechnicianRole(){
        super(Role.RoleType.HOSPITAL_LAB_TECHNICIAN);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        type = Role.RoleType.HOSPITAL_LAB_TECHNICIAN;
        
        if(organization instanceof Hospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        }
        return null;    
    }
    
}
