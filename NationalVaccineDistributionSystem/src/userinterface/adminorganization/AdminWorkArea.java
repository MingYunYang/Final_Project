package userinterface.adminorganization;

import ecosystem.Ecosystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Ecosystem ecosystem;

    public AdminWorkArea(JPanel userProcessContainer, Ecosystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        userJButton.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        userJButton.setText("Manage Users");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        manageEmployeeJButton.setText("Manage Employees");
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
                .addGap(214, 214, 214)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageOrganizationJButton)))
                    .addComponent(lblQuestion))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {manageEmployeeJButton, manageOrganizationJButton, userJButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lblQuestion)
                .addGap(31, 31, 31)
                .addComponent(manageOrganizationJButton)
                .addGap(38, 38, 38)
                .addComponent(manageEmployeeJButton)
                .addGap(41, 41, 41)
                .addComponent(userJButton)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblQuestion, manageEmployeeJButton, manageOrganizationJButton, userJButton});

    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        
        ManageUserAccount muajp = new ManageUserAccount(userProcessContainer, ecosystem.getOrganizationDirectory(), ecosystem);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ManageEmployee manageEmployeeJPanel = new ManageEmployee(userProcessContainer, ecosystem.getOrganizationDirectory(), ecosystem);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageOrganization manageOrganizationJPanel = new ManageOrganization(userProcessContainer, ecosystem.getOrganizationDirectory(), ecosystem);
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton userJButton;
    // End of variables declaration//GEN-END:variables

}
