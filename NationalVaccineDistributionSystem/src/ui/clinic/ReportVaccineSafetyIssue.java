 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.AdverseEventTracking;
import nvds.workqueue.AdverseEventTrackingRequest;
import nvds.workqueue.WorkRequest;

/**
 * @author libby
 * @author mutara
 */
public class ReportVaccineSafetyIssue extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;
    
    public ReportVaccineSafetyIssue(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateWaitingWorkQueueTable();
    }

    private void populateWaitingWorkQueueTable() {

        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        model.setRowCount(0);

        for (WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            if (request instanceof AdverseEventTrackingRequest) {
                    Object[] row = new Object[ 11 ];
                    row[ 0 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getEventId();
                    row[ 1 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getDateReported();
                    row[ 2 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getDescription();
                    row[ 3 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getPeopleAffected();
                    row[ 4 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getVaccineName();
                    row[ 5 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getBatchId();
                    row[ 6 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getManufacturer();
                    row[ 7 ] = request.getSender();
                    row[ 8 ] = request.getReceiver();
                    String recallStatus = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getRecallStatus();
                    row[ 9 ] = ((recallStatus == null) ? "Waiting" : recallStatus);
                    String recallReason = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getRecallReason();
                    row[ 10 ] = ((recallReason == null) ? "Waiting" : recallReason);
                    model.addRow(row);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPatientDeathsIfAny = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtVaccineName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBatchId = new javax.swing.JTextField();
        txtVaccineManufacturer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequests = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPatientsAffected = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSendSafetyIssueReport = new javax.swing.JButton();

        txtPatientDeathsIfAny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientDeathsIfAnyActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        lblMessage.setText("Description:");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Safety issue report work list:");

        txtBatchId.setToolTipText("MMYY-CODE-00000");
        txtBatchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatchIdActionPerformed(evt);
            }
        });

        txtVaccineManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineManufacturerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jLabel1.setText("Vaccine Name:");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jLabel2.setText("Batch ID:");

        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Event Id", "Report date", "Description", "People Affected", "Vaccine", "BatchID", "Manufacturer", "Sender", "Reciever", "Recall Status", "Recall Reason"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequests);

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jLabel3.setText("Manufacturer:");

        txtPatientsAffected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientsAffectedActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jLabel7.setText("Report any deaths:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Report Vaccine Safety Issue:");

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jLabel8.setText("Affected Patients:");

        btnSendSafetyIssueReport.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSendSafetyIssueReport.setText("Send Report");
        btnSendSafetyIssueReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendSafetyIssueReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMessage)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtVaccineName)
                                    .addComponent(txtBatchId))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtVaccineManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSendSafetyIssueReport)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtPatientsAffected, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                                .addComponent(txtPatientDeathsIfAny)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(91, 91, 91))
                            .addComponent(lblTitle)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(254, 254, 254))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMessage)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtVaccineManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(txtPatientsAffected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtPatientDeathsIfAny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSendSafetyIssueReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientDeathsIfAnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientDeathsIfAnyActionPerformed
       
    }//GEN-LAST:event_txtPatientDeathsIfAnyActionPerformed

    private void txtBatchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatchIdActionPerformed
        
    }//GEN-LAST:event_txtBatchIdActionPerformed

    private void txtVaccineManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineManufacturerActionPerformed
        
    }//GEN-LAST:event_txtVaccineManufacturerActionPerformed

    private void txtPatientsAffectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientsAffectedActionPerformed
        
    }//GEN-LAST:event_txtPatientsAffectedActionPerformed

    private void btnSendSafetyIssueReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendSafetyIssueReportActionPerformed

        String description = txtDescription.getText();
        String vaccineName = txtVaccineName.getText();
        String manufacturer = txtVaccineManufacturer.getText();
        String batchId = txtBatchId.getText();
        if ( description.isEmpty() || vaccineName.isEmpty() || manufacturer.isEmpty() || batchId.isEmpty() ) {
            JOptionPane.showMessageDialog(this , "All fields must be filled out");
            return;
        }

        int patientsAffected;
        int noOfDeaths;
        try {
            patientsAffected = Integer.parseInt(txtPatientsAffected.getText());
            noOfDeaths = Integer.parseInt(txtPatientDeathsIfAny.getText());

        } catch ( NumberFormatException e ) {
            JOptionPane.showMessageDialog(this , "Please enter a valid number for patients affected and deaths");
            return;
        }

        AdverseEventTrackingRequest request = new AdverseEventTrackingRequest();
        AdverseEventTracking adverseEventTracking = request.getAdverseEventTracking();

        if ( adverseEventTracking == null ) {
            JOptionPane.showMessageDialog(this , "Adverse event tracking is not initialized");
            return;
        }
        adverseEventTracking.setDescription(description);
        adverseEventTracking.setVaccineName(vaccineName);
        adverseEventTracking.setManufacturer(manufacturer);
        adverseEventTracking.setBatchId(batchId);
        adverseEventTracking.setAffectedPeople(patientsAffected);
        adverseEventTracking.setDeaths(noOfDeaths);
        request.setSender(userAccount);
        request.setStatus("Sent");

        // add the request to CDC Adverse Event Handling Role's work queue 每個國家只有一個CDC
        // add the request to Clinic Doctor Role's work queue as well
        CDC cdcInTheCountry = null;
        for(Organization organization : ecosystem.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.CDC) && organization.getCountry().equals(organization.getCountry())){
               cdcInTheCountry = (CDC)organization;
            }
        }
        
        if (cdcInTheCountry != null) {
            Role cdcAdverseEventHandler = cdcInTheCountry.getSpecificRole(Role.RoleType.CDC_ADVERSE_EVENT_HANDLER);
            cdcAdverseEventHandler.getMainWorkQueue().getListOfWorkRequests().add(request);
            userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add(request);
        } else {
            JOptionPane.showMessageDialog(this , "CDC organization not founded");
            return;
        }

        JOptionPane.showMessageDialog(this , "Request sent successfully");
        
        txtDescription.setText("");
        txtBatchId.setText("");
        txtPatientDeathsIfAny.setText("");
        txtPatientsAffected.setText("");
        txtVaccineManufacturer.setText("");
        txtVaccineName.setText("");
        
        populateWaitingWorkQueueTable();
    }//GEN-LAST:event_btnSendSafetyIssueReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendSafetyIssueReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    private javax.swing.JTextField txtBatchId;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPatientDeathsIfAny;
    private javax.swing.JTextField txtPatientsAffected;
    private javax.swing.JTextField txtVaccineManufacturer;
    private javax.swing.JTextField txtVaccineName;
    // End of variables declaration//GEN-END:variables
}
