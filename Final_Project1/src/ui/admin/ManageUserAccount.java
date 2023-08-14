/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.admin;

import nvds.NationalVaccineDistributionSystem;
import nvds.employee.Employee;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.organization.Organization;
import nvds.organization.OrganizationDirectory;
import nvds.role.Role;
import nvds.useraccount.UserAccountDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ManageUserAccount extends javax.swing.JPanel {

    private OrganizationDirectory organizationDirectory;
    private JPanel userProcessContainer;
    private NationalVaccineDistributionSystem ecosystem;

    public ManageUserAccount(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, NationalVaccineDistributionSystem ecosystem) {
        
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.ecosystem = ecosystem;

        populateCountryCombo();
        Country country = (Country)cmbCountry.getSelectedItem();
        if(country != null){
            populateStateCombo(country);
            State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateOrganizationTypeCombo();
                Organization.Type type = (Organization.Type)cmbOrganizationType.getSelectedItem();
                if(type != null){
                    populateOrganizationCombo(country, state, type);
                    Organization organization = (Organization)cmbOrganization.getSelectedItem();
                    if(organization != null){
                        populateRoleTypeCombo(organization);
                        populateTable(organization);
                    }
                }
            }
        }  
    }
    
    public void populateCountryCombo(){
        
        cmbCountry.removeAllItems();
        for(Country country : ecosystem.getCountryList()){
            cmbCountry.addItem(country);
        }
    }
    
    public void populateStateCombo(Country country){
        
        cmbState.removeAllItems();
        for(State state : country.getStateList()){
            cmbState.addItem(state);
        }
    }
    
    public void populateOrganizationTypeCombo(){
                
        cmbOrganizationType.removeAllItems();
        for(Organization.Type type : Organization.Type.values()){
            cmbOrganizationType.addItem(type);
        }
    }
    
    public void populateOrganizationCombo(Country country, State state, Organization.Type type){
        
        cmbOrganization.removeAllItems();
        for (Organization organization : organizationDirectory.getListOfOrganizations()){
            if(organization.getCountry().equals(country) 
               && organization.getState().equals(state)
               && organization.getType().equals(type)){
               
               cmbOrganization.addItem(organization); 
            }
        }
    }
    
    private void populateRoleTypeCombo(Organization organization){
        
        cmbRoleType.removeAllItems();
        for(Role role : organization.getSupportedRole()){
            cmbRoleType.addItem(role);
        }
    }
    
    private void populateTable(Organization organization){
        
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            Object[] row = new Object[3];
            row[0] = employee.getId();
            row[1] = employee;
            row[2] = employee.getUserAccount() != null ? employee.getUserAccount().getUsername() : "No account";
            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployeeList = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblEmployeeList = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        cmbState = new javax.swing.JComboBox();
        cmbCountry = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        cmbOrganizationType = new javax.swing.JComboBox();
        cmbOrganization = new javax.swing.JComboBox();
        lblOrganizationType = new javax.swing.JLabel();
        lblOrganization = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        lblGetEmployee = new javax.swing.JLabel();
        lblCreateUserAccount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblRoleType = new javax.swing.JLabel();
        cmbRoleType = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        tblEmployeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployeeList);
        if (tblEmployeeList.getColumnModel().getColumnCount() > 0) {
            tblEmployeeList.getColumnModel().getColumn(0).setResizable(false);
            tblEmployeeList.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEmployeeList.getColumnModel().getColumn(1).setResizable(false);
            tblEmployeeList.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblEmployeeList.getColumnModel().getColumn(2).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage User Accounts");

        lblEmployeeList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeList.setText("Employee List:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        lblCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCountry.setText("Country:");

        lblState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblState.setText("State:");

        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        lblOrganizationType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationType.setText("Organization Type:");

        lblOrganization.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganization.setText("Organization:");

        lblUserName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblUserName.setText("New Username:");

        btnCreate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblPassword.setText("New Password:");

        lblGetEmployee.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblGetEmployee.setText("Search Employee:");

        lblCreateUserAccount.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCreateUserAccount.setText("Create User Account:");

        lblRoleType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRoleType.setText("Role Type:");

        cmbRoleType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmployeeList)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCreateUserAccount)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOrganizationType)
                                .addComponent(lblOrganization)
                                .addComponent(lblState)
                                .addComponent(lblCountry)
                                .addComponent(lblGetEmployee))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblUserName)
                            .addComponent(lblRoleType))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreate)))
                    .addComponent(jSeparator1))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblGetEmployee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblState))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrganizationType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrganization))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCreateUserAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRoleType)
                            .addComponent(cmbRoleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUserName)))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEmployeeList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        int selectedIndex = tblEmployeeList.getSelectedRow();
        if(selectedIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select an employee from the table first");
            return;
        }

        Employee employee = (Employee)tblEmployeeList.getValueAt(selectedIndex, 1);

        String userName = txtUserName.getText();
        if(userName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please set a new username for the employee");
            return;
        }
        String password = txtPassword.getText();
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please set a new password for the employee");
            return;
        }

        Organization organization = (Organization)cmbOrganization.getSelectedItem();
        Role role = (Role)cmbRoleType.getSelectedItem();

        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();
        userAccountDirectory.createUserAccount(userName, password, employee, role);

        populateTable(organization);

        JOptionPane.showMessageDialog(this, "User account created successfully");

        txtUserName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        State state = (State) cmbState.getSelectedItem();

        if (state != null && country != null) {
            populateOrganizationTypeCombo();
            Organization.Type type = (Organization.Type) cmbOrganizationType.getSelectedItem();
            if (type != null) {
                populateOrganizationCombo(country, state, type);
                Organization organization = (Organization) cmbOrganization.getSelectedItem();
                if (organization != null) {
                    populateRoleTypeCombo(organization);
                    populateTable(organization);
                }  else {
                    DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
                    model.setRowCount(0);
                    cmbRoleType.removeAllItems();
                }
            }
        }
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbRoleTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleTypeActionPerformed

    }//GEN-LAST:event_cmbRoleTypeActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed

        Organization organization = (Organization)cmbOrganization.getSelectedItem();
        if(organization != null){
            populateRoleTypeCombo(organization);
            populateTable(organization);
        } else {
            DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
            model.setRowCount(0);
            cmbRoleType.removeAllItems();
        }
    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        State state = (State) cmbState.getSelectedItem();
        Organization.Type type = (Organization.Type)cmbOrganizationType.getSelectedItem();

        if(type != null){
            populateOrganizationCombo(country, state, type);
            Organization organization = (Organization)cmbOrganization.getSelectedItem();
            if(organization != null){
                populateRoleTypeCombo(organization);
                populateTable(organization);
            } else {
                DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
                model.setRowCount(0);
                cmbRoleType.removeAllItems();
            }
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        if(country != null){
            populateStateCombo(country);
            State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateOrganizationTypeCombo();
                Organization.Type type = (Organization.Type)cmbOrganizationType.getSelectedItem();
                if(type != null){
                    populateOrganizationCombo(country, state, type);
                    Organization organization = (Organization)cmbOrganization.getSelectedItem();
                    if(organization != null){
                        populateRoleTypeCombo(organization);
                        populateTable(organization);
                    }  else {
                        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
                        model.setRowCount(0);
                        cmbRoleType.removeAllItems();
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbCountryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbRoleType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCreateUserAccount;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblGetEmployee;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRoleType;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblEmployeeList;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}