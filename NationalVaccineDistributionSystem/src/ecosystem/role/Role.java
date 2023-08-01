package ecosystem.role;

import ecosystem.Ecosystem;
import ecosystem.organization.Organization;
import ecosystem.useraccount.UserAccount;
import javax.swing.JPanel;

public abstract class Role {

    public RoleType type;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem);

    public enum RoleType {

        CDC_Role("CDC_Role"),
        PHD_Role("PHD_Role"),
        Clinic_Role("Clinic_Role"),
        DistributionCenter_Role("DistributionCenter_Role"),
        Distributor_Role("Distributor_Role"),
        Hospital_Role("Hospital_Role"),
        Manufacturer_Role("Manufacturer_Role"),
        Provider_Role("Provider_Role"),
        System_Administration_Role("System_Administration_Role");

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

}
