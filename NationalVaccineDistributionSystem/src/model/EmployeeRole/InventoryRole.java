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
import ui.clinic.ClinicWorkArea;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class InventoryRole extends EmployeeRole{
    
    public InventoryRole(){
        super(RoleType.VACCINE_INVENTORY_MANAGEMENT_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.VACCINE_INVENTORY_MANAGEMENT_ROLE;
        
        if(organization instanceof NvdsClinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } else if(organization instanceof NvdsHospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } 
        return null;    
    }
    
}
