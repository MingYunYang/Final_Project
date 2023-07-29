/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Ecosystem.Ecosystem;
import Organization.Organization;
import UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author libby
 */
public abstract class Role {

    public RoleType type;

    public enum RoleType {

        CDC_Role("CDC_Role"),
        PHD_Role("PHD_Role"),
        Clinic_Role("Clinic_Role"),
        DistributionCenter_Role("DistributionCenter_Role"),
        Distributor_Role("Distributor_Role"),
        Hospital_Role("Hospital_Role"),
        Manufacturer_Role("Manufacturer_Role"),
        Provider_Role("Provider_Role"),
        SystemManagement_Role("SystemManagement_Role");

        private final String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem);

}
