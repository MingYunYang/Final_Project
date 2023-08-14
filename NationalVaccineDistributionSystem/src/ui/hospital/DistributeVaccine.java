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
import nvds.workqueue.AllocationRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class DistributeVaccine extends javax.swing.JPanel {

    JPanel userProcessContainer;
    
    NationalVaccineDistributionSystem nvds;
    
    UserAccount userAccount;
    
    Organization organization;
    
    AllocationRequest allocationRequest;
    
    public DistributeVaccine(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, AllocationRequest allocationRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.allocationRequest = allocationRequest;
        
        populateAllocatedvaccineDetails();
        populateSuggestedDistributionListTable();
    }
    
    public void populateAllocatedvaccineDetails(){
        txtVaccineID.setText(String.valueOf(allocationRequest.getBatch().getVaccine().getVaccineId()));
        txtVaccineName.setText(allocationRequest.getBatch().getVaccine().getName());
        txtManufacturer.setText(allocationRequest.getBatch().getManufacturer().getOrganizationName());
        txtBatchID.setText(allocationRequest.getBatch().getBatchId());
        txtPrice.setText(String.valueOf(allocationRequest.getBatch().getPriceForEachVaccine()));
        txtAvailability.setText(String.valueOf(allocationRequest.getRequestQuantity()));
        txtMFD.setText(allocationRequest.getBatch().getManufactureDate());
        txtEXD.setText(allocationRequest.getBatch().getExpirationDate());
    }

    public void populateSuggestedDistributionListTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblSuggestedDistributionList.getModel();
        model.setRowCount(0);
        
        int allocatedQuantityForCity = allocationRequest.getRequestQuantity();
        int totalSatelliteClinic = nvds.getTotalSatelliteClinicNumForSpecificHospital(organization.getCity());
        int distributedQuantityForClinic = (int)(allocatedQuantityForCity / totalSatelliteClinic);
        
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.Clinic) && organization.getCity().equals(this.organization.getCity())){
               
                Clinic clinic = (Clinic)organization;
                
                Object[] row = new Object[ 3 ];
                row[ 0 ] = clinic; // will show as the clinic's name
                row[ 1 ] = distributedQuantityForClinic;
                row[ 2 ] = checkDistributionStatus(clinic);
                
                model.addRow(row);
            }
        } 
    }
    
    public String checkDistributionStatus(Clinic clinic){
        
        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()){
            AllocationRequest allocationRequest = (AllocationRequest) request;
            if(allocationRequest.getReceivedClinic() != null && allocationRequest.getReceivedClinic().equals(clinic)){
                return "Distributed";
            }
        }
        return "Waiting";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAvailability = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtManufacturer = new javax.swing.JTextField();
        btnDistributeVaccine = new javax.swing.JButton();
        lblBatchID = new javax.swing.JLabel();
        lblSuggestedDistributionList = new javax.swing.JLabel();
        txtEXD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuggestedDistributionList = new javax.swing.JTable();
        txtAvailability = new javax.swing.JTextField();
        lblEXD = new javax.swing.JLabel();
        txtVaccineID = new javax.swing.JTextField();
        txtMFD = new javax.swing.JTextField();
        lblVaccineID = new javax.swing.JLabel();
        lblMFD = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblVaccineName = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();

        lblAvailability.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAvailability.setText("Availability:");

        lblManufacturer.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufacturer.setText("Manufacturer:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtManufacturer.setEditable(false);

        btnDistributeVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDistributeVaccine.setText("Distribute Vaccine");
        btnDistributeVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeVaccineActionPerformed(evt);
            }
        });

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblSuggestedDistributionList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSuggestedDistributionList.setText("Suggested Distribution List:");

        txtEXD.setEditable(false);

        tblSuggestedDistributionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Satellite Clinic", "Distributed Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSuggestedDistributionList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSuggestedDistributionList);

        txtAvailability.setEditable(false);

        lblEXD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEXD.setText("EXD:");

        txtVaccineID.setEditable(false);

        txtMFD.setEditable(false);

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Vaccine ID:");

        lblMFD.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMFD.setText("MFD:");

        txtVaccineName.setEditable(false);

        txtPrice.setEditable(false);

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Distribute Vaccine");

        lblPrice.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblPrice.setText("Price:");

        lblVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineName.setText("Vaccine Name:");

        txtBatchID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDistributeVaccine)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(420, 420, 420)
                        .addComponent(btnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVaccineName, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(lblAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEXD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtManufacturer)
                            .addComponent(txtEXD)))
                    .addComponent(lblSuggestedDistributionList, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addGap(71, 71, 71))
        );
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
                .addComponent(lblSuggestedDistributionList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDistributeVaccine)
                .addContainerGap(118, Short.MAX_VALUE))
        );
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
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select an suggested distribution row first");
            return;
        }

        Clinic receivedClinic = (Clinic)tblSuggestedDistributionList.getValueAt(selectedRowIndex, 0);
        int distributionQuantity = (Integer)tblSuggestedDistributionList.getValueAt(selectedRowIndex, 1);

        // add the request to Hospital Inventory Role's waiting workqueue
        allocationRequest.setReceivedClinic(receivedClinic);
        allocationRequest.setDistributedQuantityForClinic(distributionQuantity);
        allocationRequest.setStatus("Distributed By Hospital");

        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
        waitingWorkQueue.getListOfWorkRequests().add(allocationRequest);

        JOptionPane.showMessageDialog(this, "Vaccine distributed successfully");
        populateSuggestedDistributionListTable();
    }//GEN-LAST:event_btnDistributeVaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDistributeVaccine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblEXD;
    private javax.swing.JLabel lblMFD;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSuggestedDistributionList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JTable tblSuggestedDistributionList;
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
