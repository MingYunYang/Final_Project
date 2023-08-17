/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hospital;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 * @author libby
 * @author mutara
 */
public class CheckAllocationDetails extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount userAccount;
    Organization organization;
    Vaccine selectedVaccine;
    
    
    public CheckAllocationDetails ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, Vaccine selectedVaccine) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.selectedVaccine = selectedVaccine;

        AllocationRequest allocationRequest = getAllocationRequest(selectedVaccine);
        populateBatchDetails(allocationRequest);
    }

    public void populateBatchDetails (AllocationRequest allocationRequest) {
        txtVaccineID.setText(String.valueOf(allocationRequest.getVaccine().getVaccineId()));
        txtVaccineName.setText(allocationRequest.getVaccine().getName());
        txtReceivedQuantity.setText(String.valueOf(allocationRequest.getRequestQuantity()));
        txtAvailableQuantity.setText(String.valueOf(allocationRequest.getBatch().getAvailableQuantityInHospital()));
        txtManufacturer.setText(allocationRequest.getBatch().getManufacturer().getOrganizationName());
        txtBatchID.setText(allocationRequest.getBatch().getBatchId());
        txtMFD.setText(allocationRequest.getBatch().getManufactureDate());
        txtEXD.setText(allocationRequest.getBatch().getExpirationDate());
        
        txtCity.setText(allocationRequest.getCity().getName());
        txtCityAllocation.setText(String.valueOf(allocationRequest.getRequestQuantity()));
        txtCityPopulation.setText(String.valueOf(allocationRequest.getCity().getPopulation()));
        txtClinicAllocation.setText(String.valueOf(allocationRequest.getDistributedQuantityForClinic()));
    }
    
    public AllocationRequest getAllocationRequest(Vaccine vaccine){
        
        Role hospitalInventoryRole = organization.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
        WorkQueue mainWorkQueue = hospitalInventoryRole.getMainWorkQueue();
        
        int allocationQuantityForCity = 0;
        for(WorkRequest request : mainWorkQueue.getListOfWorkRequests()){
            
            AllocationRequest allocationRequest = (AllocationRequest) request;
            if(allocationRequest.getVaccine().equals(vaccine)){
                return allocationRequest;
            }
        }
        return null;
    }

    public boolean isApproved () {
        int cityPopulation = Integer.parseInt( txtCityPopulation.getText() );
        int cityAllocation = Integer.parseInt( txtCityAllocation.getText() );
        int distributionPerClinic = Integer.parseInt( txtClinicAllocation.getText() );

        return cityPopulation > cityAllocation + distributionPerClinic;
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtVaccineID = new javax.swing.JTextField();
        lblVaccineName = new javax.swing.JLabel();
        lblBatchID = new javax.swing.JLabel();
        lblVaccineID = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        lblMFD = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblEXD = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtVaccineName = new javax.swing.JTextField();
        txtBatchID = new javax.swing.JTextField();
        txtManufacturer = new javax.swing.JTextField();
        txtMFD = new javax.swing.JTextField();
        txtEXD = new javax.swing.JTextField();
        txtCityAllocation = new javax.swing.JTextField();
        lblCityAllocation = new javax.swing.JLabel();
        txtClinicAllocation = new javax.swing.JTextField();
        lblCityPopulation = new javax.swing.JLabel();
        lblClinicAllocation = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        btnCheckHospitalApprovalRequestStatus = new javax.swing.JButton();
        txtReceivedQuantity = new javax.swing.JTextField();
        lblRecievedQuantity = new javax.swing.JLabel();
        lblAvailableQuantity = new javax.swing.JLabel();
        txtAvailableQuantity = new javax.swing.JTextField();
        txtCityPopulation = new javax.swing.JTextField();

        setEnabled(false);

        txtVaccineID.setEditable(false);
        txtVaccineID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtVaccineID.setForeground(new java.awt.Color(255, 0, 0));
        txtVaccineID.setEnabled(false);
        txtVaccineID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineIDActionPerformed(evt);
            }
        });

        lblVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName.setText("Vaccine:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        lblManufacturer.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufacturer.setText("Manufacturer:");

        lblMFD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD.setText("Batch MFD:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Check Regular Allocation Details");

        lblEXD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD.setText("Batch EXD:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtVaccineName.setEditable(false);
        txtVaccineName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtVaccineName.setForeground(new java.awt.Color(255, 0, 0));
        txtVaccineName.setEnabled(false);

        txtBatchID.setEditable(false);
        txtBatchID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtBatchID.setForeground(new java.awt.Color(255, 0, 0));
        txtBatchID.setEnabled(false);

        txtManufacturer.setEditable(false);
        txtManufacturer.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtManufacturer.setForeground(new java.awt.Color(255, 0, 0));
        txtManufacturer.setEnabled(false);

        txtMFD.setEditable(false);
        txtMFD.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtMFD.setForeground(new java.awt.Color(255, 0, 0));
        txtMFD.setEnabled(false);
        txtMFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMFDActionPerformed(evt);
            }
        });

        txtEXD.setEditable(false);
        txtEXD.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtEXD.setForeground(new java.awt.Color(255, 0, 0));
        txtEXD.setEnabled(false);
        txtEXD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEXDActionPerformed(evt);
            }
        });

        txtCityAllocation.setEditable(false);
        txtCityAllocation.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCityAllocation.setForeground(new java.awt.Color(255, 0, 0));

        lblCityAllocation.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCityAllocation.setText("City Allo:");

        txtClinicAllocation.setEditable(false);
        txtClinicAllocation.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtClinicAllocation.setForeground(new java.awt.Color(255, 0, 0));

        lblCityPopulation.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCityPopulation.setText("City Popu:");

        lblClinicAllocation.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblClinicAllocation.setText("Clinic Allo:");

        txtCity.setEditable(false);
        txtCity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 0, 0));

        lblCity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCity.setText("City:");

        btnCheckHospitalApprovalRequestStatus.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckHospitalApprovalRequestStatus.setText("Check Approve Or Reject");
        btnCheckHospitalApprovalRequestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckHospitalApprovalRequestStatusActionPerformed(evt);
            }
        });

        txtReceivedQuantity.setEditable(false);
        txtReceivedQuantity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtReceivedQuantity.setForeground(new java.awt.Color(255, 0, 0));
        txtReceivedQuantity.setEnabled(false);

        lblRecievedQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRecievedQuantity.setText("Received Quantity:");

        lblAvailableQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAvailableQuantity.setText("Available Quantity:");

        txtAvailableQuantity.setEditable(false);
        txtAvailableQuantity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtAvailableQuantity.setForeground(new java.awt.Color(255, 0, 0));
        txtAvailableQuantity.setEnabled(false);

        txtCityPopulation.setEditable(false);
        txtCityPopulation.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtCityPopulation.setForeground(new java.awt.Color(255, 0, 0));
        txtCityPopulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityPopulationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblRecievedQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtReceivedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblAvailableQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblManufacturer)
                                    .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblMFD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEXD, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(txtMFD)))
                            .addComponent(btnCheckHospitalApprovalRequestStatus, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblClinicAllocation)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCityPopulation)
                                    .addComponent(lblCityAllocation)
                                    .addComponent(lblCity))
                                .addGap(44, 44, 44)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCityAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCityPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClinicAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVaccineName)
                        .addGap(18, 18, 18)
                        .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(249, 249, 249)
                        .addComponent(btnBack)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMFD, lblManufacturer, lblVaccineID, lblVaccineName, txtManufacturer, txtVaccineID, txtVaccineName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReceivedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecievedQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvailableQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblManufacturer)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMFD)
                            .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEXD)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCityAllocation)
                            .addComponent(txtCityAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCityPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCityPopulation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblClinicAllocation)
                            .addComponent(txtClinicAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnCheckHospitalApprovalRequestStatus)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblBatchID, lblEXD, lblMFD, lblManufacturer, lblVaccineID, lblVaccineName, txtBatchID, txtEXD, txtMFD, txtManufacturer, txtVaccineID, txtVaccineName});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed


    private void txtMFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMFDActionPerformed
        
    }//GEN-LAST:event_txtMFDActionPerformed

    private void txtEXDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEXDActionPerformed
        
    }//GEN-LAST:event_txtEXDActionPerformed

    private void txtVaccineIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineIDActionPerformed
       
    }//GEN-LAST:event_txtVaccineIDActionPerformed

    private void btnCheckHospitalApprovalRequestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckHospitalApprovalRequestStatusActionPerformed
        
        if(isApproved ()){
            JOptionPane.showMessageDialog(this, "Approve request because city population is higher than allocated quantity");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Reject request because city population is lower than allocated quantity");
            return;
        }
    }//GEN-LAST:event_btnCheckHospitalApprovalRequestStatusActionPerformed

    private void txtCityPopulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityPopulationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityPopulationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckHospitalApprovalRequestStatus;
    private javax.swing.JLabel lblAvailableQuantity;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCityAllocation;
    private javax.swing.JLabel lblCityPopulation;
    private javax.swing.JLabel lblClinicAllocation;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblRecievedQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JTextField txtAvailableQuantity;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCityAllocation;
    private javax.swing.JTextField txtCityPopulation;
    private javax.swing.JTextField txtClinicAllocation;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtReceivedQuantity;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
