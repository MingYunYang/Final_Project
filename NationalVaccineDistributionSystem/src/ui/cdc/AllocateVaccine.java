/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.geography.City;
import nvds.geography.State;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class AllocateVaccine extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    Batch batch;
    
    public AllocateVaccine(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds, Batch batch) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.batch = batch;
        
        populateBatchDetails();
        populateAllocationTable();
    }

    public void populateBatchDetails(){
        txtVaccineID.setText(String.valueOf(batch.getVaccine().getVaccineId()));
        txtVaccineName.setText(batch.getVaccine().getName());
        txtManufacturer.setText(batch.getManufacturer().getOrganizationName());
        txtBatchID.setText(batch.getBatchId());
        txtPrice.setText(String.valueOf(batch.getPriceForEachVaccine()));
        txtAvailability.setText(String.valueOf(batch.getAvailableQuantityInCDC()));
        txtMFD.setText(batch.getManufactureDate());
        txtEXD.setText(batch.getExpirationDate());
    }
    
    public void populateAllocationTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblAllocation.getModel();
        model.setRowCount(0);

        CDC CDC = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.CDC) && organization.getCountry().equals(this.organization.getCountry())){
                CDC = (CDC) organization;
            }
        }
        
        for(State state : CDC.getCountry().getStateList()){
            for(City city : state.getCityList()){
                Object[] row = new Object[ 8 ];
                row[ 0 ] = state;
                row[ 1 ] = state.calculateStatePopulation();
                
                int availability = batch.getQuantity();
                int totalStateNum = organization.getCountry().getStateList().size();
                double allocationQuantityDoubleForState = state.calculateAllocationQuantity(totalStateNum, availability);
                int allocationQuantityIntForState = (int)allocationQuantityDoubleForState;
                
                row[ 2 ] = allocationQuantityIntForState;
                row[ 3 ] = city;
                row[ 4 ] = city.getPopulation();
                
                double allocationQuantityDoubleForCity = allocationQuantityIntForState * ((double) city.getPopulation() / state.calculateStatePopulation());
                int allocationQuantityIntForCity = (int)allocationQuantityDoubleForCity;
                
                row[ 5 ] = allocationQuantityIntForCity;
                row[ 6 ] = city.getAffiliatedHospital();
                row[ 7 ] = checkAllocationStatus(city);
                model.addRow(row);
            }
        }
    }
    
    public String checkAllocationStatus(City city){
        
        CDC CDC = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.CDC) && organization.getCountry().equals(this.organization.getCountry())){
                CDC = (CDC)organization;
            }
        }
        
        Role cdcAllocationRole = CDC.getSpecificRole(Role.RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER);
        for ( WorkRequest request : cdcAllocationRole.getWaitingWorkQueue().getListOfWorkRequests()){
            AllocationRequest allocationRequest = (AllocationRequest) request;
            if(allocationRequest.getCity().equals(city)){
                return "Allocated";
            }
        }
        return "Waiting";
    }
    
    public boolean isApproved () {
        
        int selectedRowIndex = tblAllocation.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select an suggested allocation row first");
        }
        
        int statePopulation = (Integer)tblAllocation.getValueAt(selectedRowIndex, 1);
        int stateAllocation = (Integer)tblAllocation.getValueAt(selectedRowIndex, 2);
        int cityPopulation = (Integer)tblAllocation.getValueAt(selectedRowIndex, 4);
        int cityAllocation = (Integer)tblAllocation.getValueAt(selectedRowIndex, 5);

        return (cityPopulation > cityAllocation) && (statePopulation > stateAllocation);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAllocateVaccine = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblAvailability = new javax.swing.JLabel();
        lblVaccineName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        lblVaccineID = new javax.swing.JLabel();
        txtVaccineID = new javax.swing.JTextField();
        txtAvailability = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllocation = new javax.swing.JTable();
        lblBatchID = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        lblManufacturer = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblMFD = new javax.swing.JLabel();
        txtMFD = new javax.swing.JTextField();
        lblEXD = new javax.swing.JLabel();
        txtEXD = new javax.swing.JTextField();
        lblSuggestedAllocationList = new javax.swing.JLabel();
        btnCheckPHDApprovalRequestStatus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCheckCDCApprovalRequestStatus1 = new javax.swing.JButton();

        btnAllocateVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnAllocateVaccine.setText("Allocate Vaccine");
        btnAllocateVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllocateVaccineActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblAvailability.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAvailability.setText("Availability:");

        lblVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName.setText("Vaccine Name:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Allocate Vaccine");

        txtVaccineName.setEditable(false);

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        txtVaccineID.setEditable(false);

        txtAvailability.setEditable(false);

        tblAllocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "State", "State Popul", "State Allocated Quantity", "City", "City Popul", "City Allocated Quantity", "Received Hospital", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        tblAllocation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAllocation);
        if (tblAllocation.getColumnModel().getColumnCount() > 0) {
            tblAllocation.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblAllocation.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblAllocation.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblAllocation.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        txtManufacturer.setEditable(false);

        lblManufacturer.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufacturer.setText("Manufacturer:");

        txtBatchID.setEditable(false);

        lblPrice.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblPrice.setText("Price Per Vaccine:");

        txtPrice.setEditable(false);

        lblMFD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD.setText("MFD:");

        txtMFD.setEditable(false);

        lblEXD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD.setText("EXD:");

        txtEXD.setEditable(false);

        lblSuggestedAllocationList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSuggestedAllocationList.setText("Suggested Allocation List:");

        btnCheckPHDApprovalRequestStatus.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckPHDApprovalRequestStatus.setText("Check Approval Request Status");
        btnCheckPHDApprovalRequestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckPHDApprovalRequestStatusActionPerformed(evt);
            }
        });

        jLabel1.setText("For PHD Reviewer Only");

        jLabel2.setText("For CDC Reviewer Only");

        btnCheckCDCApprovalRequestStatus1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckCDCApprovalRequestStatus1.setText("Check Approval Request Status");
        btnCheckCDCApprovalRequestStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckCDCApprovalRequestStatus1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCheckPHDApprovalRequestStatus)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAllocateVaccine)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCheckCDCApprovalRequestStatus1)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblMFD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(251, 251, 251)))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrice))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEXD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBack)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtManufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(lblSuggestedAllocationList, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(71, 71, 71))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtManufacturer, txtPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVaccineID)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblManufacturer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVaccineName)
                                    .addComponent(lblBatchID))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAvailability)
                                    .addComponent(lblPrice)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEXD)
                        .addComponent(lblMFD))
                    .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblSuggestedAllocationList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAllocateVaccine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckPHDApprovalRequestStatus)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckCDCApprovalRequestStatus1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAllocateVaccine, btnBack});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAllocateVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllocateVaccineActionPerformed
        
        int selectedRowIndex = tblAllocation.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select an suggested allocation row first");
            return;
        }
        
        State selectedState = (State)tblAllocation.getValueAt(selectedRowIndex, 0);
        City selectedCity = (City)tblAllocation.getValueAt(selectedRowIndex, 3);
        int allocationQuantityForCity = (Integer)tblAllocation.getValueAt(selectedRowIndex, 5);
        
        // create allocation request for the selected row
        // add the request to CDC Allocation Role's waiting workqueue
        AllocationRequest allocationRequest = new AllocationRequest();
        
        allocationRequest.setVaccine(batch.getVaccine());
        allocationRequest.setStatus("Waiting");
        allocationRequest.setRequestQuantity(allocationQuantityForCity);
        allocationRequest.setBatch(batch);
        allocationRequest.setState(selectedState);
        allocationRequest.setCity(selectedCity);
        allocationRequest.setReceivedHospital(selectedCity.getAffiliatedHospital());
        
        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add(allocationRequest);
        
        // update available vaccine quantity in CDC
        int updateAvailableQuantityInCDC = batch.getAvailableQuantityInCDC() - allocationQuantityForCity;
        batch.setAvailableQuantityInCDC(updateAvailableQuantityInCDC);
        
        JOptionPane.showMessageDialog(this, "Vaccine allocated successfully");
        populateBatchDetails();
        populateAllocationTable();
    }//GEN-LAST:event_btnAllocateVaccineActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        if(component instanceof ManageVaccineInventory){
            ManageVaccineInventory mva = (ManageVaccineInventory) component;
            mva.populateDeliveryWaitingListTable();
        }
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckPHDApprovalRequestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckPHDApprovalRequestStatusActionPerformed

        if(isApproved ()){
            JOptionPane.showMessageDialog(this, "Approve request because state and city population are higher than allocated quantity");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Reject request because state and city population are lower than allocated quantity");
            return;
        }
    }//GEN-LAST:event_btnCheckPHDApprovalRequestStatusActionPerformed

    private void btnCheckCDCApprovalRequestStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckCDCApprovalRequestStatus1ActionPerformed
        
        if(isApproved ()){
            JOptionPane.showMessageDialog(this, "Approve request because state and city population are higher than allocated quantity");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Reject request because state and city population are lower than allocated quantity");
            return;
        }
    }//GEN-LAST:event_btnCheckCDCApprovalRequestStatus1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllocateVaccine;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckCDCApprovalRequestStatus1;
    private javax.swing.JButton btnCheckPHDApprovalRequestStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSuggestedAllocationList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JTable tblAllocation;
    private javax.swing.JTextField txtAvailability;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
