/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import ui.cdc.CDCWorkArea;

/**
 *
 * @author libby
 */
public class CDCCatalogAndAllocationHandlerRole extends Role {
    
    public CDCCatalogAndAllocationHandlerRole() {
        super(RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER;
        
        if(organization instanceof CDC){
            return new CDCWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        }
        return null;
    }
    
    
    
}
