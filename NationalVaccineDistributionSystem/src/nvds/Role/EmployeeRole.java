package nvds.Role;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.Workqueue.WorkQueue;

public abstract class EmployeeRole {

    public EmployeeRoleType type;
    private final WorkQueue mainWorkQueue;
    private final WorkQueue waitingWorkQueue;

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, NvdsParticipatingOrganization organization, NationalVaccineDistributionSystem ecosystem);

    public enum EmployeeRoleType {

        CDC_Role("CDC Role"),
        PHD_Role("PHD Role"),
        Clinic_Role("Clinic Role"),
        DistributionCenter_Role("DistributionCenter Role"),
        Distributor_Role("Distributor Role"),
        Hospital_Role("Hospital Role"),
        Manufacturer_Role("Manufacturer Role"),
        Provider_Role("Provider Role"),
        NVDS_ADMIN_ORG_ADMIN_ROLE("System Administration Role"),
        
        CLINIC_DOCTOR_ROLE("Doctor Role"),
        REVIEW_VACCINE_ORDER_REQUEST_ROLE("Review Role"),
        VACCINE_INVENTORY_MANAGEMENT_ROLE("Inventory Role"),
        Monitor_Role("Monitor Role"),
        HOSPITAL_LAB_TECHNICIAN_ROLE("LabTechnician Role");

        private final String value;

        private EmployeeRoleType(String value) {
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
    
    public EmployeeRole(EmployeeRoleType roleType){
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
