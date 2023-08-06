package nvds.ui.clinic;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.CDC;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.Useraccount.UserAccount;
import nvds.WorkQueue.AdverseEventTrackingWorkRequest;
import nvds.WorkQueue.WorkRequest;

/**
 * ReportVaccineSafetyIssue class represents a panel for reporting safety issues
 * related to vaccines.
 */
public class ReportVaccineSafetyIssue extends javax.swing.JPanel {

    // Instance variables
    JPanel userProcessContainer;

    UserAccount employeeUserAccount;

    NvdsParticipatingOrganization participatingOrganization;

    NationalVaccineDistributionSystem nvds;

    /**
     * Constructor that initializes the panel, and sets up the user details,
     * participating organizations, and NVDS instance.
     *
     * @param userProcessContainer the main container panel
     * @param employeeUserAccount the account of the logged-in user
     * @param participatingOrganization the participating
     * @param nvds the National Vaccine Distribution System instance
     */
    public ReportVaccineSafetyIssue(JPanel userProcessContainer , UserAccount employeeUserAccount , NvdsParticipatingOrganization participatingOrganization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.employeeUserAccount = employeeUserAccount;
        this.userProcessContainer = userProcessContainer;
        this.participatingOrganization = participatingOrganization;
        this.nvds = nvds;
        // Populates the request table with existing work requests
        populateRequestTable();

    }

