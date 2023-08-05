/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.Role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;
import nvds.ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class ReviewRequestsRole extends EmployeeRole{
    
    public ReviewRequestsRole(){
        super(EmployeeRoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRoleType.REVIEW_VACCINE_ORDER_REQUEST_ROLE;
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } else if(organization instanceof Hospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        } 
        return null;
    }
    
}
