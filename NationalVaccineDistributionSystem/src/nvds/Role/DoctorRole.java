package nvds.Role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;

/**
 *
 * @author libby
 */
public class DoctorRole extends EmployeeRole {
    
    public DoctorRole() {
        super(EmployeeRoleType.CLINIC_DOCTOR_ROLE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem) {
        type = EmployeeRoleType.CLINIC_DOCTOR_ROLE;
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getNationalVaccineDistributionSystemSingleInstance());
        }
        return null;
    }
}
