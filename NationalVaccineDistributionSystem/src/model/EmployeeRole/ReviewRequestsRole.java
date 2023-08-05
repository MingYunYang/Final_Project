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
public class ReviewRequestsRole extends EmployeeRole{
    
    public ReviewRequestsRole(){
        super(RoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE;
        
        if(organization instanceof NvdsClinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } else if(organization instanceof NvdsHospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } 
        return null;
    }
    
}
