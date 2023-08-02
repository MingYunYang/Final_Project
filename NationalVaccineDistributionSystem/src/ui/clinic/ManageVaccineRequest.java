/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import model.workqueue.ClinicReviewRequest;
import model.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Ecosystem ecosystem;
    UserAccount userAccount;
    Organization organization;
    
    public ManageVaccineRequest(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Ecosystem ecosystem) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateRequestList();
    }
    
    private void populateRequestList(){
        
        DefaultTableModel model = (DefaultTableModel) tblRequestList.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getRole().getWorkQueue().getListOfWorkRequests()){
            Object[] row = new Object[7];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request.getVaccine().getName();
            row[2] = request.getRequestQuantity();
            row[3] = request.getSender();
            row[4] = request.getReceiver();
            row[5] = request.getStatus();
            
            String result = ((ClinicReviewRequest) request).getResult();
            row[6] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRequestList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequestList = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        lblInventoryWorkQueue = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventoryWorkQueue = new javax.swing.JTable();

        lblRequestList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestList.setText("Request List");

        tblRequestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Recipient", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRequestList);

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

        btnProcess.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryWorkQueue.setText("Request Work Queue");

        tblInventoryWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Recipient", "Status", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblInventoryWorkQueue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInventoryWorkQueue)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssignToMe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRequestList)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAssignToMe, btnProcess});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblRequestList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcess)
                    .addComponent(btnAssignToMe))
                .addGap(18, 18, 18)
                .addComponent(lblInventoryWorkQueue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

    }//GEN-LAST:event_btnAssignToMeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProcess;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblInventoryWorkQueue;
    private javax.swing.JLabel lblRequestList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblInventoryWorkQueue;
    private javax.swing.JTable tblRequestList;
    // End of variables declaration//GEN-END:variables
}
