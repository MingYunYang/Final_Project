package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.employee.Employee;
import nvds.employee.EmployeeDirectory;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.useraccount.UserAccount;

public class ManageVaccineAllocation extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    public ManageVaccineAllocation(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateCountryCombo();
        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateOrganizationTypeCombo();
                Type type = ( Type ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateOrganizationCombo(country , state , type);
                    Organization organisation = ( Organization ) cmbOrganization.getSelectedItem();
                    if ( organisation != null ) {
                        populateTable(organisation);
                    }
                }
            }
        }
    }

    private void populateCountryCombo() {

        cmbCountry.removeAllItems();
        for ( Country country : nvds.getCountryList() ) {
            if ( country.equals(organization.getCountry()) && organization instanceof CDC ) {
                cmbCountry.addItem(country);
            }
        }
    }

    private void populateStateCombo(Country country) {

        cmbState.removeAllItems();
        for ( State state : country.getStateList() ) {
            cmbState.addItem(state);
        }
    }

    private void populateOrganizationTypeCombo() {

        cmbOrganizationType.removeAllItems();
        for ( Organization.Type type : Organization.Type.values() ) {
            if ( type == Organization.Type.Public_Health_Department ) {
                cmbOrganizationType.addItem(type);
            } else {

            }

        }
    }

    private void populateOrganizationCombo(Country country , State state , Type type) {

        cmbOrganization.removeAllItems();
        for ( Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations() ) {
            if ( organization.getCountry().equals(country)
                    && organization.getState().equals(state)
                    && organization.getType().equals(type) ) {

                cmbOrganization.addItem(organization);
            }
        }
    }

    private void populateTable(Organization organization) {

        DefaultTableModel model = ( DefaultTableModel ) tblEmployees.getModel();
        model.setRowCount(0);

        for ( Employee employee : organization.getEmployeeDirectory().getEmployeeList() ) {
            Object[] row = new Object[ 2 ];
            row[ 0 ] = employee.getId();
            row[ 1 ] = employee.getName();
            model.addRow(row);
        }
    }


    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        lblEmployeeList = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        txtVaccineQuantity = new javax.swing.JTextField();
        btnAllocateVaccineQuantity = new javax.swing.JButton();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Allocation");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblEmployees.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BatchId", "Vaccine Name", "Manufacturer", "Population", "Allocated Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tblEmployees.getColumnModel().getColumn(0).setResizable(false);
            tblEmployees.getColumnModel().getColumn(1).setResizable(false);
            tblEmployees.getColumnModel().getColumn(2).setResizable(false);
            tblEmployees.getColumnModel().getColumn(3).setResizable(false);
            tblEmployees.getColumnModel().getColumn(4).setResizable(false);
        }

        lblEmployeeList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeList.setText("Public Health Department:");

        lblEmployeeName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblEmployeeName.setText("Vaccine Quantity:");

        txtVaccineQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaccineQuantityActionPerformed(evt);
            }
        });

        btnAllocateVaccineQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnAllocateVaccineQuantity.setText("Allocate Quantity");
        btnAllocateVaccineQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllocateVaccineQuantityActionPerformed(evt);
            }
        });

        lblState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblState.setText("State:");

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmployeeList)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblEmployeeName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtVaccineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAllocateVaccineQuantity))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblState))
                .addGap(47, 47, 47)
                .addComponent(lblEmployeeList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeName)
                    .addComponent(txtVaccineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllocateVaccineQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtVaccineQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaccineQuantityActionPerformed

    }//GEN-LAST:event_txtVaccineQuantityActionPerformed

    private void btnAllocateVaccineQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllocateVaccineQuantityActionPerformed

        Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
        EmployeeDirectory employeeDirectory = organization.getEmployeeDirectory();
        String name = txtVaccineQuantity.getText();

        if ( name.isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Employee name cannot be empty" , "Warning" , JOptionPane.WARNING_MESSAGE);
            return;
        }

        employeeDirectory.addEmployee(name);

        txtVaccineQuantity.setText("");
        populateTable(organization);

        evt.getWhen();
    }//GEN-LAST:event_btnAllocateVaccineQuantityActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        State state = ( State ) cmbState.getSelectedItem();

        if ( state != null && country != null ) {
            populateOrganizationTypeCombo();
            Type type = ( Type ) cmbOrganizationType.getSelectedItem();
            if ( type != null ) {
                populateOrganizationCombo(country , state , type);
                Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
                if ( organization != null ) {
                    populateTable(organization);
                } else {
                    DefaultTableModel model = ( DefaultTableModel ) tblEmployees.getModel();
                    model.setRowCount(0);
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbStateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllocateVaccineQuantity;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtVaccineQuantity;
    // End of variables declaration//GEN-END:variables

}
