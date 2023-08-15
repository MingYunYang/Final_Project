/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Clinic;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import ui.clinic.ClinicWorkArea;

/**
 * @author libby
 * @author mutara
 */
public class ClinicDoctorRole extends Role {
    
    public ClinicDoctorRole() {
        super(RoleType.CLINIC_DOCTOR);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        setType( RoleType.CLINIC_DOCTOR );
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        }
        return null;
    }
}
