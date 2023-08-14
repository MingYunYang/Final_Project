/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.useraccount.UserAccount;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import ui.cdc.CDCWorkArea;

/**
 *
 * @author libby
 */
public class CDCAdverseEventHandlerRole extends Role {
    
    public CDCAdverseEventHandlerRole() {
        super(RoleType.CDC_ADVERSE_EVENT_HANDLER);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.CDC_ADVERSE_EVENT_HANDLER;
        
        if(organization instanceof CDC){
            return new CDCWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        }
        return null;
    }
    
}
