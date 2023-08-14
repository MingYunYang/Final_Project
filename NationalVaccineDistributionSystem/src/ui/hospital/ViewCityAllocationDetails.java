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
 *
 * @author mutar
 */
public class ViewCityAllocationDetails extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount userAccount;
    Organization organization;
    Vaccine selectedVaccine;
    
    
    public ViewCityAllocationDetails ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, Vaccine selectedVaccine) {
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
        txtManufacturer.setText(allocationRequest.getBatch().getManufacturer().getOrganizationName());
        txtBatchID.setText(allocationRequest.getBatch().getBatchId());
        txtQuantityReceived.setText(String.valueOf(allocationRequest.getRequestQuantity()));
        txtMFD.setText(allocationRequest.getBatch().getManufactureDate());
        txtEXD.setText(allocationRequest.getBatch().getExpirationDate());
        
        txtCity.setText(allocationRequest.getCity().getName());
        txtCityAllocation.setText(String.valueOf(allocationRequest.getRequestQuantity()));
        txtCityPopulation.setText(String.valueOf(allocationRequest.getCity().getPopulation()));
        txtAllocationQuantityPerClinic.setText(String.valueOf(allocationRequest.getDistributedQuantityForClinic()));
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
        int distributionPerClinic = Integer.parseInt( txtAllocationQuantityPerClinic.getText() );

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
        lblQuantityReceived = new javax.swing.JLabel();
        lblMFD = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblEXD = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtVaccineName = new javax.swing.JTextField();
        txtBatchID = new javax.swing.JTextField();
        txtManufacturer = new javax.swing.JTextField();
        txtQuantityReceived = new javax.swing.JTextField();
        txtMFD = new javax.swing.JTextField();
        txtEXD = new javax.swing.JTextField();
        txtCityAllocation = new javax.swing.JTextField();
        lblCityAllocation = new javax.swing.JLabel();
        txtCityPopulation = new javax.swing.JTextField();
        lblVaccineName2 = new javax.swing.JLabel();
        txtAllocationQuantityPerClinic = new javax.swing.JTextField();
        lblAllocationPerClinic = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblCityAllocation1 = new javax.swing.JLabel();
        btnCheckHospitalApprovalRequestStatus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setEnabled(false);

        txtVaccineID.setEditable(false);
        txtVaccineID.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtVaccineID.setForeground(new java.awt.Color(255, 0, 0));
        txtVaccineID.setEnabled(false);
        txtVaccineID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineIDActionPerformed(evt);
            }
        });

        lblVaccineName.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblVaccineName.setText("Vaccine Name:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblVaccineID.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        lblManufacturer.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblManufacturer.setText("Manufacturer:");

        lblQuantityReceived.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblQuantityReceived.setText("Quantity Recieved:");

        lblMFD.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblMFD.setText("MFD:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("View Allocation Details");

        lblEXD.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblEXD.setText("EXD:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtVaccineName.setEditable(false);
        txtVaccineName.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtVaccineName.setForeground(new java.awt.Color(255, 0, 0));
        txtVaccineName.setEnabled(false);

        txtBatchID.setEditable(false);
        txtBatchID.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtBatchID.setForeground(new java.awt.Color(255, 0, 0));
        txtBatchID.setEnabled(false);

        txtManufacturer.setEditable(false);
        txtManufacturer.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtManufacturer.setForeground(new java.awt.Color(255, 0, 0));
        txtManufacturer.setEnabled(false);

        txtQuantityReceived.setEditable(false);
        txtQuantityReceived.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtQuantityReceived.setForeground(new java.awt.Color(255, 0, 0));
        txtQuantityReceived.setEnabled(false);
        txtQuantityReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityReceivedActionPerformed(evt);
            }
        });

        txtMFD.setEditable(false);
        txtMFD.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtMFD.setForeground(new java.awt.Color(255, 0, 0));
        txtMFD.setEnabled(false);
        txtMFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMFDActionPerformed(evt);
            }
        });

        txtEXD.setEditable(false);
        txtEXD.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtEXD.setForeground(new java.awt.Color(255, 0, 0));
        txtEXD.setEnabled(false);
        txtEXD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEXDActionPerformed(evt);
            }
        });

        txtCityAllocation.setEditable(false);
        txtCityAllocation.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtCityAllocation.setForeground(new java.awt.Color(255, 0, 0));

        lblCityAllocation.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblCityAllocation.setText("City Allocation:");

        txtCityPopulation.setEditable(false);
        txtCityPopulation.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtCityPopulation.setForeground(new java.awt.Color(255, 0, 0));

        lblVaccineName2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblVaccineName2.setText("City population:");

        txtAllocationQuantityPerClinic.setEditable(false);
        txtAllocationQuantityPerClinic.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtAllocationQuantityPerClinic.setForeground(new java.awt.Color(255, 0, 0));
        txtAllocationQuantityPerClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAllocationQuantityPerClinicActionPerformed(evt);
            }
        });

        lblAllocationPerClinic.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblAllocationPerClinic.setText("Allocation per clinic:");

        txtCity.setEditable(false);
        txtCity.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 0, 0));

        lblCityAllocation1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        lblCityAllocation1.setText("City:");

        btnCheckHospitalApprovalRequestStatus.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckHospitalApprovalRequestStatus.setText("Check Approval Request Status");
        btnCheckHospitalApprovalRequestStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckHospitalApprovalRequestStatusActionPerformed(evt);
            }
        });

        jLabel1.setText("For Authorized Hospital Reviewer Only");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblVaccineName)
                                .addGap(174, 174, 174)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblManufacturer)
                                .addGap(174, 174, 174)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(174, 174, 174)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEXD)
                        .addGap(18, 18, 18)
                        .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuantityReceived, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantityReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMFD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCityAllocation1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCityAllocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCityAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblVaccineName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCityPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAllocationPerClinic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAllocationQuantityPerClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCheckHospitalApprovalRequestStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(52, 52, 52))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblBatchID, lblEXD, lblMFD, lblManufacturer, lblQuantityReceived, lblVaccineID, lblVaccineName, txtEXD, txtMFD, txtManufacturer, txtQuantityReceived, txtVaccineID, txtVaccineName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblManufacturer))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchID)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCityAllocation1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCityAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCityAllocation))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCityPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAllocationQuantityPerClinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAllocationPerClinic))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMFD)
                            .addComponent(txtMFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEXD)
                            .addComponent(txtEXD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantityReceived)
                            .addComponent(txtQuantityReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckHospitalApprovalRequestStatus)))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblBatchID, lblEXD, lblMFD, lblManufacturer, lblQuantityReceived, lblVaccineID, lblVaccineName, txtBatchID, txtEXD, txtMFD, txtManufacturer, txtQuantityReceived, txtVaccineID, txtVaccineName});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed


    private void txtQuantityReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityReceivedActionPerformed
        
    }//GEN-LAST:event_txtQuantityReceivedActionPerformed

    private void txtMFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMFDActionPerformed
        
    }//GEN-LAST:event_txtMFDActionPerformed

    private void txtEXDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEXDActionPerformed
        
    }//GEN-LAST:event_txtEXDActionPerformed

    private void txtVaccineIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineIDActionPerformed
       
    }//GEN-LAST:event_txtVaccineIDActionPerformed

    private void txtAllocationQuantityPerClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAllocationQuantityPerClinicActionPerformed
        
    }//GEN-LAST:event_txtAllocationQuantityPerClinicActionPerformed

    private void btnCheckHospitalApprovalRequestStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckHospitalApprovalRequestStatusActionPerformed
        
        if(isApproved ()){
            JOptionPane.showMessageDialog(this, "Approve request because city population is higher than allocated quantity");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Reject request because city population is lower than allocated quantity");
            return;
        }
    }//GEN-LAST:event_btnCheckHospitalApprovalRequestStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckHospitalApprovalRequestStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAllocationPerClinic;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblCityAllocation;
    private javax.swing.JLabel lblCityAllocation1;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblQuantityReceived;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JLabel lblVaccineName2;
    private javax.swing.JTextField txtAllocationQuantityPerClinic;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCityAllocation;
    private javax.swing.JTextField txtCityPopulation;
    private javax.swing.JTextField txtEXD;
    private javax.swing.JTextField txtMFD;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtQuantityReceived;
    private javax.swing.JTextField txtVaccineID;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
