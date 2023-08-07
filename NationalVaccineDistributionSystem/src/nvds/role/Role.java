package nvds.role;

import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.workqueue.WorkQueue;

public abstract class Role {

    public RoleType type;
    private final WorkQueue mainWorkQueue;
    private final WorkQueue waitingWorkQueue;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NationalVaccineDistributionSystem ecosystem);

    public enum RoleType {

        NVDS_ADMIN("National Vaccine Distribution System Admin"),
        CLINIC_DOCTOR("Clinic Doctor"),
        HOSPITAL_LAB_TECHNICIAN("Hospital Lab Technician"),
        VACCINE_REQUEST_REVIEWER("Vaccine Request Reviewer"),
        VACCINE_INVENTORY_MANAGER("Vaccine Inventory Manager"),
        CDC_ADVERSE_EVENT_HANDLER("CDC Adverse Event Handler");

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
        mainWorkQueue = new WorkQueue();
        waitingWorkQueue = new WorkQueue();
        type = roleType;
    }

    public WorkQueue getMainWorkQueue() {
        return mainWorkQueue;
    }

    public WorkQueue getWaitingWorkQueue() {
        return waitingWorkQueue;
    }
    
    
    
    @Override
    public String toString(){
        return type.getValue();
    }

}
