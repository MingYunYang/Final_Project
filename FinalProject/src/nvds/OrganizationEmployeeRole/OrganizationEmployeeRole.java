package nvds.OrganizationEmployeeRole;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.WorkQueue.WorkQueue;

public abstract class OrganizationEmployeeRole {

    public OrganizationEmployeeRoleType organizationEmployeeUserAccountRoleType;

    private final WorkQueue incomingVaccineOrderRequestsWorkQueue;

    private final WorkQueue vaccineOrderRequestsCurrentlyUnderReviewWorkQueue;

    public abstract JPanel createWorkArea(JPanel accountUserProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds);

    public enum OrganizationEmployeeRoleType {

        ORGANIZATION_ADMIN("Organization Admin"),
        CLINIC_LAB_TECHNICIAN("Clinic Lab Technician"),
        VACCINE_ORDER_REQUEST_REVIEWER("Vaccine Order Request Reviewer"),
        VACCINE_INVENTORY_MANAGER("Vaccine Inventory manager"),
        HOSPITAL_LAB_TECHNICIAN("Hospital lab technician"),
        CDC_ADVERSE_EVENT_HANDLER("CDC adverse event handler");
        

        private final String value;

        private OrganizationEmployeeRoleType(String value) {
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

    public OrganizationEmployeeRole(OrganizationEmployeeRoleType roleType) {
        incomingVaccineOrderRequestsWorkQueue = new WorkQueue();
        vaccineOrderRequestsCurrentlyUnderReviewWorkQueue = new WorkQueue();
        this.organizationEmployeeUserAccountRoleType = roleType;
    }

    public WorkQueue getIncomingVaccineOrderRequestsWorkQueue() {
        return incomingVaccineOrderRequestsWorkQueue;
    }

    public WorkQueue getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue() {
        return vaccineOrderRequestsCurrentlyUnderReviewWorkQueue;
    }


    @Override
    public String toString() {
        return organizationEmployeeUserAccountRoleType.getValue();
    }

}
