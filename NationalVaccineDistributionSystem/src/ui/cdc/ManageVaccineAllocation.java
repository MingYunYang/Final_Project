package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization.Type;
import nvds.organization.CDC;
import nvds.organization.Distributor;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.role.Role;
import nvds.vaccine.Batch;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

public class ManageVaccineAllocation extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    public ManageVaccineAllocation(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateReceivedVaccineTable();
        populateVaccineDeliveryWaitingListTable();
    }

    public void populateReceivedVaccineTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblReceivedVaccine.getModel();
        model.setRowCount(0);
        
        CDC CDC = (CDC)organization;
        
        for(Batch batch : CDC.getInventoryCatalog().getBatchList()){
            Object[] row = new Object[ 7 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = batch.getVaccine();
            row[ 2 ] = batch.getManufacturer();
            row[ 3 ] = batch; // will show as batch id
            row[ 4 ] = batch.getPriceForEachVaccine();
            row[ 5 ] = batch.getQuantity();
            row[ 6 ] = batch.getVaccine().getManufactureStatus();
            model.addRow(row);
        }
    }
    
    public void populateVaccineDeliveryWaitingListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineDeliveryWaitingList.getModel();
        model.setRowCount(0);
        
        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            
            AllocationRequest allocationRequest = (AllocationRequest) request;
            
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

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineDeliveryWaitingList = new javax.swing.JTable();
        lblVaccineDeliveryWaitingList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedVaccine = new javax.swing.JTable();
        btnAllocateVaccine = new javax.swing.JButton();
        btnDeliverVaccineToDistributor = new javax.swing.JButton();
        btnReceived = new javax.swing.JButton();
        lblReceivedVaccine = new javax.swing.JLabel();
        btnViewBatchDetails = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Allocation");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblVaccineDeliveryWaitingList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVaccineDeliveryWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVaccineDeliveryWaitingList);
        if (tblVaccineDeliveryWaitingList.getColumnModel().getColumnCount() > 0) {
            tblVaccineDeliveryWaitingList.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVaccineDeliveryWaitingList.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblVaccineDeliveryWaitingList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblVaccineDeliveryWaitingList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblVaccineDeliveryWaitingList.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        lblVaccineDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineDeliveryWaitingList.setText("Allocated Vaccine Delivery Waiting List:");

        tblReceivedVaccine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Manufacturer", "Batch ID", "Price", "Quantity", "Delivery Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedVaccine.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblReceivedVaccine);
        if (tblReceivedVaccine.getColumnModel().getColumnCount() > 0) {
            tblReceivedVaccine.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblReceivedVaccine.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblReceivedVaccine.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnAllocateVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnAllocateVaccine.setText("Allocate Vaccine");
        btnAllocateVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllocateVaccineActionPerformed(evt);
            }
        });

        btnDeliverVaccineToDistributor.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverVaccineToDistributor.setText("Send Allocation Request & Vaccine To Distributor");
        btnDeliverVaccineToDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverVaccineToDistributorActionPerformed(evt);
            }
        });

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        lblReceivedVaccine.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedVaccine.setText("Received Vaccine:");

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
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblVaccineDeliveryWaitingList)
                            .addGap(571, 571, 571))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAllocateVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnViewBatchDetails)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                                .addComponent(lblReceivedVaccine, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnDeliverVaccineToDistributor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btnBack))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAllocateVaccine, btnViewBatchDetails});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(27, 27, 27)
                .addComponent(lblReceivedVaccine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllocateVaccine)
                    .addComponent(btnViewBatchDetails))
                .addGap(18, 18, 18)
                .addComponent(lblVaccineDeliveryWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverVaccineToDistributor)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAllocateVaccine, btnDeliverVaccineToDistributor, btnReceived, btnViewBatchDetails});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAllocateVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllocateVaccineActionPerformed
        
        int selectedRowIndex = tblReceivedVaccine.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        
        Batch batch = (Batch)tblReceivedVaccine.getValueAt(selectedRowIndex, 3);
        
        AllocateVaccine av = new AllocateVaccine(userProcessContainer , userAccount , organization , nvds, batch);
        userProcessContainer.add("AllocateVaccine", av);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnAllocateVaccineActionPerformed

    private void btnDeliverVaccineToDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverVaccineToDistributorActionPerformed
        
        int selectedRowIndex = tblVaccineDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select an allocation task to continue");
            return;
        }
        
        AllocationRequest allocationRequest = (AllocationRequest)tblVaccineDeliveryWaitingList.getValueAt(selectedRowIndex, 2);
        
        Distributor distributor = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.Distributor) && organization.getCountry().equals(this.organization.getCountry())){
               distributor = (Distributor) organization;
            }
        }
        
        if(distributor != null){
            Role role = distributor.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
            WorkQueue mainWorkQueue = role.getMainWorkQueue();
            mainWorkQueue.getListOfWorkRequests().add(allocationRequest);
            allocationRequest.setStatus("Delivering to distributor");
            populateVaccineDeliveryWaitingListTable();
        } else {
            JOptionPane.showMessageDialog(this, "No distributor founded");
            return;
        }
        
    }//GEN-LAST:event_btnDeliverVaccineToDistributorActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        
        int selectedRowIndex = tblReceivedVaccine.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }

        Batch batch = (Batch)tblReceivedVaccine.getValueAt(selectedRowIndex, 3);
        batch.getVaccine().setManufactureStatus("Completed");
        
        populateReceivedVaccineTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnViewBatchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBatchDetailsActionPerformed
        
        int selectedRowIndex = tblReceivedVaccine.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        
        Batch batch = (Batch)tblReceivedVaccine.getValueAt(selectedRowIndex, 3);
        
        ViewBatchDetails vbd = new ViewBatchDetails(userProcessContainer , userAccount , organization , nvds, batch);
        userProcessContainer.add("AllocateVaccine", vbd);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnViewBatchDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllocateVaccine;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeliverVaccineToDistributor;
    private javax.swing.JButton btnReceived;
    private javax.swing.JButton btnViewBatchDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblReceivedVaccine;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineDeliveryWaitingList;
    private javax.swing.JTable tblReceivedVaccine;
    private javax.swing.JTable tblVaccineDeliveryWaitingList;
    // End of variables declaration//GEN-END:variables

}
