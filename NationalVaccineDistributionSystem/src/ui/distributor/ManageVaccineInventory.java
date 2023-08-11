/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.distributor;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineInventory extends javax.swing.JPanel {

   JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManageVaccineInventory(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateReceivedVaccineCombo();
    }
    
    public void populateReceivedVaccineCombo(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblReceivedVaccine.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            
            AllocationRequest distributionRequest = (AllocationRequest) request;
            
            Object[] row = new Object[ 6 ];
            row[ 0 ] = distributionRequest.getVaccine().getVaccineId();
            row[ 1 ] = distributionRequest.getVaccine();
            row[ 2 ] = distributionRequest.getVaccine().getBatch().getBatchId();
            row[ 3 ] = distributionRequest.getQuantity();
            row[ 4 ] = distributionRequest.getState();
            row[ 5 ] = distributionRequest.getStatus();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblReceivedVaccineRequest = new javax.swing.JLabel();
        lblVaccineCatalog = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineAllocation = new javax.swing.JTable();
        btnCreateNewVaccine4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReceivedVaccine = new javax.swing.JTable();
        btnCreateNewVaccine6 = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblReceivedVaccineRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedVaccineRequest.setText("Received Vaccine:");

        lblVaccineCatalog.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineCatalog.setText("Vaccine Waiting To Be Delivered:");

        tblVaccineAllocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Batch ID", "Quantity", "Destination Hospital", "Distribution Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineAllocation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVaccineAllocation);

        btnCreateNewVaccine4.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreateNewVaccine4.setText("Received");
        btnCreateNewVaccine4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewVaccine4ActionPerformed(evt);
            }
        });

        tblReceivedVaccine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Batch ID", "Quantity", "Destination State", "Distribution Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedVaccine.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblReceivedVaccine);

        btnCreateNewVaccine6.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreateNewVaccine6.setText("Distribute Vaccine");
        btnCreateNewVaccine6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewVaccine6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReceivedVaccineRequest)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblVaccineCatalog)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnCreateNewVaccine4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCreateNewVaccine6))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedVaccineRequest)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateNewVaccine4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateNewVaccine6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVaccineCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateNewVaccine4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewVaccine4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateNewVaccine4ActionPerformed

    private void btnCreateNewVaccine6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewVaccine6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateNewVaccine6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewVaccine4;
    private javax.swing.JButton btnCreateNewVaccine6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReceivedVaccineRequest;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineCatalog;
    private javax.swing.JTable tblReceivedVaccine;
    private javax.swing.JTable tblVaccineAllocation;
    // End of variables declaration//GEN-END:variables
}
