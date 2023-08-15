package ui.admin;

import nvds.NationalVaccineDistributionSystem;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.organization.Organization;
import nvds.organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.geography.Address;
import nvds.geography.City;
import nvds.geography.Contact;
import nvds.organization.Organization.Type;

/**
 * @author libby
 * @author mutara
 */
public class ManageOrganization extends javax.swing.JPanel {

    OrganizationDirectory directory;
    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;

    public ManageOrganization(JPanel userProcessContainer, OrganizationDirectory directory, NationalVaccineDistributionSystem ecosystem) {

        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.ecosystem = ecosystem;

        populateCountryCombo();
        Country country = (Country)cmbCountry.getSelectedItem();
        if(country != null){
            populateStateCombo(country);
            State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateCityCombo(state);
                City city = (City)cmbCity.getSelectedItem();
                if(city != null){
                    populateOrganizationTypeCombo();
                    Type type = (Type)cmbOrganizationType.getSelectedItem();
                    if(type != null){
                        populateTable();
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    
    private void populateCountryCombo(){
        
        cmbCountry.removeAllItems();
        for (Country country : ecosystem.getCountryList()) {
            cmbCountry.addItem(country);
        }
    }
    
    private void populateStateCombo(Country country){
    
        cmbState.removeAllItems();
        for (State state : country.getStateList()){
            cmbState.addItem(state);
        }
    }
    
    private void populateCityCombo(State state){
        
        cmbCity.removeAllItems();
        for (City city : state.getCityList()){
            cmbCity.addItem(city);
        }
    }
    
    private void populateOrganizationTypeCombo(){
                
        cmbOrganizationType.removeAllItems();
        for(Type type : Type.values()){
            cmbOrganizationType.addItem(type);
        }
    }

    public void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();
        model.setRowCount(0);

        Country selectedCountry = (Country)cmbCountry.getSelectedItem();
        State selectedState = (State)cmbState.getSelectedItem();
        City city = (City)cmbCity.getSelectedItem();
        Type type = (Type)cmbOrganizationType.getSelectedItem();
        
        int count = 1;
        for (Organization organization : directory.getListOfOrganizations()) {
            if(organization.getCountry().equals(selectedCountry) 
                    && organization.getState().equals(selectedState)
                    && organization.getCity().equals(city)
                    && organization.getType().equals(type)){
                
                Object[] row = new Object[4];
                row[0] = count;
                row[1] = organization;
                row[2] = organization.getAddress();
                row[3] = organization.getContact();
                            
                model.addRow(row);
                count++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganizations = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        cmbCountry = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblOrganizationList = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        lblOrganizationType = new javax.swing.JLabel();
        cmbOrganizationType = new javax.swing.JComboBox();
        lblCity = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox();
        lblNewName = new javax.swing.JLabel();
        lblNewPhone = new javax.swing.JLabel();
        lblNewAddress = new javax.swing.JLabel();
        lblNewPostalCode = new javax.swing.JLabel();
        lblOrganizationList1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCreateNewOrganization = new javax.swing.JLabel();
        txtNewName = new javax.swing.JTextField();
        txtNewPhone = new javax.swing.JTextField();
        txtNewAddress = new javax.swing.JTextField();
        txtNewPostalCode = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Name", "Address", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrganizations);
        if (tblOrganizations.getColumnModel().getColumnCount() > 0) {
            tblOrganizations.getColumnModel().getColumn(0).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblOrganizations.getColumnModel().getColumn(0).setHeaderValue("No.");
            tblOrganizations.getColumnModel().getColumn(1).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblOrganizations.getColumnModel().getColumn(2).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(3).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        btnCreate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Organizations");

        lblOrganizationList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationList.setText("Organization List:");

        lblCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCountry.setText("Country:");

        lblState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblState.setText("State:");

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        lblOrganizationType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationType.setText("Organization Type:");

        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        lblCity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCity.setText("City:");

        cmbCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCityActionPerformed(evt);
            }
        });

        lblNewName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewName.setText("Name:");

        lblNewPhone.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewPhone.setText("Phone:");

        lblNewAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewAddress.setText("Address:");

        lblNewPostalCode.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewPostalCode.setText("Postal Code:");

        lblOrganizationList1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationList1.setText("Search Organization:");

        lblCreateNewOrganization.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCreateNewOrganization.setText("Create New Organization:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrganizationList)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblOrganizationList1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
                                    .addComponent(jSeparator1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCity)
                                                    .addComponent(lblCountry)
                                                    .addComponent(lblState))
                                                .addGap(98, 98, 98))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblOrganizationType)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbState, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCity, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbOrganizationType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCreateNewOrganization)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblNewName, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewPostalCode, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewAddress, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNewPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNewAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNewPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(53, 53, 53)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrganizationList1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblOrganizationList)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCountry)
                                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblState))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCity))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblOrganizationType)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCreateNewOrganization)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNewName)
                            .addComponent(txtNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewPostalCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        State state = (State)cmbState.getSelectedItem();
        City city = (City)cmbCity.getSelectedItem();
        Type type = (Type)cmbOrganizationType.getSelectedItem();
        
        String name = txtNewName.getText();
        if (txtNewName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the new organization name");
            return;
        }

        Contact phone = new Contact(txtNewPhone.getText());
        if (txtNewPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the new organization phone");
            return;
        }

        Address address = new Address(txtNewAddress.getText(), txtNewPostalCode.getText());
        if (txtNewAddress.getText().isEmpty() || txtNewPostalCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the new organization address & postal code");
            return;
        }

        Organization newOrganization = directory.newOrganization(name, type, country, state, city, address, phone);

        txtNewName.setText("");
        txtNewPhone.setText("");
        txtNewAddress.setText("");
        txtNewPostalCode.setText("");

        JOptionPane.showMessageDialog(this, "New Organization created successfully");
        populateTable();

        evt.getWhen();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = (Country)cmbCountry.getSelectedItem();
        if(country != null){
            populateStateCombo(country);
            State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateCityCombo(state);
                City city = (City)cmbCity.getSelectedItem();
                if(city != null){
                    populateOrganizationTypeCombo();
                    Type type = (Type)cmbOrganizationType.getSelectedItem();
                    if(type != null){
                        populateTable();
                    }
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed
        
        State state = (State)cmbState.getSelectedItem();
            if(state != null){
                populateCityCombo(state);
                City city = (City)cmbCity.getSelectedItem();
                if(city != null){
                    populateOrganizationTypeCombo();
                    Type type = (Type)cmbOrganizationType.getSelectedItem();
                    if(type != null){
                        populateTable();
                    }
                }
            }

        evt.getWhen();
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        Type type = (Type)cmbOrganizationType.getSelectedItem();
            if(type != null){
                populateTable();
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    private void cmbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCityActionPerformed
        
        City city = (City)cmbCity.getSelectedItem();
            if(city != null){
                populateOrganizationTypeCombo();
                Type type = (Type)cmbOrganizationType.getSelectedItem();
                if(type != null){
                    populateTable();
            }
        }
    }//GEN-LAST:event_cmbCityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbCity;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCreateNewOrganization;
    private javax.swing.JLabel lblNewAddress;
    private javax.swing.JLabel lblNewName;
    private javax.swing.JLabel lblNewPhone;
    private javax.swing.JLabel lblNewPostalCode;
    private javax.swing.JLabel lblOrganizationList;
    private javax.swing.JLabel lblOrganizationList1;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtNewAddress;
    private javax.swing.JTextField txtNewName;
    private javax.swing.JTextField txtNewPhone;
    private javax.swing.JTextField txtNewPostalCode;
    // End of variables declaration//GEN-END:variables

}
