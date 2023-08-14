/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hospital;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.workqueue.ReviewRequest;


/**
 *
 * @author libby
 */
public class ManageVaccineRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;
    
    public ManageVaccineRequest(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        

    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRequestList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequestList = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        lblRequestWaitingToBeReviewed = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequestWaitingToBeReviewed = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnCheckInventory = new javax.swing.JButton();
        btnRejected = new javax.swing.JButton();
        btnApproved = new javax.swing.JButton();

        lblRequestList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestList.setText("Hospital Review Request List:");

        tblRequestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Recipient", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRequestList);

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Request ");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssignToMe.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        lblRequestWaitingToBeReviewed.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestWaitingToBeReviewed.setText("Request Waiting To Be Reviewed:");

        tblRequestWaitingToBeReviewed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Reviewer", "Request Status", "Recipient", "Review Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRequestWaitingToBeReviewed);

        jButton1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButton1.setText("Create Order");

        btnCheckInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckInventory.setText("Check Inventory");
        btnCheckInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInventoryActionPerformed(evt);
            }
        });

        btnRejected.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnRejected.setText("Rejected");
        btnRejected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectedActionPerformed(evt);
            }
        });

        btnApproved.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnApproved.setText("Approved");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRequestWaitingToBeReviewed)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignToMe)
                    .addComponent(lblRequestList)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCheckInventory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApproved, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblRequestList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssignToMe)
                .addGap(18, 18, 18)
                .addComponent(lblRequestWaitingToBeReviewed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnApproved)
                        .addComponent(btnRejected)
                        .addComponent(btnCheckInventory)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

       
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInventoryActionPerformed

        UpdateVaccineInventory uvi = new UpdateVaccineInventory( userProcessContainer, userAccount, organization, nvds );
        userProcessContainer.add( "UpdateVaccineInventory", uvi );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next( userProcessContainer );
    }//GEN-LAST:event_btnCheckInventoryActionPerformed

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if (selectedRow >= 0) {
            ReviewRequest request = (ReviewRequest) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);
            request.setStatus("Completed");
            request.setResult("Rejected");
            JOptionPane.showMessageDialog(this, "Review send successfully");
            populateMainWorkQueue();
            populateWaitingWorkQueue();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
            return;
        }
    }//GEN-LAST:event_btnRejectedActionPerformed

    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this,"Please select a request from the table first");
            return;
        }
        WorkRequest request = (WorkRequest) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);

        // push the request to affiliate hospital's inventory role's work queue
        Hospital affiliateHospital = organization.getCity().getAffiliatedHospital();
        Role inventoryRole = affiliateHospital.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);

        if (inventoryRole != null) {
            inventoryRole.getMainWorkQueue().getListOfWorkRequests().add(request);
            request.setStatus("Process to Hospital");
        } else {
            JOptionPane.showMessageDialog(this, "There's no service in affiliate hospital now");
            return;
        }

        JOptionPane.showMessageDialog(this, "Request sent to affiliate hospital successfully");

        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }//GEN-LAST:event_btnApprovedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckInventory;
    private javax.swing.JButton btnRejected;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblRequestList;
    private javax.swing.JLabel lblRequestWaitingToBeReviewed;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRequestList;
    private javax.swing.JTable tblRequestWaitingToBeReviewed;
    // End of variables declaration//GEN-END:variables
}