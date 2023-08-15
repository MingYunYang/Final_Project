/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.distributor;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;

/**
 * @author libby
 * @author mutara
 */
public class CheckDistributionDetails extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    AllocationRequest allocationRequest;
    
    public CheckDistributionDetails(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds, AllocationRequest allocationRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.allocationRequest = allocationRequest;
        
        populateAlloctionDetails();
    }
    
    public void populateAlloctionDetails(){
        txtVaccineID.setText(String.valueOf(allocationRequest.getVaccine().getVaccineId()));
        txtVaccineName.setText(allocationRequest.getVaccine().getName());
        txtBatchID.setText(allocationRequest.getBatch().getBatchId());
        txtPrice.setText(String.valueOf(allocationRequest.getBatch().getPriceForEachVaccine()));
        txtQuantity.setText(String.valueOf(allocationRequest.getRequestQuantity())); // allocated quantity for city
        txtMFD.setText(allocationRequest.getBatch().getManufactureDate());
        txtEXD.setText(allocationRequest.getBatch().getExpirationDate());
        
        txtDestinationState.setText(allocationRequest.getState().getName());
        txtDestinationCity.setText(allocationRequest.getCity().getName());
        txtReceivedHospital.setText(allocationRequest.getReceivedHospital().getOrganizationName());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVaccineID = new javax.swing.JLabel();
        txtEXD = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtVaccineID = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtBatchID = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        txtVaccineName = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblEXD = new javax.swing.JLabel();
        lblMFD = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblBatchID = new javax.swing.JLabel();
        lblVaccineName = new javax.swing.JLabel();
        txtMFD = new javax.swing.JTextField();
        lblDestinationState = new javax.swing.JLabel();
        txtDestinationState = new javax.swing.JTextField();
        lblDestinationCity = new javax.swing.JLabel();
        txtDestinationCity = new javax.swing.JTextField();
        lblReceivedHospital = new javax.swing.JLabel();
        txtReceivedHospital = new javax.swing.JTextField();
        btnConfirmDistribution = new javax.swing.JButton();

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        txtEXD.setEditable(false);

        lblPrice.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblPrice.setText("Price Per Vaccine:");

        txtQuantity.setEditable(false);
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        txtVaccineID.setEditable(false);

        txtPrice.setEditable(false);

        txtBatchID.setEditable(false);

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtVaccineName.setEditable(false);

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Check Distribution Details");

        lblEXD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD.setText("Batch EXD:");

        lblMFD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD.setText("Batch MFD:");

        lblQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblQuantity.setText("Distribution Quantity:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName.setText("Vaccine Name:");

        txtMFD.setEditable(false);

        lblDestinationState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDestinationState.setText("Destination State:");

        txtDestinationState.setEditable(false);

        lblDestinationCity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblDestinationCity.setText("Destination City:");

        txtDestinationCity.setEditable(false);

        lblReceivedHospital.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedHospital.setText("Received Hospital:");

        txtReceivedHospital.setEditable(false);

        btnConfirmDistribution.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnConfirmDistribution.setText("Confirm Distribution");
        btnConfirmDistribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmDistributionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmDistribution)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMFD)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEXD)
                                        .addGap(114, 114, 114)
                                        .addComponent(txtEXD, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblPrice)
                                                .addComponent(lblQuantity)
                                                .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblVaccineName)
                                                .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                .addComponent(txtBatchID, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtVaccineName, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtVaccineID, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtQuantity)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblReceivedHospital)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtReceivedHospital, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDestinationState)
                                            .addComponent(lblDestinationCity))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDestinationState, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(txtDestinationCity))))
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack)))
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVaccineID)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMFD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEXD)
                            .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDestinationState)
                            .addComponent(txtDestinationState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDestinationCity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReceivedHospital)
                            .addComponent(txtReceivedHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(btnConfirmDistribution)
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed

    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnConfirmDistributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmDistributionActionPerformed
                
        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add(allocationRequest);
        allocationRequest.setStatus("Confirmed By Distributor");
        
        // going back to the previous page automatically
        userProcessContainer.remove( this );

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[ componentArray.length - 1 ];
        ManageVaccineInventory mva = ( ManageVaccineInventory ) component;
        mva.populateDeliveryWaitingListTable();
        mva.populateReceivedDeliveryNotificationsTable();

        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnConfirmDistributionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmDistribution;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblDestinationCity;
    private javax.swing.JLabel lblDestinationState;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblReceivedHospital;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtDestinationCity;
    private javax.swing.JTextField txtDestinationState;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReceivedHospital;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
