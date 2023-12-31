/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Clinic;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.organization.PublicHealthDepartment;
import nvds.useraccount.UserAccount;
import ui.cdc.CDCWorkArea;
import ui.clinic.ClinicWorkArea;
import ui.hospital.HospitalWorkArea;
import ui.phd.PHDWorkArea;

/**
 * @author libby
 * @author mutara
 */
public class VaccineRequestReviewerRole extends Role {

    public VaccineRequestReviewerRole() {
        super(RoleType.VACCINE_REQUEST_REVIEWER);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer , UserAccount account , Organization organization , NationalVaccineDistributionSystem ecosystem) {
        setType( RoleType.VACCINE_REQUEST_REVIEWER );

        if ( organization instanceof Clinic ) {
            return new ClinicWorkArea(userProcessContainer , account , organization , NationalVaccineDistributionSystem.getInstance());
        } else if ( organization instanceof Hospital ) {
            return new HospitalWorkArea(userProcessContainer , account , organization , NationalVaccineDistributionSystem.getInstance());
        } else if ( organization instanceof CDC ) {
            return new CDCWorkArea(userProcessContainer , account , organization , NationalVaccineDistributionSystem.getInstance());
        } else if ( organization instanceof PublicHealthDepartment ) {
            return new PHDWorkArea(userProcessContainer , account , organization , NationalVaccineDistributionSystem.getInstance());
        }
        return null;
    }

}
