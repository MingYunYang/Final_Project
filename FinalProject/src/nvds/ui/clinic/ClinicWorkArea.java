package nvds.ui.clinic;

import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;

public class ClinicWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount employeeUserAccount;

    NvdsParticipatingOrganization participatingOrganization;

    public ClinicWorkArea(JPanel userProcessContainer , UserAccount employeeUserAccount , NvdsParticipatingOrganization participatingOrganization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.employeeUserAccount = employeeUserAccount;
        this.participatingOrganization = participatingOrganization;

        toggleButtonsAccessBasedOnRole();
    }

    /**
     * Sets up buttons according to the user's role.
     *
     * The method checks the role of the user and enables or disables certain
     * buttons accordingly. For example, if the user has a Doctor role, some
     * buttons related to inventory and requests management are disabled because
     * those actions are not typically performed by a doctor.
     */
    private void toggleButtonsAccessBasedOnRole() {

        OrganizationEmployeeRole role = employeeUserAccount.getOrganizationEmployeeRole();
        switch ( role.organizationEmployeeUserAccountRoleType ) {
            case CLINIC_LAB_TECHNICIAN -> {
                btnManageVaccineInventory.setEnabled(false);
                btnManageVaccineRequest.setEnabled(false);
            }
            case VACCINE_INVENTORY_MANAGER -> {
                btnManageVaccineRequest.setEnabled(false);
                btnReportSafetyIssue.setEnabled(false);
            }
            case VACCINE_ORDER_REQUEST_REVIEWER -> {
                btnReportSafetyIssue.setEnabled(false);
                btnManageVaccineInventory.setEnabled(false);
            }
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageVaccineRequest = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        btnManageVaccineInventory = new javax.swing.JButton();
        btnReportSafetyIssue = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnManageVaccineRequest.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageVaccineRequest.setText("Manage Vaccine Request");
        btnManageVaccineRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineRequestActionPerformed(evt);
            }
        });

        lblQuestion.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("What would you like to do today?");

        btnManageVaccineInventory.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageVaccineInventory.setText("Manage Vaccine Inventory");
        btnManageVaccineInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineInventoryActionPerformed(evt);
            }
        });

        btnReportSafetyIssue.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnReportSafetyIssue.setText("Report Safety Issue");
        btnReportSafetyIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportSafetyIssueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuestion)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageVaccineRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageVaccineInventory)
                            .addComponent(btnReportSafetyIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(318, 318, 318))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineInventory)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineRequest)
                .addGap(18, 18, 18)
                .addComponent(btnReportSafetyIssue)
                .addContainerGap(463, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineRequestActionPerformed
        // Reviewer role
        ManageVaccineOrderRequest mvr = new ManageVaccineOrderRequest(userProcessContainer , employeeUserAccount , participatingOrganization , nvds);
        userProcessContainer.add("ManageClinicRequestReview" , mvr);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineRequestActionPerformed

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed
        // Inventory manager role
        ManageVaccineInventory mcvi = new ManageVaccineInventory(userProcessContainer , employeeUserAccount , participatingOrganization , nvds);
        userProcessContainer.add("ManageClinicVaccineInventory" , mcvi);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed

    private void btnReportSafetyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSafetyIssueActionPerformed
        // Doctor role
        ReportVaccineSafetyIssue rsi = new ReportVaccineSafetyIssue(userProcessContainer , employeeUserAccount , participatingOrganization , nvds);
        userProcessContainer.add("ReportVaccineSafetyIssue" , rsi);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnReportSafetyIssueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageVaccineInventory;
    private javax.swing.JButton btnManageVaccineRequest;
    private javax.swing.JButton btnReportSafetyIssue;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