    /**
     * Method to populate the request table with existing work requests.
     */
    private void populateRequestTable() {
        DefaultTableModel model = ( DefaultTableModel ) tblWorkRequests.getModel();
        model.setRowCount(0);

        for ( WorkRequest request : employeeUserAccount.getWorkQueue().getListOfWorkRequests() ) {
            if ( request instanceof AdverseEventTrackingWorkRequest report ) {
                Object[] row = new Object[ 12 ];
                row[ 0 ] = report.getAdverseEventTracking().getEventId();
                row[ 1 ] = report.getAdverseEventTracking().getDateReported();
                row[ 2 ] = report.getAdverseEventTracking().getDescription();
                row[ 3 ] = report.getAdverseEventTracking().getPeopleAffected();
                row[ 4 ] = report.getAdverseEventTracking().getVaccineName();
                row[ 5 ] = report.getAdverseEventTracking().getBatchId();
                row[ 6 ] = report.getAdverseEventTracking().getManufacturer();
                row[ 7 ] = request.getRequestSender();
                row[ 8 ] = request.getRequestReceiver();
                String recallStatus = report.getAdverseEventTracking().getRecallStatus();
                row[ 9 ] = ((recallStatus == null) ? "Waiting" : recallStatus);
                String recallReason = report.getAdverseEventTracking().getRecallReason();
                row[ 10 ] = ((recallReason == null) ? "Waiting" : recallReason);
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequests = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnSendSafetyIssueReport = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtVaccineName = new javax.swing.JTextField();
        txtBatchId = new javax.swing.JTextField();
        txtVaccineManufacturer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPatientsAffected = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPatientDeathsIfAny = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));

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
        if (tblWorkRequests.getColumnModel().getColumnCount() > 0) {
            tblWorkRequests.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblWorkRequests.getColumnModel().getColumn(2).setPreferredWidth(50);
        }
        tblWorkRequests.getAccessibleContext().setAccessibleName("");

        btnRefresh.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblTitle.setText("Doctor's Work Area");

        btnSendSafetyIssueReport.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        btnSendSafetyIssueReport.setText("Send Report");
        btnSendSafetyIssueReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendSafetyIssueReportActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblMessage.setText("Description");

        txtVaccineName.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        txtBatchId.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        txtVaccineManufacturer.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtVaccineManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineManufacturerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Vaccine Name");

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Vaccine Batch Id");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel3.setText("Manufacturer");

        txtPatientsAffected.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtPatientsAffected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientsAffectedActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("Report any deaths");

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("No. of Patients Affected");

        txtPatientDeathsIfAny.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtPatientDeathsIfAny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientDeathsIfAnyActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Safety issue report work list:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMessage)
                                        .addGap(47, 47, 47)
                                        .addComponent(txtDescription))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBatchId)
                                            .addComponent(txtVaccineName))))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPatientsAffected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtVaccineManufacturer)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(47, 47, 47)
                                        .addComponent(txtPatientDeathsIfAny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(172, 172, 172)
                        .addComponent(btnSendSafetyIssueReport)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel7, jLabel8, lblMessage, txtBatchId, txtDescription, txtPatientDeathsIfAny, txtPatientsAffected, txtVaccineManufacturer, txtVaccineName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMessage)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txtPatientDeathsIfAny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVaccineManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatientsAffected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSendSafetyIssueReport)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel7, jLabel8, lblMessage, txtBatchId, txtDescription, txtPatientDeathsIfAny, txtPatientsAffected, txtVaccineManufacturer, txtVaccineName});

    }// </editor-fold>//GEN-END:initComponents
    /**
     * Action listener to refresh the request table when the refresh button is
     * clicked.
     */
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        populateRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * Action listener to send a safety issue report when the send report button
     * is clicked.
     */
    private void btnSendSafetyIssueReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendSafetyIssueReportActionPerformed

        String description = txtDescription.getText();
        if ( description.equals("") || description.isEmpty() ) {
            JOptionPane.showMessageDialog(null , "Please enter something to send.");
            return;
        }

        String vaccineName = txtVaccineName.getText();
        String manufacturer = txtVaccineManufacturer.getText();
        String batchId = txtBatchId.getText();

        int patientsAffected;
        int noOfDeaths;
        try {
            patientsAffected = Integer.parseInt(txtPatientsAffected.getText());
            noOfDeaths = Integer.parseInt(txtPatientDeathsIfAny.getText());

        } catch ( NumberFormatException e ) {
            JOptionPane.showMessageDialog(null , "Please enter a valid number for patients affected and deaths.");
            return;
        }


        AdverseEventTrackingWorkRequest request = new AdverseEventTrackingWorkRequest();
        request.getAdverseEventTracking().setDescription(description);
        request.getAdverseEventTracking().setVaccineName(vaccineName);
        request.getAdverseEventTracking().setManufacturer(manufacturer);
        request.getAdverseEventTracking().setBatchId(batchId);
        request.getAdverseEventTracking().setAffectedPeople(patientsAffected);
        request.getAdverseEventTracking().setDeaths(noOfDeaths);
        request.setRequestSender(employeeUserAccount);
        request.setStatus("Sent");

        for ( UserAccount cdcAdverseEventHandlerUserAccount : participatingOrganization.getUserAccountDirectory().getListOfUserAccounts() ) {
            OrganizationEmployeeRole adverseEventHandler = participatingOrganization.getSpecificRole(OrganizationEmployeeRole.OrganizationEmployeeRoleType.CDC_ADVERSE_EVENT_HANDLER);
            if ( cdcAdverseEventHandlerUserAccount.getOrganizationEmployeeRole().equals(adverseEventHandler) ) {
                request.setRequestReceiver(cdcAdverseEventHandlerUserAccount);
                break; // Optionally, you can break out of the loop if you've found the reviewer
            }
        }

        // Finding the appropriate cdc to send the request
        NvdsParticipatingOrganization cdc = null;
        for ( NvdsParticipatingOrganization organizationRecieveingAdverseEventsReport : nvds.getParticipatingOrganizations().getListOfParticipatingOrganizations() ) {
            if ( organizationRecieveingAdverseEventsReport instanceof CDC ) {
                cdc = organizationRecieveingAdverseEventsReport;
                break;
            }
        }
        if ( cdc != null ) {
            cdc.getOrganizationWorkQueue().getListOfWorkRequests().add(request);
            employeeUserAccount.getWorkQueue().getListOfWorkRequests().add(request);
        }
        // Display description
        JOptionPane.showMessageDialog(null , "Request sent");

        // Set texts
        txtDescription.setText("");
        txtBatchId.setText("MMyy-XXX-0000");
        txtDescription.setText("");
        txtPatientDeathsIfAny.setText("");
        txtPatientsAffected.setText("");
        txtVaccineManufacturer.setText("");
        txtVaccineName.setText("");
    }//GEN-LAST:event_btnSendSafetyIssueReportActionPerformed

    private void txtVaccineManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineManufacturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVaccineManufacturerActionPerformed

    private void txtPatientsAffectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientsAffectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientsAffectedActionPerformed

    private void txtPatientDeathsIfAnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientDeathsIfAnyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientDeathsIfAnyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
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
