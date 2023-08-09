/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.distributor;

import java.awt.CardLayout;
import nvds.NationalVaccineDistributionSystem;
import javax.swing.JPanel;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;

/**
 *
 * @author libby
 */
public class DistributorWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public DistributorWorkArea(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuestion = new javax.swing.JLabel();
        btnManageAdverseEventHandling = new javax.swing.JButton();

        lblQuestion.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("What would you like to do today?");

        btnManageAdverseEventHandling.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnManageAdverseEventHandling.setText("Manage Vaccine Distribution");
        btnManageAdverseEventHandling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdverseEventHandlingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblQuestion)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnManageAdverseEventHandling, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(btnManageAdverseEventHandling)
                .addContainerGap(312, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageAdverseEventHandlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdverseEventHandlingActionPerformed

        ManageVaccineDistribution mvd = new ManageVaccineDistribution(userProcessContainer , userAccount , organization , nvds);
        userProcessContainer.add("ManageVaccineDistribution" , mvd);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdverseEventHandlingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdverseEventHandling;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
