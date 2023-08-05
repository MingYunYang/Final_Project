package nvds.ui.admin;

import nvds.NationalVaccineDistributionSystem;
import nvds.Employee.Employee;
import nvds.Employee.EmployeeDirectory;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Organization.NvdsParticipatingOrganization.OrganizationType;
import nvds.Organization.NvdsParticipatingOrganizationsDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ManageEmployee extends javax.swing.JPanel {

    private final NvdsParticipatingOrganizationsDirectory participatingOrganizationsDirectory;

    private final JPanel userProcessContainer;

    private final NationalVaccineDistributionSystem nvds;

    public ManageEmployee(JPanel userProcessContainer , NvdsParticipatingOrganizationsDirectory organizationDirectory , NationalVaccineDistributionSystem nvds) {

        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.participatingOrganizationsDirectory = organizationDirectory;
        this.nvds = nvds;

        populateParticipatingCountriesComboBox();

        Country participatingCountry = ( Country ) cmbParticipatingCountries.getSelectedItem();
        if ( participatingCountry != null ) {
            populateStateComboBox(participatingCountry);
            State organizationState = ( State ) cmbState.getSelectedItem();
            if ( organizationState != null ) {
                populateParticipatingOrganizationTypeComboBox();
                OrganizationType participatingOrganizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
                if ( participatingOrganizationType != null ) {
                    populateOrganizationCombo(participatingCountry , organizationState , participatingOrganizationType);
                    NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
                    if ( participatingOrganization != null ) {
                        populateTable(participatingOrganization);
                    }
                }
            }
        }
    }

    private void populateParticipatingCountriesComboBox() {

        cmbParticipatingCountries.removeAllItems();
        for ( Country participatingCountry : nvds.getParticipatingCountries() ) {
            cmbParticipatingCountries.addItem(participatingCountry);
        }
    }

    private void populateStateComboBox(Country participatingCountry) {

        cmbState.removeAllItems();
        for ( State organizationState : participatingCountry.getlistOfStatesInParticipatingCountry() ) {
            cmbState.addItem(organizationState);
        }
    }

    private void populateParticipatingOrganizationTypeComboBox() {

        cmbOrganizationType.removeAllItems();
        for ( NvdsParticipatingOrganization.OrganizationType organizationType : NvdsParticipatingOrganization.OrganizationType.values() ) {
            cmbOrganizationType.addItem(organizationType);
        }
    }

    private void populateOrganizationCombo(Country participatingCountry , State organizationState , OrganizationType organizationType) {

        cmbParticipatingOrganizations.removeAllItems();
        for ( NvdsParticipatingOrganization participatingOrganization : participatingOrganizationsDirectory.getListOfParticipatingOrganizations() ) {
            if ( participatingOrganization.getOrganizationCountry().equals(participatingCountry)
                    && participatingOrganization.getOrganizationState().equals(organizationState)
                    && participatingOrganization.getTypeOfOrganization().equals(organizationType) ) {

                cmbParticipatingOrganizations.addItem(participatingOrganization);
            }
        }
    }

    private void populateTable(NvdsParticipatingOrganization participatingOrganization) {

        DefaultTableModel model = ( DefaultTableModel ) tblParticpatingOrganizationEmployees.getModel();
        model.setRowCount(0);

        for ( Employee participatingOrganizationEmployee : participatingOrganization.getEmployeeDirectory().getListOfEmployees() ) {
            Object[] row = new Object[ 2 ];
            row[ 0 ] = participatingOrganizationEmployee.getEMPLOYEE_ID();
            row[ 1 ] = participatingOrganizationEmployee.getOrganizationEmployeeName();
            model.addRow(row);
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblOrganization = new javax.swing.JLabel();
        cmbParticipatingOrganizations = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParticpatingOrganizationEmployees = new javax.swing.JTable();
        lblEmployeeList = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        btnCreateEmployee = new javax.swing.JButton();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        cmbParticipatingCountries = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();
        lblOrganizationType = new javax.swing.JLabel();
        cmbOrganizationType = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 102, 102));

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

        cmbParticipatingOrganizations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParticipatingOrganizationsActionPerformed(evt);
            }
        });

        tblParticpatingOrganizationEmployees.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblParticpatingOrganizationEmployees.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblParticpatingOrganizationEmployees);
        if (tblParticpatingOrganizationEmployees.getColumnModel().getColumnCount() > 0) {
            tblParticpatingOrganizationEmployees.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblParticpatingOrganizationEmployees.getColumnModel().getColumn(0).setMaxWidth(50);
            tblParticpatingOrganizationEmployees.getColumnModel().getColumn(1).setResizable(false);
        }

        lblEmployeeList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeList.setText("Employee List:");

        lblEmployeeName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeName.setText("Employee Name:");

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

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        cmbParticipatingCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParticipatingCountriesActionPerformed(evt);
            }
        });

        lblCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCountry.setText("Country:");

        lblOrganizationType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationType.setText("Organization Type:");

        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addGap(415, 415, 415)
                            .addComponent(btnBack))
                        .addComponent(lblEmployeeList)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOrganizationType)
                                .addComponent(lblCountry))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbParticipatingCountries, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblOrganization))
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbParticipatingOrganizations, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblEmployeeName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCreateEmployee))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState)
                    .addComponent(cmbParticipatingCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbParticipatingOrganizations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrganization)
                    .addComponent(lblOrganizationType)
                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEmployeeList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeName)
                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed

        NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
        EmployeeDirectory participatingOrganizationEmployeeDirectory = participatingOrganization.getEmployeeDirectory();
        String employeeName = txtEmployeeName.getText();

        if ( employeeName.isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Employee name cannot be empty" , "Warning" , JOptionPane.WARNING_MESSAGE);
            return;
        }

        participatingOrganizationEmployeeDirectory.addNewEmployee(employeeName);

        txtEmployeeName.setText("");
        populateTable(participatingOrganization);

        evt.getWhen();

    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbParticipatingOrganizationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParticipatingOrganizationsActionPerformed

        NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
        if ( participatingOrganization != null ) {
            populateTable(participatingOrganization);
        } else {
            DefaultTableModel model = ( DefaultTableModel ) tblParticpatingOrganizationEmployees.getModel();
            model.setRowCount(0);
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbParticipatingOrganizationsActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country participatingCountry = ( Country ) cmbParticipatingCountries.getSelectedItem();
        State organizationState = ( State ) cmbState.getSelectedItem();

        if ( organizationState != null && participatingCountry != null ) {
            populateParticipatingOrganizationTypeComboBox();
            OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
            if ( organizationType != null ) {
                populateOrganizationCombo(participatingCountry , organizationState , organizationType);
                NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
                if ( participatingOrganization != null ) {
                    populateTable(participatingOrganization);
                } else {
                    DefaultTableModel model = ( DefaultTableModel ) tblParticpatingOrganizationEmployees.getModel();
                    model.setRowCount(0);
                }
            }
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbParticipatingCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParticipatingCountriesActionPerformed

        Country participatingCountry = ( Country ) cmbParticipatingCountries.getSelectedItem();
        if ( participatingCountry != null ) {
            populateStateComboBox(participatingCountry);
            State organizationState = ( State ) cmbState.getSelectedItem();
            if ( organizationState != null ) {
                populateParticipatingOrganizationTypeComboBox();
                OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
                if ( organizationType != null ) {
                    populateOrganizationCombo(participatingCountry , organizationState , organizationType);
                    NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
                    if ( participatingOrganization != null ) {
                        populateTable(participatingOrganization);
                    } else {
                        DefaultTableModel model = ( DefaultTableModel ) tblParticpatingOrganizationEmployees.getModel();
                        model.setRowCount(0);
                    }
                }
            }
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbParticipatingCountriesActionPerformed

    private void txtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeNameActionPerformed

    }//GEN-LAST:event_txtEmployeeNameActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        Country participatingCountry = ( Country ) cmbParticipatingCountries.getSelectedItem();
        State organizationState = ( State ) cmbState.getSelectedItem();
        OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();

        if ( organizationType != null ) {
            populateOrganizationCombo(participatingCountry , organizationState , organizationType);
            NvdsParticipatingOrganization participatingOrganization = ( NvdsParticipatingOrganization ) cmbParticipatingOrganizations.getSelectedItem();
            if ( participatingOrganization != null ) {
                populateTable(participatingOrganization);
            } else {
                DefaultTableModel model = ( DefaultTableModel ) tblParticpatingOrganizationEmployees.getModel();
                model.setRowCount(0);
            }
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbParticipatingCountries;
    private javax.swing.JComboBox cmbParticipatingOrganizations;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblParticpatingOrganizationEmployees;
    private javax.swing.JTextField txtEmployeeName;
    // End of variables declaration//GEN-END:variables
}
