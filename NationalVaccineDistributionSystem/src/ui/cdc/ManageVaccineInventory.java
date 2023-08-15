package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization.Type;
import nvds.organization.Distributor;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.role.Role;
import nvds.vaccine.Batch;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.DeliveryRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

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

    public void populateReceivedDeliveryNotificationsTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblReceivedDeliveryNotifications.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()){
            
            DeliveryRequest deliveryRequest = (DeliveryRequest)request;
            
            Object[] row = new Object[ 8 ];
            row[ 0 ] = deliveryRequest.getBatch().getVaccine().getVaccineId();
            row[ 1 ] = deliveryRequest; // will show as the vaccine name
            row[ 2 ] = deliveryRequest.getBatch().getManufacturer();
            row[ 3 ] = deliveryRequest.getBatch().getQuantity();
            row[ 4 ] = deliveryRequest.getBatch().getPriceForEachVaccine() * deliveryRequest.getBatch().getQuantity();
            row[ 5 ] = deliveryRequest.getBatch().getVaccine().getManufactureStatus();
            row[ 6 ] = deliveryRequest.getBatch().getPaymentStatus();
            row[ 7 ] = deliveryRequest.getBatch().getAvailableQuantityInCDC();
            model.addRow(row);
        }
    }
    
    public void populateDeliveryWaitingListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblDeliveryWaitingList.getModel();
        model.setRowCount(0);
        
        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            
            AllocationRequest allocationRequest = (AllocationRequest) request;
            
            Object[] row = new Object[ 8 ];
            row[ 0 ] = allocationRequest.getDeliveryNumber();
            row[ 1 ] = allocationRequest.getState();
            row[ 2 ] = allocationRequest.getCity();
            row[ 3 ] = allocationRequest; // will show as the vaccine's name
            row[ 4 ] = allocationRequest.getRequestQuantity(); // allocated quantity for each city
            row[ 5 ] = allocationRequest.getBatch().getPriceForEachVaccine() * allocationRequest.getRequestQuantity();
            row[ 6 ] = allocationRequest.getStatus();
            row[ 7 ] = allocationRequest.getPaymentStatus();
            model.addRow(row);
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryWaitingList = new javax.swing.JTable();
        lblDeliveryWaitingList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedDeliveryNotifications = new javax.swing.JTable();
        btnAllocateVaccine = new javax.swing.JButton();
        btnDeliverToDistributor = new javax.swing.JButton();
        btnReceived = new javax.swing.JButton();
        lblReceivedDeliveryNotifications = new javax.swing.JLabel();
        btnViewBatchDetails = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblDeliveryWaitingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Del. No", "Del. State", "Del. City", "Vaccine", "Del. Qty", "Total Price", "Del. Status", "Pay. Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDeliveryWaitingList);
        if (tblDeliveryWaitingList.getColumnModel().getColumnCount() > 0) {
            tblDeliveryWaitingList.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblDeliveryWaitingList.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblDeliveryWaitingList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblDeliveryWaitingList.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblDeliveryWaitingList.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        lblDeliveryWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDeliveryWaitingList.setText("Delivery Waiting List:");

        tblReceivedDeliveryNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Manufacturer", "Recv. Qty", "Total Price", "Del. Status", "Pay. Status", "Avail. Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceivedDeliveryNotifications.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblReceivedDeliveryNotifications);
        if (tblReceivedDeliveryNotifications.getColumnModel().getColumnCount() > 0) {
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblReceivedDeliveryNotifications.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        btnAllocateVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnAllocateVaccine.setText("Allocate Vaccine");
        btnAllocateVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllocateVaccineActionPerformed(evt);
            }
        });

        btnDeliverToDistributor.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverToDistributor.setText("Deliver To Distributor");
        btnDeliverToDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverToDistributorActionPerformed(evt);
            }
        });

        btnReceived.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnReceived.setText("Received");
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        lblReceivedDeliveryNotifications.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedDeliveryNotifications.setText("Received Manufactured Vaccine:");

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
                    .addComponent(lblDeliveryWaitingList)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAllocateVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewBatchDetails))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                        .addComponent(lblReceivedDeliveryNotifications, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDeliverToDistributor, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAllocateVaccine, btnViewBatchDetails});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(27, 27, 27)
                .addComponent(lblReceivedDeliveryNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllocateVaccine)
                    .addComponent(btnViewBatchDetails))
                .addGap(18, 18, 18)
                .addComponent(lblDeliveryWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverToDistributor)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAllocateVaccine, btnDeliverToDistributor, btnReceived, btnViewBatchDetails});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAllocateVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllocateVaccineActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        if(tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 6) != "Paid"){
            JOptionPane.showMessageDialog(this, "Selected batch of vaccine needs to be received first");
            return;
        }
        
        DeliveryRequest deliveryRequest = (DeliveryRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        Batch batch = deliveryRequest.getBatch();
        
        AllocateVaccine av = new AllocateVaccine(userProcessContainer , userAccount , organization , nvds, batch);
        userProcessContainer.add("AllocateVaccine", av);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnAllocateVaccineActionPerformed

    private void btnDeliverToDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverToDistributorActionPerformed
        
        int selectedRowIndex = tblDeliveryWaitingList.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a delivery task from the table");
            return;
        }
        
        AllocationRequest allocationRequest = (AllocationRequest)tblDeliveryWaitingList.getValueAt(selectedRowIndex, 3);
        
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
            allocationRequest.setStatus("Delivered To Distributor");
            
            JOptionPane.showMessageDialog(this, "Vaccine delivered sucessfully");
            populateDeliveryWaitingListTable();
            return;
        } else {
            JOptionPane.showMessageDialog(this, "No distributor founded");
            return;
        }
        
    }//GEN-LAST:event_btnDeliverToDistributorActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }

        DeliveryRequest deliveryRequest = (DeliveryRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        Batch batch = deliveryRequest.getBatch();
        batch.getVaccine().setManufactureStatus("Completed");
        batch.setPaymentStatus("Paid");
        
        populateReceivedDeliveryNotificationsTable();
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnViewBatchDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBatchDetailsActionPerformed
        
        int selectedRowIndex = tblReceivedDeliveryNotifications.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a batch of vaccine first");
            return;
        }
        
        DeliveryRequest deliveryRequest = (DeliveryRequest)tblReceivedDeliveryNotifications.getValueAt(selectedRowIndex, 1);
        Batch batch = deliveryRequest.getBatch();
        
        ViewBatchDetails vbd = new ViewBatchDetails(userProcessContainer , userAccount , organization , nvds, batch);
        userProcessContainer.add("AllocateVaccine", vbd);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnViewBatchDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllocateVaccine;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeliverToDistributor;
    private javax.swing.JButton btnReceived;
    private javax.swing.JButton btnViewBatchDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDeliveryWaitingList;
    private javax.swing.JLabel lblReceivedDeliveryNotifications;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDeliveryWaitingList;
    private javax.swing.JTable tblReceivedDeliveryNotifications;
    // End of variables declaration//GEN-END:variables

}
