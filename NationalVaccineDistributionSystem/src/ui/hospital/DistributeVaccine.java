/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hospital;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Clinic;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;

/**
 * @author libby
 * @author mutara
 */
public class DistributeVaccine extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    AllocationRequest allocationRequest;
    
    Batch batch;

    public DistributeVaccine ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, AllocationRequest allocationRequest, Batch batch ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.allocationRequest = allocationRequest;
        this.batch = batch;

        populateAllocatedvaccineDetails();
        populateSuggestedDistributionListTable();
    }

    public void populateAllocatedvaccineDetails () {
        txtVaccineID.setText( String.valueOf( allocationRequest.getBatch().getVaccine().getVaccineId() ) );
        txtVaccineName.setText( allocationRequest.getBatch().getVaccine().getName() );
        txtBatchID.setText( allocationRequest.getBatch().getBatchId() );
        txtAvailability.setText( String.valueOf( allocationRequest.getBatch().getAvailableQuantityInHospital() ) );
        txtMFD.setText( allocationRequest.getBatch().getManufactureDate() );
        txtEXD.setText( allocationRequest.getBatch().getExpirationDate() );
    }

    public void populateSuggestedDistributionListTable () {

        DefaultTableModel model = ( DefaultTableModel ) tblSuggestedDistributionList.getModel();
        model.setRowCount( 0 );

        int allocatedQuantityForCity = allocationRequest.getRequestQuantity();
        int totalSatelliteClinic = nvds.getTotalSatelliteClinicNumForSpecificHospital( organization.getCity() );
        int distributedQuantityForClinic = ( int ) (allocatedQuantityForCity / totalSatelliteClinic);

        for ( Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations() ) {
            if ( organization.getType().equals( Type.Clinic ) && organization.getCity().equals( this.organization.getCity() ) ) {

                Clinic clinic = ( Clinic ) organization;

                Object[] row = new Object[ 3 ]; // Added new column for specific quantity
                row[ 0 ] = clinic; // will show as the clinic's name
                row[ 1 ] = distributedQuantityForClinic;
                row[ 2 ] = ""; // New column to take input for specific quantity
                model.addRow( row );
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnDistributeVaccine = new javax.swing.JButton();
        lblDistributionWaitingList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuggestedDistributionList = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblVaccineID1 = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        lblVaccineName1 = new javax.swing.JLabel();
        lblAvailability1 = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();
        lblBatchID1 = new javax.swing.JLabel();
        lblMFD1 = new javax.swing.JLabel();
        lblEXD1 = new javax.swing.JLabel();
        txtMFD = new javax.swing.JTextField();
        txtEXD = new javax.swing.JTextField();
        txtAvailability = new javax.swing.JTextField();
        txtVaccineID = new javax.swing.JTextField();

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDistributeVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDistributeVaccine.setText("Confirm Distribution");
        btnDistributeVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeVaccineActionPerformed(evt);
            }
        });

        lblDistributionWaitingList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDistributionWaitingList.setText("Distribution Waiting List:");

        tblSuggestedDistributionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Satellite Clinic", "Distributed Qty", "Specific Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuggestedDistributionList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSuggestedDistributionList);

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Distribute Vaccine");

        lblVaccineID1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID1.setText("Vaccine ID:");

        txtVaccineName.setEditable(false);

        lblVaccineName1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName1.setText("Vaccine Name:");

        lblAvailability1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAvailability1.setText("Available Quantity:");

        txtBatchID.setEditable(false);

        lblBatchID1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID1.setText("Batch ID:");

        lblMFD1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD1.setText("Batch MFD:");

        lblEXD1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD1.setText("Batch EXD:");

        txtMFD.setEditable(false);

        txtEXD.setEditable(false);

        txtAvailability.setEditable(false);

        txtVaccineID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDistributeVaccine)
                    .addComponent(lblDistributionWaitingList, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBatchID1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblVaccineID1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblVaccineName1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVaccineID)
                                .addComponent(txtVaccineName)
                                .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(65, 65, 65)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMFD1)
                                .addComponent(lblAvailability1)
                                .addComponent(lblEXD1))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAvailability)
                                .addComponent(txtMFD)
                                .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineID1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchID1)
                            .addComponent(lblEXD1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvailability1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblMFD1)))
                        .addGap(14, 14, 14)
                        .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblDistributionWaitingList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDistributeVaccine)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, btnDistributeVaccine});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVaccineInventory mva = (ManageVaccineInventory) component;
        mva.populateDeliveryWaitingListTable();
        mva.populateReceivedDeliveryNotificationsTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDistributeVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeVaccineActionPerformed

        
        int selectedRowIndex = tblSuggestedDistributionList.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a distribution target first" );
            return;
        }

        Clinic receivedClinic = ( Clinic ) tblSuggestedDistributionList.getValueAt( selectedRowIndex, 0 );
        int distributionQuantity;

        // Use specific quantity if provided, otherwise use suggested quantity
        String specificQuantityStr = ( String ) tblSuggestedDistributionList.getValueAt( selectedRowIndex, 2 );
        if ( specificQuantityStr != null && !specificQuantityStr.trim().isEmpty() ) {
            try {
                distributionQuantity = Integer.parseInt( specificQuantityStr );
            } catch ( NumberFormatException e ) {
                JOptionPane.showMessageDialog( this, "Please enter a valid quantity" );
                return;
            }
        } else {
            distributionQuantity = ( Integer ) tblSuggestedDistributionList.getValueAt( selectedRowIndex, 1 );
        }

        // Ensure that the specific distribution quantity doesn't exceed the available quantity
        if ( distributionQuantity > Integer.parseInt( txtAvailability.getText() ) ) {
            JOptionPane.showMessageDialog( this, "Distribution quantity exceeds available quantity" );
            return;
        }

        // add the request to Hospital Inventory Role's waiting workqueue
        allocationRequest.setReceivedClinic( receivedClinic );
        allocationRequest.setDistributedQuantityForClinic( distributionQuantity );
        allocationRequest.setStatus( "Distributed By Hospital" );
        int updateAvailableQuantity = allocationRequest.getBatch().getAvailableQuantityInHospital() - distributionQuantity;
        allocationRequest.getBatch().setAvailableQuantityInHospital(updateAvailableQuantity);

        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add( allocationRequest );

        // Update the available quantity after distributing the vaccines
        int newAvailability = Integer.parseInt( txtAvailability.getText() ) - distributionQuantity;
        txtAvailability.setText( String.valueOf( newAvailability ) );

        JOptionPane.showMessageDialog( this, "Vaccine distributed successfully" );
        populateSuggestedDistributionListTable();
    }//GEN-LAST:event_btnDistributeVaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDistributeVaccine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvailability1;
    private javax.swing.JLabel lblBatchID1;
    private javax.swing.JLabel lblDistributionWaitingList;
    private javax.swing.JLabel lblEXD1;
    private javax.swing.JLabel lblMFD1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID1;
    private javax.swing.JLabel lblVaccineName1;
    private javax.swing.JTable tblSuggestedDistributionList;
    private javax.swing.JTextField txtAvailability;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
