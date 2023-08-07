/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.role;

import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Clinic;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import ui.clinic.ClinicWorkArea;
import ui.hospital.HospitalWorkArea;

/**
 *
 * @author libby
 */
public class VaccineInventoryManagerRole extends Role{
    
    public VaccineInventoryManagerRole(){
        super(RoleType.VACCINE_INVENTORY_MANAGER);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        type = RoleType.VACCINE_INVENTORY_MANAGER;
        
        if(organization instanceof Clinic){
            return new ClinicWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        } else if(organization instanceof Hospital){
            return new HospitalWorkArea(userProcessContainer, account, organization, NationalVaccineDistributionSystem.getInstance());
        } 
        return null;    
    }
    
}
