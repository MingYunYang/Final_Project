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
import nvds.vaccine.Vaccine;
import nvds.workqueue.DeliveryRequest;
import nvds.workqueue.ManufactureRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineManufacturing extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManageVaccineManufacturing(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
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
            row[ 2 ] = manufactureRequest.getRequestQuantity();
            row[ 3 ] = manufactureRequest; // will show as the expected received date
            row[ 4 ] = manufactureRequest.getVaccine().getManufactureStatus();
            model.addRow(row);
        }
    }
    
    public void populateDeliveryWaitingListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblDeliveryWaitingList.getModel();
        model.setRowCount(0);

        for ( Batch batch : organization.getInventoryCatalog().getBatchList()) {
            Object[] row = new Object[ 7 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = batch.getVaccine().getName();
            row[ 2 ] = batch; // will show as the batch id
            row[ 3 ] = batch.getQuantity();
            row[ 4 ] = batch.getQuantity() * batch.getPriceForEachVaccine();
            row[ 5 ] = (batch.getVaccine().getManufactureStatus().equals("Manufactured"))? "Waiting" : batch.getVaccine().getManufactureStatus();
            row[ 6 ] = batch.getPaymentStatus();
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
        btnViewBatchDetails = new javax.swing.JButton();

        lblDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDeliveryWaitingList.setText("Delivery Waiting List:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Manufacturing");

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
                "Vaccine ID", "Vaccine", "Qty", "Expect Received Date", "Manufacture Status"
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Batch ID", "Del. Qty", "Total Price", "Del. Status", "Pay. Status"
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
        jScrollPane2.setViewportView(tblDeliveryWaitingList);
        if (tblDeliveryWaitingList.getColumnModel().getColumnCount() > 0) {
            tblDeliveryWaitingList.getColumnModel().getColumn(0).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(1).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(2).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(3).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(4).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDeliveryWaitingList.getColumnModel().getColumn(5).setResizable(false);
            tblDeliveryWaitingList.getColumnModel().getColumn(6).setResizable(false);
        }

        btnDeliverToCDC.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverToCDC.setText("Deliver To CDC");
        btnDeliverToCDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverToCDCActionPerformed(evt);
            }
        });

        btnViewBatchDetails.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnViewBatchDetails.setText("View Batch Details");
        btnViewBatchDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBatchDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReceivedRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnManufactureVaccine))
                    .addComponent(lblDeliveryWaitingList)
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDeliverToCDC, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewBatchDetails))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeliverToCDC)
                    .addComponent(btnViewBatchDetails))
                .addContainerGap(128, Short.MAX_VALUE))
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
            JOptionPane.showMessageDialog(this, "Please select a manufacturer request first");
            return;
        }

        ManufactureRequest manufactureRequest = (ManufactureRequest)tblReceivedManufactureRequests.getValueAt(selectedRowIndex, 3);
        manufactureRequest.getVaccine().setManufactureStatus("Manufacturing");
        
        populateReceivedManufactureRequestsTable();
    }//GEN-LAST:event_btnReceivedRequestActionPerformed

    private void btnManufactureVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManufactureVaccineActionPerformed
       
        int selectedRowIndex = tblReceivedManufactureRequests.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a manufacture request first");
            return;
        }
        
        Vaccine vaccine = (Vaccine)tblReceivedManufactureRequests.getValueAt(selectedRowIndex, 1);
        if(vaccine.getManufactureStatus().equals("Requesting")){
            JOptionPane.showMessageDialog(this, "Selected manufacture request needs to be received first");
            return;
        } else if(vaccine.getManufactureStatus().equals("Manufacturing")){
            ManufactureVaccine mv = new ManufactureVaccine(userProcessContainer , userAccount , organization , nvds, vaccine);
            userProcessContainer.add("ManufactureVaccine" , mv);
            CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(this, "Selected manufacture request has already been processing");
            return;
        }
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

    private void btnViewBatchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBatchDetailsActionPerformed

        int selectedRowIndex = tblDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }

        Batch batch = (Batch)tblDeliveryWaitingList.getValueAt(selectedRowIndex, 2);

        ViewBatchDetails vbd = new ViewBatchDetails(userProcessContainer , userAccount , organization , nvds, batch);
        userProcessContainer.add("AllocateVaccine", vbd);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnViewBatchDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeliverToCDC;
    private javax.swing.JButton btnManufactureVaccine;
    private javax.swing.JButton btnReceivedRequest;
    private javax.swing.JButton btnViewBatchDetails;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDeliveryWaitingList;
    private javax.swing.JLabel lblReceivedManufactureRequests;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDeliveryWaitingList;
    private javax.swing.JTable tblReceivedManufactureRequests;
    // End of variables declaration//GEN-END:variables
}
