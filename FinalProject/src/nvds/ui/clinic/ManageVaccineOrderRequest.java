package nvds.ui.clinic;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.Hospital;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.Useraccount.UserAccount;
import nvds.WorkQueue.ReviewVaccineOrderRequestResult;
import nvds.WorkQueue.WorkRequest;

public class ManageVaccineOrderRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount employeeUserAccount;
    NvdsParticipatingOrganization participatingOrganization;
    
    public ManageVaccineOrderRequest(JPanel userProcessContainer, UserAccount employeeUserAccount, NvdsParticipatingOrganization participatingOrganization, NationalVaccineDistributionSystem nvds) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.employeeUserAccount = employeeUserAccount;
        this.participatingOrganization = participatingOrganization;
        
        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }
    
    public void populateMainWorkQueue(){
        
        DefaultTableModel model = (DefaultTableModel) tblReceivedVaccineRequest.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : employeeUserAccount.getOrganizationEmployeeRole().getIncomingVaccineOrderRequestsWorkQueue().getListOfWorkRequests()){
            Object[] row = new Object[7];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request;
            row[2] = request.getRequestQuantity();
            row[3] = request.getRequestSender();
            row[4] = request.getRequestReviewer();
            row[5] = request.getVaccineRequestStatus();
            
            String result = ((ReviewVaccineOrderRequestResult) request).getReviewResult();
            row[6] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);
        }
    }
    
    public void populateWaitingWorkQueue(){
        
        DefaultTableModel model = (DefaultTableModel) tblRequestWaitingToBeReviewed.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : employeeUserAccount.getOrganizationEmployeeRole().getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue().getListOfWorkRequests()){
  
            Object[] row = new Object[8];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request;
            row[2] = request.getRequestQuantity();
            row[3] = request.getRequestSender();
            row[4] = request.getRequestReviewer();
            row[5] = request.getVaccineRequestStatus();
            row[6] = request.getRequestReceiver();
            
            String result = ((ReviewVaccineOrderRequestResult) request).getReviewResult();
            row[7] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);  
        }
    }

    @SuppressWarnings("unchecked")
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
        lblReceivedVaccineRequest.setText("Incoming Vaccine Request:");

        tblReceivedVaccineRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Order Qty", "Request Sender", "Request Reciever", "Request Status", "Review Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReceivedVaccineRequest);
        if (tblReceivedVaccineRequest.getColumnModel().getColumnCount() > 0) {
            tblReceivedVaccineRequest.getColumnModel().getColumn(0).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(1).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(2).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(3).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(4).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblReceivedVaccineRequest.getColumnModel().getColumn(5).setResizable(false);
            tblReceivedVaccineRequest.getColumnModel().getColumn(6).setResizable(false);
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
        btnApproved.setText("Approve");
        btnApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprovedActionPerformed(evt);
            }
        });

        lblRequestWaitingToBeReviewed.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestWaitingToBeReviewed.setText("Vaccine requests currently under review:");

        tblRequestWaitingToBeReviewed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Order Qty", "Request Sender", "Request Reviewer", "Request Status", "Hospital Reviewer", "Review Result"
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
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(0).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(1).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(2).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(3).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(4).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(5).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(6).setResizable(false);
            tblRequestWaitingToBeReviewed.getColumnModel().getColumn(7).setResizable(false);
        }

        btnRejected.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnRejected.setText("Reject");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblReceivedVaccineRequest)
                                .addComponent(btnAssignToMe)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRequestWaitingToBeReviewed)
                                            .addComponent(lblTitle))
                                        .addGap(394, 394, 394))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnApproved, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRejected)
                    .addComponent(btnApproved))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprovedActionPerformed
        
        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this,"Please select a request from the table first");
            return;
        }
        WorkRequest request = (WorkRequest) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);
        
        // push the request to affiliate hospital's inventory role's work queue
        Hospital affiliateHospital = participatingOrganization.getOrganizationCity().getAffiliateHospital();
        OrganizationEmployeeRole inventoryRole = affiliateHospital.getSpecificRole(OrganizationEmployeeRole.OrganizationEmployeeRoleType.VACCINE_INVENTORY_MANAGER);

        if (inventoryRole != null) {
            inventoryRole.getIncomingVaccineOrderRequestsWorkQueue().getListOfWorkRequests().add(request);
            request.setVaccineOrderRequestStatus("Process to Hospital");
        } else {
            JOptionPane.showMessageDialog(this, "There's no service in affiliate hospital now");
            return;
        }

        JOptionPane.showMessageDialog(this, "Request sent to affiliate hospital successfully");
        
        populateMainWorkQueue();
        populateWaitingWorkQueue();
    }//GEN-LAST:event_btnApprovedActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

        int selectedRow = tblReceivedVaccineRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblReceivedVaccineRequest.getValueAt(selectedRow, 1);
            if (request.getVaccineRequestStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(this, "Request already completed");
                return;
            } else {
                employeeUserAccount.getOrganizationEmployeeRole().getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue().getListOfWorkRequests().add(request);
                request.setRequestReviewer(employeeUserAccount);
                request.setVaccineOrderRequestStatus("Under Clinic Review");
                JOptionPane.showMessageDialog(this, "Request successfully assigned to you");
                populateMainWorkQueue();
                populateWaitingWorkQueue();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
            return;
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed
        
        int selectedRow = tblRequestWaitingToBeReviewed.getSelectedRow();
        if (selectedRow >= 0) {
            ReviewVaccineOrderRequestResult request = (ReviewVaccineOrderRequestResult) tblRequestWaitingToBeReviewed.getValueAt(selectedRow, 1);
            request.setVaccineOrderRequestStatus("Completed");
            request.setReviewResult("Rejected");
            JOptionPane.showMessageDialog(this, "Review send successfully");
            populateMainWorkQueue();
            populateWaitingWorkQueue();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request from the table first");
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
