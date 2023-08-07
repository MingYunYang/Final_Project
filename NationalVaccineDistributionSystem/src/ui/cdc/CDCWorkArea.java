/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import nvds.NationalVaccineDistributionSystem;
import javax.swing.JPanel;
import nvds.organization.Organization;
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

    public CDCWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
    }

    
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuestion = new javax.swing.JLabel();
        btnManageAdverseEventHandling = new javax.swing.JButton();
        btnManageCDCVacccineRequests = new javax.swing.JButton();
        btnManageVaccineAllocation = new javax.swing.JButton();

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

        btnManageVaccineAllocation.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageVaccineAllocation.setText("Manage Vaccine Allocation");
        btnManageVaccineAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineAllocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(lblQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageAdverseEventHandling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageCDCVacccineRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageVaccineAllocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnManageAdverseEventHandling)
                .addGap(18, 18, 18)
                .addComponent(btnManageCDCVacccineRequests)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineAllocation)
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageAdverseEventHandlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdverseEventHandlingActionPerformed
        
        AdverseEventHandling aeh = new AdverseEventHandling(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("AdverseEventHandling" , aeh);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdverseEventHandlingActionPerformed

    private void btnManageVaccineAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineAllocationActionPerformed
        
        ManageVaccineAllocation mva = new ManageVaccineAllocation(userProcessContainer , userAccount , organization , ecosystem);
        userProcessContainer.add("ManageVaccineAllocation" , mva);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineAllocationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdverseEventHandling;
    private javax.swing.JButton btnManageCDCVacccineRequests;
    private javax.swing.JButton btnManageVaccineAllocation;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
