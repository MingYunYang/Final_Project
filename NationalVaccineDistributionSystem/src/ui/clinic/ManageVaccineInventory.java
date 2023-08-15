/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.vaccine.VaccineInventoryCatalog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.organization.Clinic;
import nvds.vaccine.Batch;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.ReviewRequest;
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

    public ManageVaccineInventory ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateReceivedDeliveryNotificationsTable();
        populateWaitingWorkQueueTable();
    }

    public final void populateReceivedDeliveryNotificationsTable () {

        DefaultTableModel model = ( DefaultTableModel ) tblReceivedDeliveryNotifications.getModel();
        model.setRowCount( 0 );

        for ( WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests() ) {

            AllocationRequest allocationRequest = ( AllocationRequest ) request;

            Object[] row = new Object[ 8 ];
            row[ 0 ] = allocationRequest.getDeliveryNumber();
            row[ 1 ] = allocationRequest; // will show as the vaccine's name
            row[ 2 ] = allocationRequest.getBatch().getManufacturer();
            row[ 3 ] = allocationRequest.getDistributedQuantityForClinic();
            row[ 4 ] = allocationRequest.getDistributedQuantityForClinic() * allocationRequest.getBatch().getPriceForEachVaccine(); // allocated quantity for each clinic
            row[ 5 ] = allocationRequest.getStatus();
            row[ 6 ] = allocationRequest.getClinicPaymentStatus();
            row[ 7 ] = allocationRequest.getBatch().getAvailableQuantity();

            model.addRow( row );
        }
    }

    public final void populateWaitingWorkQueueTable () {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventoryManagementWorkQueue.getModel();
        model.setRowCount( 0 );

        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests() ) {

            if ( request instanceof ReviewRequest reviewRequest ) {

                Object[] row = new Object[ 8 ];
                row[ 0 ] = reviewRequest.getVaccine().getVaccineId();
                row[ 1 ] = reviewRequest.getVaccine().getName();
                row[ 2 ] = reviewRequest.getAvailableQuantity();
                row[ 3 ] = reviewRequest.getRequestQuantity();
                row[ 4 ] = reviewRequest.getSender();
                row[ 5 ] = reviewRequest.getClinicReviewer();
                row[ 6 ] = reviewRequest.getStatus();

                String result = (( ReviewRequest ) request).getResult();
                row[ 7 ] = ((result == null) ? "Waiting" : result);

                model.addRow( row );
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineInventoryManagementWorkQueue = new javax.swing.JTable();
        lblInventoryWorkQueue = new javax.swing.JLabel();
        btnReceived = new javax.swing.JButton();
        lblReceivedDeliveryNotifications = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReceivedDeliveryNotifications = new javax.swing.JTable();
        btnCheckOrUpdateClinicInventory = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblVaccineInventoryManagementWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Avail. Qty", "Req. Qty", "Sender", "Recipient", "Req. Status", "Req. Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineInventoryManagementWorkQueue);
        if (tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryWorkQueue.setText("Sending Request List:");

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        lblReceivedDeliveryNotifications.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedDeliveryNotifications.setText("Received Vaccine:");

        tblReceivedDeliveryNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Del. No", "Vaccine", "Manufacturer", "Recv. Qty", "Total Price", "Del. Status", "Clinic Pay. Status", "Avail. Qty"
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
        jScrollPane3.setViewportView(tblReceivedDeliveryNotifications);
        if (tblReceivedDeliveryNotifications.getColumnModel().getColumnCount() > 0) {
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        btnCheckOrUpdateClinicInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckOrUpdateClinicInventory.setText("Check / Update Inventory");
        btnCheckOrUpdateClinicInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOrUpdateClinicInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReceived)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCheckOrUpdateClinicInventory))
                            .addComponent(lblReceivedDeliveryNotifications))
                        .addContainerGap(418, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInventoryWorkQueue)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTitle)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBack))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedDeliveryNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived)
                    .addComponent(btnCheckOrUpdateClinicInventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInventoryWorkQueue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed

        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a batch of vaccine first" );
            return;
        }

        AllocationRequest allocationRequest = ( AllocationRequest ) tblReceivedDeliveryNotifications.getValueAt( selectedRowIndex, 1 );
        Batch batch = allocationRequest.getBatch();
        allocationRequest.setStatus( "Completed" );
        allocationRequest.setClinicPaymentStatus( "Paid" );
        
        // add the vaccine to clinic's inventory catalog
        Clinic clinic = ( Clinic ) organization;
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = clinic.getInventoryCatalog();
        
        int clinicDistributedQuantity = allocationRequest.getDistributedQuantityForClinic();
        // Check if the batch already exists in the clinic's inventory
        boolean isBatchFound = false;
        for ( Batch existingBatch : clinicVaccineInventoryCatalog.getBatchList() ) {
            if ( existingBatch.getBatchId().equals( batch.getBatchId() ) ) {
                // Update the existing batch's quantity
                existingBatch.setAvailableQuantity( existingBatch.getAvailableQuantity() + clinicDistributedQuantity );
                existingBatch.setOriginalQuantity( existingBatch.getOriginalQuantity() + clinicDistributedQuantity );
                isBatchFound = true;
                break;
            }
        }
        
        if ( !isBatchFound ) {
            // If the batch is not found, add it to the inventory
            batch.setOriginalQuantity( clinicDistributedQuantity );
            batch.setAvailableQuantity( clinicDistributedQuantity );
            clinicVaccineInventoryCatalog.getBatchList().add( batch );
        }
        
        clinicVaccineInventoryCatalog.populateVaccineTypeList();
        clinicVaccineInventoryCatalog.populateVaccineInventoryCount();

        populateReceivedDeliveryNotificationsTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnCheckOrUpdateClinicInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOrUpdateClinicInventoryActionPerformed
        
        UpdateVaccineInventory ucvi = new UpdateVaccineInventory( userProcessContainer, userAccount, organization, nvds );
        userProcessContainer.add( "UpdateVaccineInventory", ucvi );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next( userProcessContainer );
    }//GEN-LAST:event_btnCheckOrUpdateClinicInventoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOrUpdateClinicInventory;
    private javax.swing.JButton btnReceived;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblInventoryWorkQueue;
    private javax.swing.JLabel lblReceivedDeliveryNotifications;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReceivedDeliveryNotifications;
    private javax.swing.JTable tblVaccineInventoryManagementWorkQueue;
    // End of variables declaration//GEN-END:variables
}
