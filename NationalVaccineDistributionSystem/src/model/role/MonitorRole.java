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
import ui.clinic.ClinicWorkArea;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class MonitorRole extends EmployeeRole{
    
    public MonitorRole(){
        super(RoleType.Monitor_Role);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.Monitor_Role;
        
        if(organization instanceof NvdsClinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } else if(organization instanceof NvdsHospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } 
        
        return null;
    }
    
    
}
