package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.workqueue.AdverseEventTrackingRequest;
import nvds.workqueue.WorkRequest;

/**
 * @author libby
 * @author mutara
 */
public class ManageAdverseEvents extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public ManageAdverseEvents(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
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
                    Object[] row = new Object[ 10 ];
                    row[ 0 ] = ((AdverseEventTrackingRequest) request);
                    row[ 1 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getVaccine().getName();
                    row[ 2 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getDescription();
                    row[ 3 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getPeopleAffected();
                    row[ 4 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getBatchId();
                    row[ 5 ] = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getManufacturer();
                    row[ 6 ] = request.getSender();
                    row[ 7 ] = request.getReceiver();
                    String recallStatus = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getRecallStatus();
                    row[ 8 ] = ((recallStatus == null) ? "Waiting" : recallStatus);
                    String recallReason = ((AdverseEventTrackingRequest) request).getAdverseEventTracking().getRecallReason();
                    row[ 9 ] = ((recallReason == null) ? "Waiting" : recallReason);
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
        btnBack = new javax.swing.JButton();

        tblReceivedWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Event ID", "Vaccine", "Description", "Affected Patient", "Batch ID", "Manufacturer", "Sender", "Reciever", "Recall Status", "Recall Reason"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReceivedWorkRequests);

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setText("Incoming Adverse Events:");

        btnAssign.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnRecall.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnRecall.setText("Recall");
        btnRecall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecallActionPerformed(evt);
            }
        });

        btnNoRecall.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnNoRecall.setText("No Recall");
        btnNoRecall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoRecallActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRecall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNoRecall)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNoRecall, btnRecall});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign)
                    .addComponent(btnNoRecall)
                    .addComponent(btnRecall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(205, 205, 205))
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNoRecall;
    private javax.swing.JButton btnRecall;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReceivedWorkRequests;
    // End of variables declaration//GEN-END:variables
}
