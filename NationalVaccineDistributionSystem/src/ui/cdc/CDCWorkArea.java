/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import nvds.NationalVaccineDistributionSystem;
import javax.swing.JPanel;
import nvds.organization.Organization;
import nvds.role.Role;
import static nvds.role.Role.RoleType.VACCINE_INVENTORY_MANAGER;
import static nvds.role.Role.RoleType.VACCINE_REQUEST_REVIEWER;
import nvds.useraccount.UserAccount;

/**
 *
 * @author libby
 */
public class CDCWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem ecosystem;

    UserAccount userAccount;

    Organization organization;

    public CDCWorkArea(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem ecosystem) {
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

            case VACCINE_INVENTORY_MANAGER -> {
                btnManageAdverseEventHandling.setEnabled(false);
                btnManageCDCVacccineRequests.setEnabled(false);
            }
            case CDC_ADVERSE_EVENT_HANDLER -> {
                btnManageCDCVacccineRequests.setEnabled(false);
                btnCreateVaccineJPanel.setEnabled(false);
                btnCreateVaccineJPanel.setEnabled(false);
            }
            case VACCINE_REQUEST_REVIEWER -> {
                btnManageAdverseEventHandling.setEnabled(false);
                btnCreateVaccineJPanel.setEnabled(false);
                btnCreateVaccineJPanel.setEnabled(false);
            }
        }
    }


    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuestion = new javax.swing.JLabel();
        btnManageAdverseEventHandling = new javax.swing.JButton();
        btnManageCDCVacccineRequests = new javax.swing.JButton();
        btnCreateVaccineJPanel = new javax.swing.JButton();
        btnManageVaccineAllocation1 = new javax.swing.JButton();

        lblQuestion.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("What would you like to do today?");

        btnManageAdverseEventHandling.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageAdverseEventHandling.setText("Manage Adverse Events");
        btnManageAdverseEventHandling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdverseEventHandlingActionPerformed(evt);
            }
        });

        btnManageCDCVacccineRequests.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageCDCVacccineRequests.setText("Manage Vaccine Requests");
        btnManageCDCVacccineRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCDCVacccineRequestsActionPerformed(evt);
            }
        });

        btnCreateVaccineJPanel.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnCreateVaccineJPanel.setText("Create Vaccines");
        btnCreateVaccineJPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateVaccineJPanelActionPerformed(evt);
            }
        });

        btnManageVaccineAllocation1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageVaccineAllocation1.setText("Manage Vaccine Allocation");
        btnManageVaccineAllocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineAllocation1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageAdverseEventHandling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageCDCVacccineRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateVaccineJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageVaccineAllocation1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(lblQuestion)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lblQuestion)
                .addGap(24, 24, 24)
                .addComponent(btnCreateVaccineJPanel)
                .addGap(18, 18, 18)
                .addComponent(btnManageAdverseEventHandling)
                .addGap(18, 18, 18)
                .addComponent(btnManageCDCVacccineRequests)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineAllocation1)
                .addContainerGap(204, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageAdverseEventHandlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdverseEventHandlingActionPerformed

        AdverseEventHandling aeh = new AdverseEventHandling(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("AdverseEventHandling" , aeh);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdverseEventHandlingActionPerformed

    private void btnCreateVaccineJPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateVaccineJPanelActionPerformed
        // TODO add your handling code here:
        ManageVaccineInventoryJPanel mva = new ManageVaccineInventoryJPanel(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("CreateVaccineJPanel" , mva);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnCreateVaccineJPanelActionPerformed

    private void btnManageVaccineAllocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineAllocation1ActionPerformed
        ManageVaccineAllocation mva = new ManageVaccineAllocation(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageVaccineAllocation" , mva);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineAllocation1ActionPerformed

    private void btnManageCDCVacccineRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCDCVacccineRequestsActionPerformed
        // TODO add your handling code here:
        ManageVaccineRequests mva = new ManageVaccineRequests(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageVaccineRequests" , mva);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageCDCVacccineRequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateVaccineJPanel;
    private javax.swing.JButton btnManageAdverseEventHandling;
    private javax.swing.JButton btnManageCDCVacccineRequests;
    private javax.swing.JButton btnManageVaccineAllocation1;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
