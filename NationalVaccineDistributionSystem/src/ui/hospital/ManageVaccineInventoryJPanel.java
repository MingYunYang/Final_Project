/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hospital;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.workqueue.ReviewVaccineOrderRequest;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineInventoryJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public ManageVaccineInventoryJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;

        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }
    
    public void populateMainWorkQueue(){
        
        DefaultTableModel model = (DefaultTableModel) tblReceivedVaccineRequest.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            Object[] row = new Object[7];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request;
            row[2] = request.getRequestQuantity();
            row[3] = request.getClinicReviewer(); //sender
            row[4] = request.getHospitalReviewer(); //hospital reviewer
            row[5] = request.getStatus();
            
            String result = ((ReviewVaccineOrderRequest) request).getResult();
            row[6] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);
        }
    }
    
    public void populateWaitingWorkQueue(){
        
        DefaultTableModel model = (DefaultTableModel) tblRequestWaitingToBeReviewed.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()){
  
            Object[] row = new Object[8];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request;
            row[2] = request.getRequestQuantity();
            row[3] = request.getClinicReviewer(); 
            row[4] = request.getHospitalReviewer();
            row[5] = request.getStatus();
            row[6] = request.getReceiver();
            
            String result = ((ReviewVaccineOrderRequest) request).getResult();
            row[7] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);  
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedVaccineRequest = new javax.swing.JTable();
        lblSendingRequestList = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequestWaitingToBeReviewed = new javax.swing.JTable();
        lblRequestWaitingToBeReviewed = new javax.swing.JLabel();
        btnRejected = new javax.swing.JButton();
        btnApproved = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory ");

        btnBack1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnAssignToMe.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        tblReceivedVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Request Quantity", "Sender", "Recipient", "Request Status", "Review Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReceivedVaccineRequest);

        lblSendingRequestList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSendingRequestList.setText("Received Vaccine Request:");

        tblRequestWaitingToBeReviewed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Request Quantity", "Sender", "Reviewer", "Request Status", "Recipient", "Review Result"
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

        lblRequestWaitingToBeReviewed.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestWaitingToBeReviewed.setText("Request Waiting To Be Reviewed:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnApproved, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRequestWaitingToBeReviewed)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignToMe)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack1))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSendingRequestList))
                .addGap(0, 166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack1))
                .addGap(18, 18, 18)
                .addComponent(lblSendingRequestList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssignToMe)
                .addGap(18, 18, 18)
                .addComponent(lblRequestWaitingToBeReviewed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproved)
                    .addComponent(btnRejected))
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        
        int selectedRow = tblReceivedVaccineRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblReceivedVaccineRequest.getValueAt(selectedRow, 1);
            if (request.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(this, "Request already completed");
                return;
            } else {
                userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add(request);
                request.setHospitalReviewer(userAccount);
                request.setStatus("Check Hospital Inventory");
                JOptionPane.showMessageDialog(this, "Request successfully assigned to you");
                populateMainWorkQueue();
                populateWaitingWorkQueue();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
            return;
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if (selectedRow >= 0) {
            ReviewVaccineOrderRequest request = (ReviewVaccineOrderRequest) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);
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
        Role reviewRole = organization.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);

        if (reviewRole != null) {
            reviewRole.getMainWorkQueue().getListOfWorkRequests().add(request);
            request.setStatus("Process to hospital review");
        } else {
            JOptionPane.showMessageDialog(this, "There's no review service now");
            return;
        }

        JOptionPane.showMessageDialog(this, "Request sent successfully");

        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }//GEN-LAST:event_btnApprovedActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnRejected;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblRequestWaitingToBeReviewed;
    private javax.swing.JLabel lblSendingRequestList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReceivedVaccineRequest;
    private javax.swing.JTable tblRequestWaitingToBeReviewed;
    // End of variables declaration//GEN-END:variables
}
