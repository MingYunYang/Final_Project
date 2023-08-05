/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.role;

import javax.swing.JPanel;
import model.NationalVaccineDistributionSystem;
import model.organization.NvdsClinic;
import model.organization.NvdsHospital;
import model.organization.NvdsParticipatingOrganization;
import model.useraccount.UserAccount;
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
