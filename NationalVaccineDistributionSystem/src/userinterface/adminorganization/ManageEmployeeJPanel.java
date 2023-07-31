package userinterface.adminorganization;

import ecosystem.Ecosystem;
import ecosystem.employee.Employee;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.organization.Organization;
import ecosystem.organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ManageEmployeeJPanel extends javax.swing.JPanel {

    OrganizationDirectory organizationDirectory;

    JPanel userProcessContainer;

    Ecosystem ecosystem;

    public ManageEmployeeJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, Ecosystem ecosystem) {

        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.ecosystem = ecosystem;

        populateCountryCombo();

        Country selectedCountry = (Country) cmbCountry.getSelectedItem();

        if (selectedCountry != null) {
            populateStateCombo(selectedCountry);
            populateOrganizationCombo();
        }

        Organization selectedOrganization = (Organization) cmbOrganization.getSelectedItem();

        if (selectedOrganization != null) {
            populateTable(selectedOrganization);
        }
    }

    private void populateCountryCombo() {

        cmbCountry.removeAllItems();

        for (Country country : ecosystem.getListOfCountries()) {
            cmbCountry.addItem(country);
        }
    }

    private void populateStateCombo(Country country) {

        cmbState.removeAllItems();

        for (State state : country.getStateList()) {
            cmbState.addItem(state);
        }
    }

    private void populateOrganizationCombo() {

        Country country = (Country) cmbCountry.getSelectedItem();

        State state = (State) cmbState.getSelectedItem();

        cmbOrganization.removeAllItems();

        for (Organization organization : organizationDirectory.getListOfOrganizations()) {

            if (organization.getCountry().getCountryName().equals(country.getCountryName())
                    && organization.getState().getStateName().equals(state.getStateName())) {

                cmbOrganization.addItem(organization);
            }

        }
    }

    private void populateTable(Organization organization) {

        DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();

        model.setRowCount(0);

        for (Employee employee : organization.getEmployeeDirectory().getListOfEmployees()) {

            Object[] row = new Object[2];
            row[0] = employee.getEmployeeID();
            row[1] = employee.getEmployeeName();
            model.addRow(row);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblOrganization = new javax.swing.JLabel();
        cmbOrganization = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        lblEmployeeList = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        btnCreateEmployee = new javax.swing.JButton();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        cmbCountry = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Employees");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblOrganization.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganization.setText("Organization:");

        cmbOrganization.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        tblEmployees.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEmployees.getColumnModel().getColumn(0).setMaxWidth(50);
            tblEmployees.getColumnModel().getColumn(1).setResizable(false);
        }

        lblEmployeeList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeList.setText("Employee List:");

        lblEmployeeName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeName.setText("Employee Name");

        txtEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeNameActionPerformed(evt);
            }
        });

        btnCreateEmployee.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCreateEmployee.setText("Create Employee");
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        lblState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblState.setText("State:");

        cmbState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        cmbCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        lblCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCountry.setText("Country:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCountry)
                                .addComponent(btnBack))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmployeeList)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCreateEmployee))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblOrganization)
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEmployeeName)
                                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(53, 53, 53))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbCountry, cmbOrganization});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrganization)
                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeList)
                    .addComponent(btnCreateEmployee))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed

        Organization organization = (Organization) cmbOrganization.getSelectedItem();

        String name = txtEmployeeName.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        organization.getEmployeeDirectory().addEmployee(name);

        txtEmployeeName.setText("");

        populateTable(organization);

        evt.getWhen();

    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed

        Organization organization = (Organization) cmbOrganization.getSelectedItem();

        if (organization != null) {
            populateTable(organization);
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        State selectedState = (State) cmbState.getSelectedItem();

        if (selectedState != null) {
            populateOrganizationCombo();
        }

        Organization o = (Organization) cmbOrganization.getSelectedItem();

        populateTable(o);

        evt.getWhen();

    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country selectedCountry = (Country) cmbCountry.getSelectedItem();

        if (selectedCountry != null) {
            populateStateCombo(selectedCountry);
            populateOrganizationCombo();
        }

        Organization o = (Organization) cmbOrganization.getSelectedItem();

        populateTable(o);

        evt.getWhen();

    }//GEN-LAST:event_cmbCountryActionPerformed

    private void txtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtEmployeeName;
    // End of variables declaration//GEN-END:variables
}
