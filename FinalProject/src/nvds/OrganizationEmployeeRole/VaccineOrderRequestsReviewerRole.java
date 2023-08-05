package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Clinic;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.clinic.ClinicWorkArea;
import nvds.ui.hospital.HospitalWorkArea;

public class VaccineOrderRequestsReviewerRole extends OrganizationEmployeeUserAccountRole {

    public VaccineOrderRequestsReviewerRole() {
        super(OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER);
    }

    @Override
    public JPanel createWorkArea(JPanel userAccountProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeUserAccountRoleType = OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER;

        if ( nvdsParticipatingOrganization instanceof Clinic ) {
            return new ClinicWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        } else if ( nvdsParticipatingOrganization instanceof Hospital ) {
            return new HospitalWorkArea(userAccountProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        }
        return null;
    }

}
