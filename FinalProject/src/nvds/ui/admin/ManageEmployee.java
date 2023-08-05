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

    private final NvdsParticipatingOrganizationsDirectory organizationDirectory;
    private final JPanel userProcessContainer;
    private final NationalVaccineDistributionSystem ecosystem;

    public ManageEmployee(JPanel userProcessContainer, NvdsParticipatingOrganizationsDirectory organizationDirectory, NationalVaccineDistributionSystem ecosystem) {

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
                OrganizationType type = (OrganizationType)cmbOrganizationType.getSelectedItem();
                if(type != null){
                    populateOrganizationCombo(country, state, type);
                    NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization)cmbOrganization.getSelectedItem();
                    if(organization != null){
                        populateTable(organization);
                    }
                }
            }
        }
    }

    private void populateCountryCombo(){
        
        cmbCountry.removeAllItems();
        for(Country country : ecosystem.getParticipatingCountries()){
            cmbCountry.addItem(country);
        }
    }
    
    private void populateStateCombo(Country country){
        
        cmbState.removeAllItems();
        for(State state : country.getStateList()){
            cmbState.addItem(state);
        }
    }
    
    private void populateOrganizationTypeCombo(){
                
        cmbOrganizationType.removeAllItems();
        for(NvdsParticipatingOrganization.OrganizationType type : NvdsParticipatingOrganization.OrganizationType.values()){
            cmbOrganizationType.addItem(type);
        }
    }
    
    private void populateOrganizationCombo(Country country, State state, OrganizationType type){
        
        cmbOrganization.removeAllItems();
        for (NvdsParticipatingOrganization organization : organizationDirectory.getListOfParticipatingOrganizations()){
            if(organization.getOrganizationCountry().equals(country) 
               && organization.getOrganizationState().equals(state)
               && organization.getTypeOfOrganization().equals(type)){
               
               cmbOrganization.addItem(organization); 
            }
        }
    }
    
    private void populateTable(NvdsParticipatingOrganization organization){
        
        DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
        model.setRowCount(0);
        
        for (Employee employee : organization.getEmployeeDirectory().getListOfEmployees()){
             Object[] row = new Object[2];
             row[0] = employee.getEMPLOYEE_ID();
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
        lblOrganizationType = new javax.swing.JLabel();
        cmbOrganizationType = new javax.swing.JComboBox();

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

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
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
                                .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblOrganization))
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization) cmbOrganization.getSelectedItem();
        EmployeeDirectory employeeDirectory = organization.getEmployeeDirectory();
        String name = txtEmployeeName.getText();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee name cannot be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        employeeDirectory.addNewEmployee(name);
        
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

        NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization)cmbOrganization.getSelectedItem();
        if(organization != null){
            populateTable(organization);
        } else {
            DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
            model.setRowCount(0);
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        State state = (State) cmbState.getSelectedItem();
        
        if (state != null && country != null) {
            populateOrganizationTypeCombo();
            OrganizationType type = (OrganizationType) cmbOrganizationType.getSelectedItem();
            if (type != null) {
                populateOrganizationCombo(country, state, type);
                NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization) cmbOrganization.getSelectedItem();
                if (organization != null) {
                    populateTable(organization);
                } else {
                    DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
                    model.setRowCount(0);
                }
            }
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        if(country != null){
            populateStateCombo(country);
            State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateOrganizationTypeCombo();
                OrganizationType type = (OrganizationType)cmbOrganizationType.getSelectedItem();
                if(type != null){
                    populateOrganizationCombo(country, state, type);
                    NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization)cmbOrganization.getSelectedItem();
                    if(organization != null){
                        populateTable(organization);
                    } else {
                        DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
                        model.setRowCount(0);
                    }
                }
            }
        }

        evt.getWhen();

    }//GEN-LAST:event_cmbCountryActionPerformed

    private void txtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeNameActionPerformed
        
    }//GEN-LAST:event_txtEmployeeNameActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed
        
        Country country = (Country)cmbCountry.getSelectedItem();
        State state = (State) cmbState.getSelectedItem();
        OrganizationType type = (OrganizationType)cmbOrganizationType.getSelectedItem();
        
        if(type != null){
            populateOrganizationCombo(country, state, type);
            NvdsParticipatingOrganization organization = (NvdsParticipatingOrganization)cmbOrganization.getSelectedItem();
            if(organization != null){
                populateTable(organization);
            } else {
                DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
                model.setRowCount(0);
            }
        }     
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtEmployeeName;
    // End of variables declaration//GEN-END:variables
}
