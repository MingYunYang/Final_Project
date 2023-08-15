/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.workqueue.ReviewRequest;
import nvds.workqueue.WorkRequest;

/**
 * @author libby
 * @author mutara
 */
public class ManageVaccineRequests extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManageVaccineRequests(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }
    
    public void populateMainWorkQueue () {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineRequestList.getModel();
        model.setRowCount( 0 );

        for ( WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests() ) {
            if ( request instanceof ReviewRequest reviewRequest ) {
                Object[] row = new Object[ 8 ];

                row[ 0 ] = reviewRequest.getVaccine().getVaccineId();
                row[ 1 ] = reviewRequest;
                row[ 2 ] = reviewRequest.getAvailableQuantity();
                row[ 3 ] = reviewRequest.getRequestQuantity();
                row[ 4 ] = reviewRequest.getPhdReviewer();
                row[ 5 ] = reviewRequest.getCdcReviewer();
                row[ 6 ] = reviewRequest.getStatus();

                String result = (( ReviewRequest ) request).getResult();
                row[ 7 ] = ((result == null) ? "Waiting" : result);

                model.addRow( row );
            }
        }
    }

    public void populateWaitingWorkQueue () {

        DefaultTableModel model = ( DefaultTableModel ) tblRequestWaitingToBeReviewed.getModel();
        model.setRowCount( 0 );

        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests() ) {
            if ( request instanceof ReviewRequest reviewRequest ) {
                Object[] row = new Object[ 8 ];
                row[ 0 ] = reviewRequest.getVaccine().getVaccineId();
                row[ 1 ] = reviewRequest;
                row[ 2 ] = reviewRequest.getAvailableQuantity();
                row[ 3 ] = reviewRequest.getRequestQuantity();
                row[ 4 ] = reviewRequest.getCdcReviewer();
                row[ 5 ] = reviewRequest.getStatus();
                row[ 6 ] = reviewRequest.getClinicReviewer(); //!!!!!

                String result = (( ReviewRequest ) request).getResult();
                row[ 7 ] = ((result == null) ? "Waiting" : result);

                model.addRow( row );
            }
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRejected = new javax.swing.JButton();
        btnApproved = new javax.swing.JButton();
        lblRequestList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineRequestList = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        lblRequestWaitingToBeReviewed = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequestWaitingToBeReviewed = new javax.swing.JTable();
        btnCheckAllocationDetails = new javax.swing.JButton();

        btnRejected.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnRejected.setText("Rejected");
        btnRejected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectedActionPerformed(evt);
            }
        });

        btnApproved.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnApproved.setText("Approved");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
            }
        });

        lblRequestList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestList.setText("CDC Review Request List:");

        tblVaccineRequestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Avail. Qty", "Req. Qty", "Sender", "Recipient", "Req. Status", "Req. Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineRequestList);

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Request ");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssignToMe.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });

        lblRequestWaitingToBeReviewed.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestWaitingToBeReviewed.setText("Request Waiting To Be Reviewed:");

        tblRequestWaitingToBeReviewed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Avail. Qty", "Req. Qty", "Reviewer", "Req. Status", "Recipient", "Req. Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRequestWaitingToBeReviewed);

        btnCheckAllocationDetails.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCheckAllocationDetails.setText("Check Allocation Details");
        btnCheckAllocationDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckAllocationDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRequestWaitingToBeReviewed)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignToMe)
                    .addComponent(lblRequestList)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckAllocationDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApproved, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblRequestList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssignToMe)
                .addGap(18, 18, 18)
                .addComponent(lblRequestWaitingToBeReviewed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproved)
                    .addComponent(btnRejected)
                    .addComponent(btnCheckAllocationDetails))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if ( selectedRow >= 0 ) {
            ReviewRequest request = ( ReviewRequest ) tblRequestWaitingToBeReviewed.getValueAt( selectedRow, 1 );
            request.setStatus( "Completed" );
            request.setResult( "Rejected" );

            JOptionPane.showMessageDialog( this, "Rejected review result sent back to clinic" );
            populateMainWorkQueue();
            populateWaitingWorkQueue();
        } else {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
    }//GEN-LAST:event_btnRejectedActionPerformed

    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if ( selectedRow < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
        ReviewRequest reviewRequest = ( ReviewRequest ) tblRequestWaitingToBeReviewed.getValueAt( selectedRow, 1 );
        reviewRequest.setStatus("Completed");
        reviewRequest.setResult("Approved");

        JOptionPane.showMessageDialog(this, "Result sent back to clinic successfully");
        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }//GEN-LAST:event_btnApprovedActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

        int selectedRow = tblVaccineRequestList.getSelectedRow();
        if ( selectedRow >= 0 ) {
            WorkRequest request = ( WorkRequest ) tblVaccineRequestList.getValueAt( selectedRow, 1 );
            if ( request.getStatus().equalsIgnoreCase( "Completed" ) ) {
                JOptionPane.showMessageDialog( this, "Request already completed" );
                return;
            } else {
                userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add( request );
                request.setCdcReviewer(userAccount);
                request.setStatus( "Under CDC Review" );
                JOptionPane.showMessageDialog( this, "Request successfully assigned to you" );
                populateMainWorkQueue();
                populateWaitingWorkQueue();
            }

        } else {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnCheckAllocationDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckAllocationDetailsActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row first");
            return;
        }

        ReviewRequest reviewRequest = (ReviewRequest) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);
        Batch batch = reviewRequest.getBatch();

        AllocateVaccine av = new AllocateVaccine( userProcessContainer, userAccount, organization, nvds, batch);
        userProcessContainer.add( "AllocateVaccine", av);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next( userProcessContainer );
    }//GEN-LAST:event_btnCheckAllocationDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckAllocationDetails;
    private javax.swing.JButton btnRejected;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblRequestList;
    private javax.swing.JLabel lblRequestWaitingToBeReviewed;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRequestWaitingToBeReviewed;
    private javax.swing.JTable tblVaccineRequestList;
    // End of variables declaration//GEN-END:variables
}
