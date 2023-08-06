/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.OrganizationEmployeeRole;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.CDC;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.ui.cdc.CDCWorkArea;

/**
 *
 * @author tugum
 */
public class CDCAdverseEventHandlerRole extends OrganizationEmployeeRole {

    public CDCAdverseEventHandlerRole() {
        super(OrganizationEmployeeRole.OrganizationEmployeeRoleType.CDC_ADVERSE_EVENT_HANDLER);
    }

    /**
     *
     * @param accountUserProcessContainer
     * @param userAccount
     * @param nvdsParticipatingOrganization
     * @param nvds
     *
     * @return
     */
    @Override
    public JPanel createWorkArea(JPanel accountUserProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds) {
        organizationEmployeeUserAccountRoleType = OrganizationEmployeeRole.OrganizationEmployeeRoleType.CDC_ADVERSE_EVENT_HANDLER;

        if ( nvdsParticipatingOrganization instanceof CDC ) {
            return new CDCWorkArea(accountUserProcessContainer , userAccount , nvdsParticipatingOrganization , NationalVaccineDistributionSystem.getSingleInstance());
        }
        return null;
    }

}
