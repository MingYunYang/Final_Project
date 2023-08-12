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
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.organization.Clinic;
import nvds.organization.Manufacturer;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.vaccine.Batch;
import nvds.vaccine.VaccineCatalog;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.ReviewRequest;
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
            row[ 0 ] = allocationRequest.getBatch().getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest; // will show as the vaccine's name
            row[ 2 ] = allocationRequest.getBatch().getManufacturer();
            row[ 3 ] = allocationRequest.getBatch().getBatchId();
            row[ 4 ] = allocationRequest.getDistributedQuantityForClinic();
            row[ 5 ] = allocationRequest.getDistributedQuantityForClinic() * allocationRequest.getBatch().getPriceForEachVaccine(); // allocated quantity for each clinic
            row[ 6 ] = allocationRequest.getStatus();
            row[ 7 ] = allocationRequest.getClinicPaymentStatus();

            model.addRow( row );
        }
    }
    
        public final void populateWaitingWorkQueueTable() {

        DefaultTableModel model = (DefaultTableModel) tblVaccineInventoryManagementWorkQueue.getModel();
        model.setRowCount(0);

        for (WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            Object[] row = new Object[7];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request.getVaccine().getName();
            row[2] = request.getQuantity();
            row[3] = request.getSender();
            row[4] = request.getReceiver();
            row[5] = request.getStatus();

            String result = ((ReviewRequest) request).getResult();
            row[6] = ((result == null) ? "Waiting" : result);

            model.addRow(row);
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
        btnReceived2 = new javax.swing.JButton();
        lblReceivedDeliveryNotifications = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReceivedDeliveryNotifications = new javax.swing.JTable();
        btnAddDeliveryToClinicVaccineInventory = new javax.swing.JButton();
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Recipient", "Request Status", "Review Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineInventoryManagementWorkQueue);
        if (tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(0).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(1).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(2).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(3).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(4).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(5).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(6).setResizable(false);
        }

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryWorkQueue.setText("Sending Request List:");

        btnReceived2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnReceived2.setText("Received");
        btnReceived2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceived2ActionPerformed(evt);
            }
        });

        lblReceivedDeliveryNotifications.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedDeliveryNotifications.setText("Received Delivery Notifications:");

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
        jScrollPane3.setViewportView(tblReceivedDeliveryNotifications);

        btnAddDeliveryToClinicVaccineInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAddDeliveryToClinicVaccineInventory.setText("Add to Clinic inventory");
        btnAddDeliveryToClinicVaccineInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeliveryToClinicVaccineInventoryActionPerformed(evt);
            }
        });

        btnCheckOrUpdateClinicInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckOrUpdateClinicInventory.setText("Check/Update Clinic inventory");
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
                                .addComponent(btnReceived2)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddDeliveryToClinicVaccineInventory)
                                .addGap(18, 18, 18)
                                .addComponent(btnCheckOrUpdateClinicInventory))
                            .addComponent(lblReceivedDeliveryNotifications))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInventoryWorkQueue)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(350, 350, 350)
                                .addComponent(lblTitle))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 58, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedDeliveryNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived2)
                    .addComponent(btnAddDeliveryToClinicVaccineInventory)
                    .addComponent(btnCheckOrUpdateClinicInventory))
                .addGap(18, 18, 18)
                .addComponent(lblInventoryWorkQueue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReceived2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceived2ActionPerformed

        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a batch of vaccine first" );
            return;
        }

        AllocationRequest allocationRequest = ( AllocationRequest ) tblReceivedDeliveryNotifications.getValueAt( selectedRowIndex, 1 );
        allocationRequest.setStatus( "Delivered" );
        allocationRequest.setClinicPaymentStatus( "Paid" );

        populateReceivedDeliveryNotificationsTable();
    }//GEN-LAST:event_btnReceived2ActionPerformed

    private void btnAddDeliveryToClinicVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDeliveryToClinicVaccineInventoryActionPerformed
        // TODO add your handling code here:        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a batch of vaccine first" );
            return;
        }

        AllocationRequest allocationRequest = ( AllocationRequest ) tblReceivedDeliveryNotifications.getValueAt( selectedRowIndex, 1 );
        Vaccine vaccine = allocationRequest.getBatch().getVaccine();
        String batchId = allocationRequest.getBatch().getBatchId();
        Manufacturer manufacturer = allocationRequest.getBatch().getManufacturer();
        int clinicDistributedQuantity = allocationRequest.getDistributedQuantityForClinic();
        String mfd = allocationRequest.getBatch().getManufactureDate();
        String erd = allocationRequest.getBatch().getExpirationDate();

        Clinic clinic = ( Clinic ) organization;
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = clinic.getInventoryCatalog();
        clinicVaccineInventoryCatalog.addBatch( vaccine, batchId, clinicDistributedQuantity, manufacturer, mfd, erd );
        clinicVaccineInventoryCatalog.populateVaccineTypeList();
        clinicVaccineInventoryCatalog.populateVaccineInventoryCount();

        UpdateVaccineInventory ucvi = new UpdateVaccineInventory( userProcessContainer, userAccount, organization, nvds );
        userProcessContainer.add( "ManufactureClinicVaccineInventory", ucvi );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next( userProcessContainer );

        ucvi.populateClinicVaccineInventoryTable( clinicVaccineInventoryCatalog );
    }//GEN-LAST:event_btnAddDeliveryToClinicVaccineInventoryActionPerformed

    private void btnCheckOrUpdateClinicInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOrUpdateClinicInventoryActionPerformed
        // TODO add your handling code here:
        UpdateVaccineInventory ucvi = new UpdateVaccineInventory( userProcessContainer, userAccount, organization, nvds );
        userProcessContainer.add( "ManufactureClinicVaccineInventory", ucvi );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next( userProcessContainer );

    }//GEN-LAST:event_btnCheckOrUpdateClinicInventoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDeliveryToClinicVaccineInventory;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOrUpdateClinicInventory;
    private javax.swing.JButton btnReceived2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblInventoryWorkQueue;
    private javax.swing.JLabel lblReceivedDeliveryNotifications;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReceivedDeliveryNotifications;
    private javax.swing.JTable tblVaccineInventoryManagementWorkQueue;
    // End of variables declaration//GEN-END:variables
}
