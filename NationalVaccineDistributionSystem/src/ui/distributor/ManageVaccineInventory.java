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
        
        populateReceivedAllocationRequestTable();
        populateVaccineWaitingToBeDeliveredTable();
    }
    
    public void populateReceivedAllocationRequestTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblReceivedAllocationRequest.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            
            AllocationRequest allocationRequest = (AllocationRequest)request;
            
            Object[] row = new Object[ 7 ];
            row[ 0 ] = allocationRequest.getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest.getVaccine();
            row[ 2 ] = allocationRequest; // will show as the state name
            row[ 3 ] = allocationRequest.getCity();
            row[ 4 ] = allocationRequest.getReceivedHospital();
            row[ 5 ] = allocationRequest.getQuantity();
            row[ 6 ] = allocationRequest.getStatus();
            
            model.addRow(row);
        }
    }
    
    public void populateVaccineWaitingToBeDeliveredTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineWaitingToBeDelivered.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()){
        
            AllocationRequest allocationRequest = (AllocationRequest)request;
            
            Object[] row = new Object[ 7 ];
            row[ 0 ] = allocationRequest.getVaccine().getVaccineId();
            row[ 1 ] = allocationRequest.getVaccine();
            row[ 2 ] = allocationRequest; // will show as the state name
            row[ 3 ] = allocationRequest.getCity();
            row[ 4 ] = allocationRequest.getReceivedHospital();
            row[ 5 ] = allocationRequest.getQuantity();
            row[ 6 ] = allocationRequest.getStatus();
            
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblReceivedVaccine = new javax.swing.JLabel();
        lblVaccineWaitingToBeDelivered = new javax.swing.JLabel();
        btnReceived = new javax.swing.JButton();
        btnDistributeVaccine = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedAllocationRequest = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVaccineWaitingToBeDelivered = new javax.swing.JTable();
        btnDeliverVaccineToDistributor = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblReceivedVaccine.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedVaccine.setText("Received Allocation Request:");

        lblVaccineWaitingToBeDelivered.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineWaitingToBeDelivered.setText("Vaccine Waiting To Be Delivered:");

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        btnDistributeVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDistributeVaccine.setText("Distribute Vaccine");
        btnDistributeVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeVaccineActionPerformed(evt);
            }
        });

        tblReceivedAllocationRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "State", "City", "Received Hospital", "Quantity", "Allocation Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedAllocationRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblReceivedAllocationRequest);

        tblVaccineWaitingToBeDelivered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "State", "City", "Received Hospital", "Quantity", "Allocation Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineWaitingToBeDelivered.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblVaccineWaitingToBeDelivered);

        btnDeliverVaccineToDistributor.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverVaccineToDistributor.setText("Deliver Vaccine To Hospital");
        btnDeliverVaccineToDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverVaccineToDistributorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeliverVaccineToDistributor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addComponent(lblReceivedVaccine)
                            .addComponent(lblVaccineWaitingToBeDelivered)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReceived)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDistributeVaccine))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedVaccine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDistributeVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblVaccineWaitingToBeDelivered)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverVaccineToDistributor)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        
        int selectedRowIndex = tblReceivedAllocationRequest.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a request first");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblReceivedAllocationRequest.getValueAt(selectedRowIndex, 2);
        allocationRequest.setStatus("Received by distributor");
        
        populateReceivedAllocationRequestTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnDistributeVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeVaccineActionPerformed
        
        int selectedRowIndex = tblReceivedAllocationRequest.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a request first");
            return;
        }
        
        AllocationRequest allocationRequest = (AllocationRequest)tblReceivedAllocationRequest.getValueAt(selectedRowIndex, 2);
        
        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Processing by distributor");
        
        populateReceivedAllocationRequestTable();
        populateVaccineWaitingToBeDeliveredTable();
    }//GEN-LAST:event_btnDistributeVaccineActionPerformed

    private void btnDeliverVaccineToDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverVaccineToDistributorActionPerformed

        int selectedRowIndex = tblVaccineWaitingToBeDelivered.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a row to continue");
            return;
        }

        AllocationRequest allocationRequest = (AllocationRequest)tblVaccineWaitingToBeDelivered.getValueAt(selectedRowIndex, 2);

        // add the request to Hospital Role's main work queue
        Hospital hospital = allocationRequest.getReceivedHospital();
        Role role = hospital.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
        WorkQueue mainWorkQueue = role.getMainWorkQueue();
        mainWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Delivering to hospital");
        
        populateReceivedAllocationRequestTable();
        populateVaccineWaitingToBeDeliveredTable();
    }//GEN-LAST:event_btnDeliverVaccineToDistributorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeliverVaccineToDistributor;
    private javax.swing.JButton btnDistributeVaccine;
    private javax.swing.JButton btnReceived;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReceivedVaccine;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineWaitingToBeDelivered;
    private javax.swing.JTable tblReceivedAllocationRequest;
    private javax.swing.JTable tblVaccineWaitingToBeDelivered;
    // End of variables declaration//GEN-END:variables
}
