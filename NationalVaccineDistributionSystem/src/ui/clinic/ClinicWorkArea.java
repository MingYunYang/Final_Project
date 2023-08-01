package ui.clinic;

import model.Ecosystem;
import model.organization.Organization;
import model.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageVaccineInventory = new javax.swing.JButton();
        btnManageClinic = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnManageVaccineInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnManageVaccineInventory.setText("Manage Vaccine Inventory");
        btnManageVaccineInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVaccineInventoryActionPerformed(evt);
            }
        });

        btnManageClinic.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnManageClinic.setText("Manage Clinic");
        btnManageClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageClinicActionPerformed(evt);
            }
        });

        lblQuestion.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("What would you like to do today?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageVaccineInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageClinic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(285, 285, 285))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(lblQuestion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(lblQuestion)
                .addGap(61, 61, 61)
                .addComponent(btnManageClinic)
                .addGap(41, 41, 41)
                .addComponent(btnManageVaccineInventory)
                .addContainerGap(318, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageVaccineInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVaccineInventoryActionPerformed

        ManageClinicVaccineInventory vi = new ManageClinicVaccineInventory(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("ManageClinicVaccineInventory", vi);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageVaccineInventoryActionPerformed

    private void btnManageClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageClinicActionPerformed

        ManageClinicWorkRequest mc = new ManageClinicWorkRequest(userProcessContainer, userAccount, organization, ecosystem);
        userProcessContainer.add("ManageClinicWorkRequest", mc);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageClinicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageClinic;
    private javax.swing.JButton btnManageVaccineInventory;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
