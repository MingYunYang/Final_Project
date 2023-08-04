package model.role;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import javax.swing.JPanel;
import model.workqueue.WorkQueue;

public abstract class Role {

    public RoleType type;
    private final WorkQueue workQueue;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Ecosystem ecosystem);

    public enum RoleType {

        CDC_Role("CDC Role"),
        PHD_Role("PHD Role"),
        Clinic_Role("Clinic Role"),
        DistributionCenter_Role("DistributionCenter Role"),
        Distributor_Role("Distributor Role"),
        Hospital_Role("Hospital Role"),
        Manufacturer_Role("Manufacturer Role"),
        Provider_Role("Provider Role"),
        System_Administration_Role("System Administration Role"),
        
        Doctor_Role("Doctor Role"),
        Review_Requests_Role("Review Role"),
        Vaccine_Inventory_Management_Role("Inventory Role"),
        Monitor_Role("Monitor Role");

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
    
    public Role(RoleType roleType){
        workQueue = new WorkQueue();
        type = roleType;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    
    @Override
    public String toString(){
        return type.getValue();
    }

}
