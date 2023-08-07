package ui.clinic;

import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import nvds.role.Role;

public class ClinicWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public ClinicWorkArea(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;

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

        Role role = userAccount.getRole();
        switch ( role.type ) {
            
            case CLINIC_DOCTOR -> {
                btnManageVaccineInventory.setEnabled(false);
                btnManageVaccineRequest.setEnabled(false);
            }
            case VACCINE_INVENTORY_MANAGER -> {
                btnManageVaccineRequest.setEnabled(false);
                btnReportSafetyIssue.setEnabled(false);
            }
            case VACCINE_REQUEST_REVIEWER -> {
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageVaccineRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageVaccineInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportSafetyIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineInventory)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineRequest)
                .addGap(18, 18, 18)
                .addComponent(btnReportSafetyIssue)
                .addContainerGap(322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineRequestActionPerformed

        ManageVaccineRequest mvr = new ManageVaccineRequest(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageClinicRequestReview" , mvr);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineRequestActionPerformed

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed

        ManageVaccineInventory mcvi = new ManageVaccineInventory(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageClinicVaccineInventory" , mcvi);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed

    private void btnReportSafetyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSafetyIssueActionPerformed

        ReportVaccineSafetyIssue rsi = new ReportVaccineSafetyIssue(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ReportSafetyIssue" , rsi);
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
