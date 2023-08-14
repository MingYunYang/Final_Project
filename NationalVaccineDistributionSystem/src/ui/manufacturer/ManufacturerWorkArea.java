/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import nvds.NationalVaccineDistributionSystem;
import javax.swing.JPanel;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;

/**
 *
 * @author libby
 */
public class ManufacturerWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManufacturerWorkArea(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
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
        btnManageVaccineInventory = new javax.swing.JButton();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(lblQuestion)
                .addGap(220, 220, 220))
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(btnManageVaccineInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(lblQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageVaccineInventory)
                .addGap(300, 300, 300))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed

        ManageVaccineInventory mvi = new ManageVaccineInventory(userProcessContainer , userAccount , organization , nvds);
        userProcessContainer.add("ManageVaccineInventory" , mvi);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageVaccineInventory;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
