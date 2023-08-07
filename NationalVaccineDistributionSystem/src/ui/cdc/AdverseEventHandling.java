package ui.cdc;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.workqueue.AdverseEventTrackingRequest;
import nvds.workqueue.WorkRequest;


public class AdverseEventHandling extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public AdverseEventHandling(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateMainWorkQueueTable();
    }

    public void populateMainWorkQueueTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblReceivedWorkRequests.getModel();
        model.setRowCount(0);
        
            for (WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests()) {
            if (request instanceof AdverseEventTrackingRequest) {
                    Object[] row = new Object[ 11 ];
                    row[ 0 ] = ((AdverseEventTrackingRequest) request);
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
    
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceivedWorkRequests = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        btnRecall = new javax.swing.JButton();
        btnNoRecall = new javax.swing.JButton();

        tblReceivedWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReceivedWorkRequests);

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Incomming adverse events for processing:");

        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnRecall.setText("Recall");
        btnRecall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecallActionPerformed(evt);
            }
        });

        btnNoRecall.setText("No Recall");
        btnNoRecall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoRecallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAssign)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRecall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNoRecall)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNoRecall, btnRecall});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign)
                    .addComponent(btnNoRecall)
                    .addComponent(btnRecall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

        int selectedRow = tblReceivedWorkRequests.getSelectedRow();

        if ( selectedRow >= 0 ) {
            AdverseEventTrackingRequest request = ( AdverseEventTrackingRequest ) tblReceivedWorkRequests.getValueAt(selectedRow , 0);
            if ( request.getStatus().equalsIgnoreCase("Completed") ) {
                JOptionPane.showMessageDialog(this , "Request already completed");
                return;
            } else {
                userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add(request);
                request.setReceiver(userAccount);
                request.getAdverseEventTracking().setRecallStatus("Investigating.");
                JOptionPane.showMessageDialog(this, "Request successfully assigned to you");
                populateMainWorkQueueTable();
            }

        } else {
            JOptionPane.showMessageDialog(this , "Please choose a reuest to process first");
            return;
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnRecallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecallActionPerformed
        
        int selectedRow = tblReceivedWorkRequests.getSelectedRow();
        if (selectedRow >= 0) {
            AdverseEventTrackingRequest request = (AdverseEventTrackingRequest) tblReceivedWorkRequests.getValueAt(selectedRow, 0);
            request.getAdverseEventTracking().setRecallStatus("Recalled");
            request.getAdverseEventTracking().setRecallReason("Defects found");
            JOptionPane.showMessageDialog(this, "Report send successfully");
            populateMainWorkQueueTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
            return;
        }
    }//GEN-LAST:event_btnRecallActionPerformed

    private void btnNoRecallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoRecallActionPerformed
        
        int selectedRow = tblReceivedWorkRequests.getSelectedRow();
        if (selectedRow >= 0) {
            AdverseEventTrackingRequest request = (AdverseEventTrackingRequest) tblReceivedWorkRequests.getValueAt(selectedRow, 0);
            request.getAdverseEventTracking().setRecallStatus("No Recall");
            request.getAdverseEventTracking().setRecallReason("No defects found");
            JOptionPane.showMessageDialog(this, "Report send successfully");
            populateMainWorkQueueTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
            return;
        }
    }//GEN-LAST:event_btnNoRecallActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnNoRecall;
    private javax.swing.JButton btnRecall;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReceivedWorkRequests;
    // End of variables declaration//GEN-END:variables
}
