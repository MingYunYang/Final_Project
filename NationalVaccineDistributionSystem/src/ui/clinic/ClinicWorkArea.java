package ui.clinic;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import model.role.Role;
import model.role.Role.RoleType;

public class ClinicWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Ecosystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public ClinicWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Ecosystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateAvailableButton();
    }

    private void populateAvailableButton(){
        
        Role role = userAccount.getRole();
        if(role.type == RoleType.Doctor_Role){
            btnManageVaccineInventory.setEnabled(false);
            btnManageVaccineRequest.setEnabled(false);
        } else if (role.type == RoleType.Inventory_Role){
            btnOpenClinic.setEnabled(false);
            btnManageVaccineRequest.setEnabled(false);
            btnReportSafetyIssue.setEnabled(false);
        } else if (role.type == RoleType.Review_Role){
            btnOpenClinic.setEnabled(false);
            btnReportSafetyIssue.setEnabled(false);
            btnManageVaccineInventory.setEnabled(false);
        } else {
            btnOpenClinic.setEnabled(false);
            btnManageVaccineInventory.setEnabled(false);
            btnManageVaccineRequest.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageVaccineRequest = new javax.swing.JButton();
        btnOpenClinic = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        btnManageVaccineInventory = new javax.swing.JButton();
        btnReportSafetyIssue = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnManageVaccineRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnManageVaccineRequest.setText("Manage Vaccine Request");
        btnManageVaccineRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineRequestActionPerformed(evt);
            }
        });

        btnOpenClinic.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnOpenClinic.setText("Open Clinic");
        btnOpenClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenClinicActionPerformed(evt);
            }
        });

        lblQuestion.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("What would you like to do today?");

        btnManageVaccineInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnManageVaccineInventory.setText("Manage Vaccine Inventory");
        btnManageVaccineInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineInventoryActionPerformed(evt);
            }
        });

        btnReportSafetyIssue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnReportSafetyIssue.setText("Report Safety Issue");
        btnReportSafetyIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportSafetyIssueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageVaccineRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpenClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageVaccineInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportSafetyIssue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblQuestion)
                .addGap(27, 27, 27)
                .addComponent(btnOpenClinic)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineInventory)
                .addGap(18, 18, 18)
                .addComponent(btnManageVaccineRequest)
                .addGap(18, 18, 18)
                .addComponent(btnReportSafetyIssue)
                .addContainerGap(270, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineRequestActionPerformed

        ManageVaccineRequest mvr = new ManageVaccineRequest(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("ManageClinicRequestReview", mvr);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineRequestActionPerformed

    private void btnOpenClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenClinicActionPerformed

        OpenClinic oc = new OpenClinic(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("OpenClinic", oc);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnOpenClinicActionPerformed

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed
        
        ManageClinicVaccineInventory mcvi = new ManageClinicVaccineInventory(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("ManageClinicVaccineInventory", mcvi);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed

    private void btnReportSafetyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportSafetyIssueActionPerformed
        
        ReportSafetyIssue rsi = new ReportSafetyIssue(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("ReportSafetyIssue", rsi);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnReportSafetyIssueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageVaccineInventory;
    private javax.swing.JButton btnManageVaccineRequest;
    private javax.swing.JButton btnOpenClinic;
    private javax.swing.JButton btnReportSafetyIssue;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
