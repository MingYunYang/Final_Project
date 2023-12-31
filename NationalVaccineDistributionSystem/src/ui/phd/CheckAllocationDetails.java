/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.phd;

import ui.cdc.*;
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
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 * @author william
 */
public class CheckAllocationDetails extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    Batch batch;

    public CheckAllocationDetails ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, Batch batch ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.batch = batch;

        populateBatchDetails();
        populateAllocationTable();
    }

    public void populateBatchDetails () {
        txtVaccineID.setText( String.valueOf( batch.getVaccine().getVaccineId() ) );
        txtVaccineName.setText( batch.getVaccine().getName() );
        txtBatchID.setText( batch.getBatchId() );
        txtAvailability.setText( String.valueOf( batch.getAvailableQuantityInCDC() ) );
        txtMFD.setText( batch.getManufactureDate() );
        txtEXD.setText( batch.getExpirationDate() );
    }

    public void populateAllocationTable () {
        DefaultTableModel model = ( DefaultTableModel ) tblAllocationWaitingList.getModel();
        model.setRowCount( 0 );

        CDC CDC = null;
        for ( Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations() ) {
            if ( organization.getType().equals( Type.CDC ) && organization.getCountry().equals( this.organization.getCountry() ) ) {
                CDC = ( CDC ) organization;
            }
        }

        for ( State state : CDC.getCountry().getStateList() ) {
            for ( City city : state.getCityList() ) {
                Object[] row = new Object[ 7 ];
                row[ 0 ] = state;
                row[ 1 ] = state.calculateStatePopulation();

                int availability = batch.getQuantity();
                int totalStateNum = organization.getCountry().getStateList().size();
                double allocationQuantityDoubleForState = state.calculateAllocationQuantity( totalStateNum, availability );
                int allocationQuantityIntForState = ( int ) allocationQuantityDoubleForState;

                row[ 2 ] = allocationQuantityIntForState;
                row[ 3 ] = city;
                row[ 4 ] = city.getPopulation();

                double allocationQuantityDoubleForCity = allocationQuantityIntForState * (( double ) city.getPopulation() / state.calculateStatePopulation());
                int allocationQuantityIntForCity = ( int ) allocationQuantityDoubleForCity;

                row[ 5 ] = allocationQuantityIntForCity;
                row[ 6 ] = checkAllocationStatus( city );
                model.addRow( row );

                // Checking for special allocations and adding them as separate rows
                Role cdcAllocationRole = CDC.getSpecificRole( Role.RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER );

                for ( WorkRequest request : cdcAllocationRole.getWaitingWorkQueue().getListOfWorkRequests() ) {
                    AllocationRequest allocationRequest = ( AllocationRequest ) request;
                    if ( allocationRequest.getCity().equals( city ) && "Special Allocation".equals( allocationRequest.getStatus() ) ) {
                        Object[] specialRow = new Object[ 7 ];
                        specialRow[ 0 ] = state;
                        specialRow[ 1 ] = state.calculateStatePopulation();
                        specialRow[ 2 ] = allocationRequest.getRequestQuantity(); // Special quantity
                        specialRow[ 3 ] = city;
                        specialRow[ 4 ] = city.getPopulation();
                        specialRow[ 5 ] = allocationRequest.getRequestQuantity(); // Special quantity for city
                        specialRow[ 6 ] = "Special Allocation";
                        model.addRow( specialRow );
                    }
                }
            }
        }
    }
    
    public String checkAllocationStatus ( City city ) {

        CDC CDC = null;
        for ( Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations() ) {
            if ( organization.getType().equals( Type.CDC ) && organization.getCountry().equals( this.organization.getCountry() ) ) {
                CDC = ( CDC ) organization;
            }
        }

        Role cdcAllocationRole = CDC.getSpecificRole( Role.RoleType.CDC_CATALOG_AND_ALLOCATION_HANDLER );
        for ( WorkRequest request : cdcAllocationRole.getWaitingWorkQueue().getListOfWorkRequests() ) {
            AllocationRequest allocationRequest = ( AllocationRequest ) request;
            if ( allocationRequest.getCity().equals( city ) ) {
                return "Allocated";
            }
        }
        return "Waiting";
    }
    
    

    public boolean isApproved () {

        int selectedRowIndex = tblAllocationWaitingList.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select an suggested allocation row first" );
            return false;
        }

        int statePopulation = ( Integer ) tblAllocationWaitingList.getValueAt( selectedRowIndex, 1 );
        int stateAllocation = ( Integer ) tblAllocationWaitingList.getValueAt( selectedRowIndex, 2 );
        int cityPopulation = ( Integer ) tblAllocationWaitingList.getValueAt( selectedRowIndex, 4 );
        int cityAllocation = ( Integer ) tblAllocationWaitingList.getValueAt( selectedRowIndex, 5 );

        return (cityPopulation > cityAllocation) && (statePopulation > stateAllocation);
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblAvailability = new javax.swing.JLabel();
        lblVaccineName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        lblVaccineID = new javax.swing.JLabel();
        txtVaccineID = new javax.swing.JTextField();
        txtAvailability = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllocationWaitingList = new javax.swing.JTable();
        lblAllocationWaitingList = new javax.swing.JLabel();
        btnCheckPHDApprovalRequestStatus = new javax.swing.JButton();
        txtEXD = new javax.swing.JTextField();
        txtMFD = new javax.swing.JTextField();
        lblEXD = new javax.swing.JLabel();
        lblMFD = new javax.swing.JLabel();
        lblBatchID = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblAvailability.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAvailability.setText("Available Quantity:");

        lblVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName.setText("Vaccine Name:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Check Regular Allocation Details");

        txtVaccineName.setEditable(false);

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        txtVaccineID.setEditable(false);

        txtAvailability.setEditable(false);

        tblAllocationWaitingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "State", "State Popul.", "State Alloc.", "City", "City Popul.", "City Alloc.", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        tblAllocationWaitingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAllocationWaitingList);
        if (tblAllocationWaitingList.getColumnModel().getColumnCount() > 0) {
            tblAllocationWaitingList.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(6).setPreferredWidth(60);
            tblAllocationWaitingList.getColumnModel().getColumn(6).setHeaderValue("Status");
        }

        lblAllocationWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAllocationWaitingList.setText("Allocation List:");

        btnCheckPHDApprovalRequestStatus.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckPHDApprovalRequestStatus.setText("Check Approve Or Reject");
        btnCheckPHDApprovalRequestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckPHDApprovalRequestStatusActionPerformed(evt);
            }
        });

        txtEXD.setEditable(false);

        txtMFD.setEditable(false);

        lblEXD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD.setText("Batch EXD:");

        lblMFD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD.setText("Batch MFD:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        txtBatchID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckPHDApprovalRequestStatus)
                    .addComponent(lblAllocationWaitingList, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVaccineID)
                                .addComponent(txtVaccineName)
                                .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMFD)
                                .addComponent(lblAvailability)
                                .addComponent(lblEXD))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAvailability)
                                .addComponent(txtMFD)
                                .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVaccineID)
                    .addComponent(lblAvailability)
                    .addComponent(txtAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVaccineName)
                    .addComponent(lblMFD)
                    .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBatchID)
                    .addComponent(lblEXD)
                    .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblAllocationWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckPHDApprovalRequestStatus)
                .addContainerGap(183, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[ componentArray.length - 1 ];
        if ( component instanceof ManageVaccineInventory ) {
            ManageVaccineInventory mva = ( ManageVaccineInventory ) component;
            mva.populateDeliveryWaitingListTable();
            mva.populateReceivedDeliveryNotificationsTable();
        }

        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckPHDApprovalRequestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckPHDApprovalRequestStatusActionPerformed

        if ( isApproved() ) {
            JOptionPane.showMessageDialog( this, "Approve request because state and city population are higher than allocated quantity" );
            return;
        } else {
            JOptionPane.showMessageDialog( this, "Reject request because state and city population are lower than allocated quantity" );
            return;
        }
    }//GEN-LAST:event_btnCheckPHDApprovalRequestStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckPHDApprovalRequestStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAllocationWaitingList;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JTable tblAllocationWaitingList;
    private javax.swing.JTextField txtAvailability;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
