/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nvds.ui.admin;

import nvds.NationalVaccineDistributionSystem;
import nvds.Employee.Employee;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Organization.NvdsParticipatingOrganizationsDirectory;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import nvds.Useraccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ManageUserAccount extends javax.swing.JPanel {

    private final NvdsParticipatingOrganizationsDirectory participatingOrganizationDirectory;

    private final JPanel userProcessContainer;

    private final NationalVaccineDistributionSystem nvds;

    public ManageUserAccount(JPanel userProcessContainer , NvdsParticipatingOrganizationsDirectory organizationDirectory , NationalVaccineDistributionSystem ecosystem) {

        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.participatingOrganizationDirectory = organizationDirectory;
        this.nvds = ecosystem;

        populateCountryCombo();
        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateOrganizationTypeCombo();
                NvdsParticipatingOrganization.OrganizationType type = ( NvdsParticipatingOrganization.OrganizationType ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateOrganizationCombo(country , state , type);
                    NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
                    if ( organization != null ) {
                        populateRoleTypeCombo(organization);
                        populateTable(organization);
                    }
                }
            }
        }
    }

    private void populateCountryCombo() {

        cmbCountry.removeAllItems();
        for ( Country country : nvds.getParticipatingCountries() ) {
            cmbCountry.addItem(country);
        }
    }

    private void populateStateCombo(Country country) {

        cmbState.removeAllItems();
        for ( State state : country.getlistOfStatesInParticipatingCountry() ) {
            cmbState.addItem(state);
        }
    }

    private void populateOrganizationTypeCombo() {

        cmbOrganizationType.removeAllItems();
        for ( NvdsParticipatingOrganization.OrganizationType type : NvdsParticipatingOrganization.OrganizationType.values() ) {
            cmbOrganizationType.addItem(type);
        }
    }

    private void populateOrganizationCombo(Country country , State state , NvdsParticipatingOrganization.OrganizationType type) {

        cmbOrganization.removeAllItems();
        for ( NvdsParticipatingOrganization organization : participatingOrganizationDirectory.getListOfParticipatingOrganizations() ) {
            if ( organization.getOrganizationCountry().equals(country)
                    && organization.getOrganizationState().equals(state)
                    && organization.getTypeOfOrganization().equals(type) ) {

                cmbOrganization.addItem(organization);
            }
        }
    }

    private void populateRoleTypeCombo(NvdsParticipatingOrganization organization) {

        cmbRoleType.removeAllItems();
        for ( OrganizationEmployeeRole role : organization.getOrganizationSupportedRole() ) {
            cmbRoleType.addItem(role);
        }
    }

    private void populateTable(NvdsParticipatingOrganization organization) {

        DefaultTableModel model = ( DefaultTableModel ) tblEmployeeList.getModel();
        model.setRowCount(0);

        for ( Employee employee : organization.getEmployeeDirectory().getListOfEmployees() ) {
            Object[] row = new Object[ 3 ];
            row[ 0 ] = employee.getEMPLOYEE_ID();
            row[ 1 ] = employee;
            row[ 2 ] = employee.getEmployeeUserAccount() != null ? employee.getEmployeeUserAccount().getUsername() : "No account";
            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings ( "unchecked" )
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

        setBackground(new java.awt.Color(255, 102, 102));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrganizationType)
                                    .addComponent(lblOrganization)
                                    .addComponent(lblState)
                                    .addComponent(lblCountry)
                                    .addComponent(lblGetEmployee)
                                    .addComponent(lblEmployeeList))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblTitle))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCreateUserAccount)
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
                                    .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGetEmployee)
                            .addComponent(lblCreateUserAccount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(lblOrganizationType)))
                            .addGroup(layout.createSequentialGroup()
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
                                        .addComponent(lblUserName)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrganization)
                            .addComponent(btnCreate)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmployeeList, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        State state = ( State ) cmbState.getSelectedItem();

        if ( state != null && country != null ) {
            populateOrganizationTypeCombo();
            NvdsParticipatingOrganization.OrganizationType type = ( NvdsParticipatingOrganization.OrganizationType ) cmbOrganizationType.getSelectedItem();
            if ( type != null ) {
                populateOrganizationCombo(country , state , type);
                NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
                if ( organization != null ) {
                    populateRoleTypeCombo(organization);
                    populateTable(organization);
                } else {
                    DefaultTableModel model = ( DefaultTableModel ) tblEmployeeList.getModel();
                    model.setRowCount(0);
                    cmbRoleType.removeAllItems();
                }
            }
        }
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateOrganizationTypeCombo();
                NvdsParticipatingOrganization.OrganizationType type = ( NvdsParticipatingOrganization.OrganizationType ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateOrganizationCombo(country , state , type);
                    NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
                    if ( organization != null ) {
                        populateRoleTypeCombo(organization);
                        populateTable(organization);
                    } else {
                        DefaultTableModel model = ( DefaultTableModel ) tblEmployeeList.getModel();
                        model.setRowCount(0);
                        cmbRoleType.removeAllItems();
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        State state = ( State ) cmbState.getSelectedItem();
        NvdsParticipatingOrganization.OrganizationType type = ( NvdsParticipatingOrganization.OrganizationType ) cmbOrganizationType.getSelectedItem();

        if ( type != null ) {
            populateOrganizationCombo(country , state , type);
            NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
            if ( organization != null ) {
                populateRoleTypeCombo(organization);
                populateTable(organization);
            } else {
                DefaultTableModel model = ( DefaultTableModel ) tblEmployeeList.getModel();
                model.setRowCount(0);
                cmbRoleType.removeAllItems();
            }
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed

        NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
        if ( organization != null ) {
            populateRoleTypeCombo(organization);
            populateTable(organization);
        } else {
            DefaultTableModel model = ( DefaultTableModel ) tblEmployeeList.getModel();
            model.setRowCount(0);
            cmbRoleType.removeAllItems();
        }
    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        int selectedIndex = tblEmployeeList.getSelectedRow();
        if ( selectedIndex < 0 ) {
            JOptionPane.showMessageDialog(this , "Please select an employee from the table first");
            return;
        }

        Employee employee = ( Employee ) tblEmployeeList.getValueAt(selectedIndex , 1);

        String userName = txtUserName.getText();
        if ( userName.isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Please set a new username for the employee");
            return;
        }
        String password = txtPassword.getText();
        if ( password.isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Please set a new password for the employee");
            return;
        }

        NvdsParticipatingOrganization organization = ( NvdsParticipatingOrganization ) cmbOrganization.getSelectedItem();
        OrganizationEmployeeRole role = ( OrganizationEmployeeRole ) cmbRoleType.getSelectedItem();

        UserAccountDirectory userAccountDirectory = organization.getUserAccountDirectory();
        userAccountDirectory.createUserAccount(userName , password , employee , role);

        populateTable(organization);

        JOptionPane.showMessageDialog(this , "User account created successfully");

        txtUserName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cmbRoleTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleTypeActionPerformed

    }//GEN-LAST:event_cmbRoleTypeActionPerformed

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
