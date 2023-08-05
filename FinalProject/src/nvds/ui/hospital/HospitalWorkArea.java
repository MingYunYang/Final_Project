/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package nvds.ui.hospital;

import java.awt.CardLayout;
import nvds.NationalVaccineDistributionSystem;
import javax.swing.JPanel;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.Useraccount.UserAccount;

/**
 *
 * @author libby
 */
public class HospitalWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem ecosystem;

    UserAccount userAccount;

    NvdsParticipatingOrganization organization;
    
    public HospitalWorkArea(JPanel userProcessContainer , UserAccount userAccount , NvdsParticipatingOrganization organization , NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;

        toggleButtonsAccessBasedOnRole();
    }

    
    private void toggleButtonsAccessBasedOnRole() {

        OrganizationEmployeeRole role = userAccount.getOrganizationEmployeeRole();
        switch ( role.organizationEmployeeRoleType ) {
            case HOSPITAL_LAB_TECHNICIAN_ROLE -> {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageVaccineRequest = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        btnManageVaccineInventory = new javax.swing.JButton();
        btnReportSafetyIssue = new javax.swing.JButton();

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
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineInventory)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineRequest)
                .addGap(18, 18, 18)
                .addComponent(btnReportSafetyIssue)
                .addContainerGap(316, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineRequestActionPerformed

        ManageVaccineRequest mvr = new ManageVaccineRequest(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageClinicRequestReview" , mvr);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineRequestActionPerformed

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed

        ManageVaccineInventoryJPanel mcvi = new ManageVaccineInventoryJPanel(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageClinicVaccineInventory" , mcvi);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed

    private void btnReportSafetyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSafetyIssueActionPerformed

        ReportSafetyIssue rsi = new ReportSafetyIssue(userProcessContainer , userAccount , organization , ecosystem);
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