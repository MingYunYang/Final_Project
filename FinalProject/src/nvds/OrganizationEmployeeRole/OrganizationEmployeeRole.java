package nvds.OrganizationEmployeeRole;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.Workqueue.WorkQueue;

public abstract class OrganizationEmployeeRole {

    public OrganizationEmployeeRoleType organizationEmployeeRoleType;

    private final WorkQueue incomingVaccineOrderRequestsWorkQueue;

    private final WorkQueue vaccineOrderRequestsCurrentlyUnderReviewWorkQueue;

    public abstract JPanel createWorkArea(JPanel accountUserProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization nvdsParticipatingOrganization , NationalVaccineDistributionSystem nvds);

    public enum OrganizationEmployeeRoleType {

        ORGANIZATION_ADMIN("Organization Admin"),
        ORGANIZATION_DOCTOR("Organization Doctor"),
        VACCINE_ORDER_REQUEST_REVIEWER("Vaccine Order Request Reviewer"),
        VACCINE_INVENTORY_MANAGER("Vaccine Inventory manager"),
        HOSPITAL_LAB_TECHNICIAN_ROLE("Hospital lab technician");

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
        this.organizationEmployeeRoleType = roleType;
    }

    public WorkQueue getIncomingVaccineOrderRequestsWorkQueue() {
        return incomingVaccineOrderRequestsWorkQueue;
    }

    public WorkQueue getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue() {
        return vaccineOrderRequestsCurrentlyUnderReviewWorkQueue;
    }


    @Override
    public String toString() {
        return organizationEmployeeRoleType.getValue();
    }

}
