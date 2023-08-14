/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.distributor;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
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
    
    public ManageVaccineInventory(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
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
            row[ 4 ] = allocationRequest.getRequestQuantity();
            row[ 5 ] = allocationRequest.getBatch().getPriceForEachVaccine() * allocationRequest.getRequestQuantity();
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
            
            Object[] row = new Object[ 9 ];
            row[ 0 ] = allocationRequest.getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest; // will show as the vaccine's name
            row[ 2 ] = allocationRequest.getState();
            row[ 3 ] = allocationRequest.getCity();
            row[ 4 ] = allocationRequest.getReceivedHospital();
            row[ 5 ] = allocationRequest.getRequestQuantity(); // allocated quantity for each city
            row[ 6 ] = allocationRequest.getRequestQuantity() * allocationRequest.getBatch().getPriceForEachVaccine();
            row[ 7 ] = allocationRequest.getStatus();
            row[ 8 ] = allocationRequest.getPaymentStatus();
            
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblReceivedDeliveryNotifications = new javax.swing.JLabel();
        lblDeliveryWaitingList = new javax.swing.JLabel();
        btnReceived = new javax.swing.JButton();
        btnConfirmDistribution = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDeliveryWaitingList = new javax.swing.JTable();
        btnDeliverToHospital = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedDeliveryNotifications = new javax.swing.JTable();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblReceivedDeliveryNotifications.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedDeliveryNotifications.setText("Received Delivery Notifications:");

        lblDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDeliveryWaitingList.setText("Delivery Waiting List:");

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        btnConfirmDistribution.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnConfirmDistribution.setText("Confirm Distribution");
        btnConfirmDistribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmDistributionActionPerformed(evt);
            }
        });

        tblDeliveryWaitingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "State", "City", "Received Hospital", "Quantity", "Total Price", "Delivery Status", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblDeliveryWaitingList);
        if (tblDeliveryWaitingList.getColumnModel().getColumnCount() > 0) {
            tblDeliveryWaitingList.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btnDeliverToHospital.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverToHospital.setText("Deliver To Hospital");
        btnDeliverToHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverToHospitalActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeliverToHospital)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReceivedDeliveryNotifications)
                            .addComponent(lblDeliveryWaitingList)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReceived)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConfirmDistribution))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(380, 380, 380)
                                .addComponent(btnBack)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedDeliveryNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDeliveryWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverToHospital)
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        allocationRequest.setStatus("Processing By Distributor");
        
        populateReceivedDeliveryNotificationsTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnConfirmDistributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmDistributionActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        
        AllocationRequest allocationRequest = (AllocationRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        
        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Confirmed By Distributor");
        
        populateReceivedDeliveryNotificationsTable();
        populateDeliveryWaitingListTable();
    }//GEN-LAST:event_btnConfirmDistributionActionPerformed

    private void btnDeliverToHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverToHospitalActionPerformed

        int selectedRowIndex = tblDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a delivery task from the table");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblDeliveryWaitingList.getValueAt(selectedRowIndex, 1);

        // add the request to Hospital Inventory Role's main work queue
        Hospital hospital = allocationRequest.getReceivedHospital();
        Role role = hospital.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
        WorkQueue mainWorkQueue = role.getMainWorkQueue();
        mainWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Delivered To Hospital");
        
        populateReceivedDeliveryNotificationsTable();
        populateDeliveryWaitingListTable();
    }//GEN-LAST:event_btnDeliverToHospitalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmDistribution;
    private javax.swing.JButton btnDeliverToHospital;
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
