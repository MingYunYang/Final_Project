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
import nvds.organization.Clinic;
import nvds.role.Role;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;
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

    public ManageVaccineInventory(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateReceivedDeliveryNotificationsTable();
        populateDeliveryWaitingListTable();
    }
    
 
    public void populateReceivedDeliveryNotificationsTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblReceivedDeliveryNotifications.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            
            AllocationRequest allocationRequest = (AllocationRequest)request;
            
            Object[] row = new Object[ 8 ];
            row[ 0 ] = allocationRequest.getBatch().getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest; // will show as the vaccine's name
            row[ 2 ] = allocationRequest.getBatch().getManufacturer();
            row[ 3 ] = allocationRequest.getBatch().getBatchId();
            row[ 4 ] = allocationRequest.getQuantity();
            row[ 5 ] = allocationRequest.getQuantity() * allocationRequest.getBatch().getPriceForEachVaccine(); // allocated quantity for each city
            row[ 6 ] = allocationRequest.getStatus();
            row[ 7 ] = allocationRequest.getPaymentStatus();
            
            model.addRow(row);
        }
    }
    
    public void populateDeliveryWaitingListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblDeliveryWaitingList.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()){
        
            AllocationRequest allocationRequest = (AllocationRequest)request;
            
            Object[] row = new Object[ 7 ];
            row[ 0 ] = allocationRequest.getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest; // will show as the vaccine's name
            row[ 2 ] = allocationRequest.getReceivedClinic();
            row[ 3 ] = allocationRequest.getDistributedQuantityForClinic();
            row[ 4 ] = allocationRequest.getDistributedQuantityForClinic() * allocationRequest.getBatch().getPriceForEachVaccine();
            row[ 5 ] = (allocationRequest.getStatus().equals("Distributed By Hospital"))? "Waiting" : allocationRequest.getStatus();
            row[ 6 ] = allocationRequest.getClinicPaymentStatus();
            
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        btnReceived = new javax.swing.JButton();
        lblReceivedDeliveryNotifications = new javax.swing.JLabel();
        lblDeliveryWaitingList = new javax.swing.JLabel();
        btnDeliverToClinic = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedDeliveryNotifications = new javax.swing.JTable();
        btnDistributeVaccine = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDeliveryWaitingList = new javax.swing.JTable();

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

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        lblReceivedDeliveryNotifications.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedDeliveryNotifications.setText("Received Delivery Notifications:");

        lblDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDeliveryWaitingList.setText("Delivery Waiting List:");

        btnDeliverToClinic.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnDeliverToClinic.setText("Deliver To Clinic");
        btnDeliverToClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverToClinicActionPerformed(evt);
            }
        });

        tblReceivedDeliveryNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Manufacturer", "Batch ID", "Quantity", "Total Price", "Delivery Status", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedDeliveryNotifications.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblReceivedDeliveryNotifications);

        btnDistributeVaccine.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnDistributeVaccine.setText("Distribute Vaccine");
        btnDistributeVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeVaccineActionPerformed(evt);
            }
        });

        tblDeliveryWaitingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Received Clinic", "Quantity", "Total Price", "Delivery Status", "Clinic Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblDeliveryWaitingList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(lblDeliveryWaitingList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReceived)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDistributeVaccine))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(344, 344, 344)
                        .addComponent(btnBack1))
                    .addComponent(lblReceivedDeliveryNotifications)
                    .addComponent(jScrollPane2)
                    .addComponent(btnDeliverToClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblReceivedDeliveryNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived)
                    .addComponent(btnDistributeVaccine))
                .addGap(18, 18, 18)
                .addComponent(lblDeliveryWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverToClinic)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        allocationRequest.setStatus("Processing By Hospital");
        allocationRequest.setPaymentStatus("Paid");
        
        populateReceivedDeliveryNotificationsTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnDeliverToClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverToClinicActionPerformed

        int selectedRowIndex = tblDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a delivery task from the table");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblDeliveryWaitingList.getValueAt(selectedRowIndex, 1);

        // add the request to Clinic Inventory Role's main work queue
        Clinic clinic = allocationRequest.getReceivedClinic();
        Role role = clinic.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
        WorkQueue mainWorkQueue = role.getMainWorkQueue();
        mainWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Delivered To Clinic");
        
        populateReceivedDeliveryNotificationsTable();
        populateDeliveryWaitingListTable();
    }//GEN-LAST:event_btnDeliverToClinicActionPerformed

    private void btnDistributeVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeVaccineActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        
        AllocationRequest selectedAllocationRequest = (AllocationRequest) tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        
        DistributeVaccine dv = new DistributeVaccine(userProcessContainer , userAccount , organization , nvds, selectedAllocationRequest);
        userProcessContainer.add("DistributeVaccine", dv);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDistributeVaccineActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnDeliverToClinic;
    private javax.swing.JButton btnDistributeVaccine;
    private javax.swing.JButton btnReceived;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDeliveryWaitingList;
    private javax.swing.JLabel lblReceivedDeliveryNotifications;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDeliveryWaitingList;
    private javax.swing.JTable tblReceivedDeliveryNotifications;
    // End of variables declaration//GEN-END:variables
}
