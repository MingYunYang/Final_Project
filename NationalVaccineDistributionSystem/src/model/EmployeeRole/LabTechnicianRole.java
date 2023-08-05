/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.EmployeeRole;

import javax.swing.JPanel;
import model.NationalVaccineDistributionSystem;
import model.Organization.NvdsClinic;
import model.Organization.NvdsHospital;
import model.Organization.NvdsParticipatingOrganization;
import model.UserAccount.UserAccount;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class LabTechnicianRole extends EmployeeRole{
    
    public LabTechnicianRole(){
        super(EmployeeRole.RoleType.HOSPITAL_LAB_TECHNICIAN_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRole.RoleType.HOSPITAL_LAB_TECHNICIAN_ROLE;
        
        if(organization instanceof NvdsHospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        }
        return null;    
    }
    
}
