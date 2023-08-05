package nvds.ui.admin;

import nvds.NationalVaccineDistributionSystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class AdminWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;

    public AdminWorkArea(JPanel userProcessContainer, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageUserAccountJPanel = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        manageUserAccountJPanel.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        manageUserAccountJPanel.setText("Manage Users");
        manageUserAccountJPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserAccountJPanelActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        manageEmployeeJButton.setText("Manage Employees");
        manageEmployeeJButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                manageEmployeeJButtonAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        manageOrganizationJButton.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        manageOrganizationJButton.setText("Manage Organizations");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
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
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageUserAccountJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageOrganizationJButton)))
                    .addComponent(lblQuestion))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {manageEmployeeJButton, manageOrganizationJButton, manageUserAccountJPanel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(lblQuestion)
                .addGap(31, 31, 31)
                .addComponent(manageOrganizationJButton)
                .addGap(38, 38, 38)
                .addComponent(manageEmployeeJButton)
                .addGap(41, 41, 41)
                .addComponent(manageUserAccountJPanel)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblQuestion, manageEmployeeJButton, manageOrganizationJButton, manageUserAccountJPanel});

    }// </editor-fold>//GEN-END:initComponents

    private void manageUserAccountJPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserAccountJPanelActionPerformed
        
        ManageUserAccount muajp = new ManageUserAccount(userProcessContainer, ecosystem.getParticipatingOrganizations(), ecosystem);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageUserAccountJPanelActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployee manageEmployeeJPanel = new ManageEmployee(userProcessContainer, ecosystem.getParticipatingOrganizations(), ecosystem);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganization manageOrganizationJPanel = new ManageOrganization(userProcessContainer, ecosystem.getParticipatingOrganizations(), ecosystem);
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageEmployeeJButtonAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonAncestorMoved
        
    }//GEN-LAST:event_manageEmployeeJButtonAncestorMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton manageUserAccountJPanel;
    // End of variables declaration//GEN-END:variables

}
