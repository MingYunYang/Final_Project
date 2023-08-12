/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.organization.CDC;
import nvds.organization.Organization.Type;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.workqueue.DeliveryRequest;
import nvds.workqueue.ManufactureRequest;
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
        
        populateReceivedManufactureRequestsTable();
        populateDeliveryWaitingListTable();
    }
    
    
    public void populateReceivedManufactureRequestsTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblReceivedManufactureRequests.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            
            ManufactureRequest manufactureRequest = (ManufactureRequest) request;
            Object[] row = new Object[ 5 ];
            row[ 0 ] = manufactureRequest.getVaccine().getVaccineId();
            row[ 1 ] = manufactureRequest.getVaccine();
            row[ 2 ] = manufactureRequest.getQuantity();
            row[ 3 ] = manufactureRequest; // will show as the expected received date
            row[ 4 ] = manufactureRequest.getVaccine().getManufactureStatus();
            model.addRow(row);
        }
    }
    
    public void populateDeliveryWaitingListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblDeliveryWaitingList.getModel();
        model.setRowCount(0);

        for ( Batch batch : organization.getInventoryCatalog().getBatchList()) {
            Object[] row = new Object[ 9 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = batch.getVaccine().getName();
            row[ 2 ] = batch; // will show as the batch id
            row[ 3 ] = batch.getQuantity();
            row[ 4 ] = batch.getQuantity() * batch.getPriceForEachVaccine();
            row[ 5 ] = batch.getManufactureDate();
            row[ 6 ] = batch.getExpirationDate();
            row[ 7 ] = (batch.getVaccine().getManufactureStatus().equals("Manufactured"))? "Waiting" : batch.getVaccine().getManufactureStatus();
            row[ 8 ] = batch.getPaymentStatus();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDeliveryWaitingList = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblReceivedManufactureRequests = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReceivedManufactureRequests = new javax.swing.JTable();
        btnReceivedRequest = new javax.swing.JButton();
        btnManufactureVaccine = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDeliveryWaitingList = new javax.swing.JTable();
        btnDeliverToCDC = new javax.swing.JButton();

        lblDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDeliveryWaitingList.setText("Delivery Waiting List:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblReceivedManufactureRequests.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedManufactureRequests.setText("Received Manufacture Requests:");

        tblReceivedManufactureRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Quantity", "Expect Received Date", "Manufacture Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedManufactureRequests.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblReceivedManufactureRequests);
        if (tblReceivedManufactureRequests.getColumnModel().getColumnCount() > 0) {
            tblReceivedManufactureRequests.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblReceivedManufactureRequests.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblReceivedManufactureRequests.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        btnReceivedRequest.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnReceivedRequest.setText("Received Request");
        btnReceivedRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedRequestActionPerformed(evt);
            }
        });

        btnManufactureVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnManufactureVaccine.setText("Manufacture Vaccine");
        btnManufactureVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManufactureVaccineActionPerformed(evt);
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
                "Vaccine ID", "Vaccine", "Batch ID", "Quantity", "Total Price", "MFD", "EXD", "Delivery Status", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblDeliveryWaitingList);
        if (tblDeliveryWaitingList.getColumnModel().getColumnCount() > 0) {
            tblDeliveryWaitingList.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnDeliverToCDC.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverToCDC.setText("Deliver To CDC");
        btnDeliverToCDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverToCDCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReceivedRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnManufactureVaccine))
                    .addComponent(lblDeliveryWaitingList)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblReceivedManufactureRequests)
                            .addGap(459, 459, 459))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDeliverToCDC, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedManufactureRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceivedRequest)
                    .addComponent(btnManufactureVaccine))
                .addGap(18, 18, 18)
                .addComponent(lblDeliveryWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverToCDC)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReceivedRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedRequestActionPerformed

        int selectedRowIndex = tblReceivedManufactureRequests.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a request first");
            return;
        }

        ManufactureRequest manufactureRequest = (ManufactureRequest)tblReceivedManufactureRequests.getValueAt(selectedRowIndex, 3);
        manufactureRequest.getVaccine().setManufactureStatus("Manufacturing");
        
        populateReceivedManufactureRequestsTable();
    }//GEN-LAST:event_btnReceivedRequestActionPerformed

    private void btnManufactureVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManufactureVaccineActionPerformed
        
        ManufactureVaccine mv = new ManufactureVaccine(userProcessContainer , userAccount , organization , nvds);
        userProcessContainer.add("ManufactureVaccine" , mv);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManufactureVaccineActionPerformed

    private void btnDeliverToCDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverToCDCActionPerformed
        
        int selectedRowIndex = tblDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine to deliver");
            return;
        }
        
        // create delivery request for the selected batch of vaccine
        Batch selectedBatch = (Batch)tblDeliveryWaitingList.getValueAt(selectedRowIndex, 2);
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setBatch(selectedBatch);
        
        // deliver vaccine batch to CDC Catalog And Allocation Role's main work queue
        CDC CDC = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.CDC) && organization.getCountry().equals(this.organization.getCountry())){
                CDC = (CDC)organization; 
            }
        }
        if(CDC != null){
            Role role = CDC.getSpecificRole(Role.RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER);
            WorkQueue mainWorkQueue = role.getMainWorkQueue();
            mainWorkQueue.getListOfWorkRequests().add(deliveryRequest);
            selectedBatch.getVaccine().setManufactureStatus("Delivering");
        } else {
            JOptionPane.showMessageDialog(this, "No CDC founded");
            return;
        }

        JOptionPane.showMessageDialog(this, "Vaccine delivered successfully");
        populateReceivedManufactureRequestsTable();
        populateDeliveryWaitingListTable();
    }//GEN-LAST:event_btnDeliverToCDCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeliverToCDC;
    private javax.swing.JButton btnManufactureVaccine;
    private javax.swing.JButton btnReceivedRequest;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDeliveryWaitingList;
    private javax.swing.JLabel lblReceivedManufactureRequests;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDeliveryWaitingList;
    private javax.swing.JTable tblReceivedManufactureRequests;
    // End of variables declaration//GEN-END:variables
}
