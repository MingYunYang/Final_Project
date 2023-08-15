/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.workqueue.ReviewRequest;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageClinicVaccineRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount userAccount;
    Organization organization;

    public ManageClinicVaccineRequest ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds ) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }

    public void populateMainWorkQueue () {

        DefaultTableModel model = ( DefaultTableModel ) tblReceivedVaccineRequest.getModel();
        model.setRowCount( 0 );

        for ( WorkRequest request : userAccount.getRole().getMainWorkQueue().getListOfWorkRequests() ) {
            if ( request instanceof ReviewRequest reviewRequest ) {
                Object[] row = new Object[ 8 ];

                row[ 0 ] = reviewRequest.getVaccine().getVaccineId();
                row[ 1 ] = reviewRequest;
                row[ 2 ] = reviewRequest.getAvailableQuantity();
                row[ 3 ] = reviewRequest.getRequestQuantity();
                row[ 4 ] = reviewRequest.getSender();
                row[ 5 ] = reviewRequest.getClinicReviewer();
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
                row[ 4 ] = reviewRequest.getClinicReviewer();
                row[ 5 ] = reviewRequest.getStatus();
                row[ 6 ] = reviewRequest.getHospitalReviewer();

                String result = (( ReviewRequest ) request).getResult();
                row[ 7 ] = ((result == null) ? "Waiting" : result);

                model.addRow( row );
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReceivedVaccineRequest = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceivedVaccineRequest = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        btnApproved = new javax.swing.JButton();
        lblRequestWaitingToBeReviewed = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequestWaitingToBeReviewed = new javax.swing.JTable();
        btnRejected = new javax.swing.JButton();

        lblReceivedVaccineRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblReceivedVaccineRequest.setText("Received Vaccine Request:");

        tblReceivedVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblReceivedVaccineRequest);
        if (tblReceivedVaccineRequest.getColumnModel().getColumnCount() > 0) {
            tblReceivedVaccineRequest.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

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

        btnApproved.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnApproved.setText("Approved");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
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
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRequestWaitingToBeReviewed);
        if (tblRequestWaitingToBeReviewed.getColumnModel().getColumnCount() > 0) {
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnRejected.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnRejected.setText("Rejected");
        btnRejected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnApproved, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRequestWaitingToBeReviewed)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReceivedVaccineRequest)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAssignToMe, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnApproved, btnAssignToMe});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblReceivedVaccineRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAssignToMe)
                .addGap(18, 18, 18)
                .addComponent(lblRequestWaitingToBeReviewed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproved)
                    .addComponent(btnRejected))
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove( this );
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if ( selectedRow < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
        WorkRequest request = ( WorkRequest ) tblRequestWaitingToBeReviewed.getValueAt( selectedRow, 1 );

        // push the request to affiliate hospital's inventory role's work queue
        Hospital affiliateHospital = organization.getCity().getAffiliatedHospital();
        Role vaccineRequestReviewerRole = affiliateHospital.getSpecificRole( Role.RoleType.VACCINE_REQUEST_REVIEWER );

        if ( vaccineRequestReviewerRole != null ) {
            vaccineRequestReviewerRole.getMainWorkQueue().getListOfWorkRequests().add( request );
            request.setStatus( "Approved By Clinic" );
        } else {
            JOptionPane.showMessageDialog( this, "There's no service in affiliate hospital now" );
            return;
        }

        JOptionPane.showMessageDialog( this, "Request sent to affiliate hospital successfully" );

        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }//GEN-LAST:event_btnApprovedActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

        int selectedRow = tblReceivedVaccineRequest.getSelectedRow();
        if ( selectedRow >= 0 ) {
            WorkRequest request = ( WorkRequest ) tblReceivedVaccineRequest.getValueAt( selectedRow, 1 );
            if ( request.getStatus().equalsIgnoreCase( "Completed" ) ) {
                JOptionPane.showMessageDialog( this, "Request already completed" );
                return;
            } else {
                userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add( request );
                request.setClinicReviewer( userAccount );
                request.setStatus( "Under Clinic Review" );
                JOptionPane.showMessageDialog( this, "Request successfully assigned to you" );
                populateMainWorkQueue();
                populateWaitingWorkQueue();
            }

        } else {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed

        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if ( selectedRow >= 0 ) {
            ReviewRequest request = ( ReviewRequest ) tblRequestWaitingToBeReviewed.getValueAt( selectedRow, 1 );
            request.setStatus( "Completed" );
            request.setResult( "Rejected" );
            JOptionPane.showMessageDialog( this, "Review send successfully" );
            populateMainWorkQueue();
            populateWaitingWorkQueue();
        } else {
            JOptionPane.showMessageDialog( this, "Please select a request from the table first" );
            return;
        }
    }//GEN-LAST:event_btnRejectedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproved;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRejected;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblReceivedVaccineRequest;
    private javax.swing.JLabel lblRequestWaitingToBeReviewed;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReceivedVaccineRequest;
    private javax.swing.JTable tblRequestWaitingToBeReviewed;
    // End of variables declaration//GEN-END:variables
}
