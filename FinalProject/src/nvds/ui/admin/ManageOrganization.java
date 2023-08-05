package nvds.ui.admin;

import nvds.NationalVaccineDistributionSystem;
import nvds.Geography.Country;
import nvds.Geography.State;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Organization.NvdsParticipatingOrganizationsDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.Geography.Address;
import nvds.Geography.City;
import nvds.Contact.Contact;
import nvds.Organization.NvdsParticipatingOrganization.OrganizationType;

public class ManageOrganization extends javax.swing.JPanel {

    NvdsParticipatingOrganizationsDirectory participatingOrganizationsDirectory;

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    public ManageOrganization(JPanel userProcessContainer , NvdsParticipatingOrganizationsDirectory participatingOrganizationsDirectory , NationalVaccineDistributionSystem nvds) {

        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.participatingOrganizationsDirectory = participatingOrganizationsDirectory;
        this.nvds = nvds;

        populateParticipatingCountriesComboBox();
        Country participatingCountry = ( Country ) cmbCountry.getSelectedItem();
        if ( participatingCountry != null ) {
            populateStateCombo(participatingCountry);
            State organizationState = ( State ) cmbState.getSelectedItem();
            if ( organizationState != null ) {
                populateCityCombo(organizationState);
                City organizationCity = ( City ) cmbCity.getSelectedItem();
                if ( organizationCity != null ) {
                    populateOrganizationTypeCombo();
                    OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
                    if ( organizationType != null ) {
                        populateParticipatingOrganizationsListTable();
                    }
                }
            }
        }
    }

    @SuppressWarnings ( "unchecked" )

    private void populateParticipatingCountriesComboBox() {

        cmbCountry.removeAllItems();
        for ( Country participatingCountry : nvds.getParticipatingCountries() ) {
            cmbCountry.addItem(participatingCountry);
        }
    }

    private void populateStateCombo(Country participatingCountry) {

        cmbState.removeAllItems();
        for ( State organizationState : participatingCountry.getlistOfStatesInParticipatingCountry() ) {
            cmbState.addItem(organizationState);
        }
    }

    private void populateCityCombo(State organizationState) {

        cmbCity.removeAllItems();
        for ( City organizationCity : organizationState.getListOfCitiesInState() ) {
            cmbCity.addItem(organizationCity);
        }
    }

    private void populateOrganizationTypeCombo() {

        cmbOrganizationType.removeAllItems();
        for ( OrganizationType organizationType : OrganizationType.values() ) {
            cmbOrganizationType.addItem(organizationType);
        }
    }

    private void populateParticipatingOrganizationsListTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblOrganizations.getModel();
        model.setRowCount(0);

        Country selectedParticipatingCountry = ( Country ) cmbCountry.getSelectedItem();
        State selectedOrganizationState = ( State ) cmbState.getSelectedItem();
        City selectedOrganizationCity = ( City ) cmbCity.getSelectedItem();
        OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();

        int count = 1;
        for ( NvdsParticipatingOrganization participatingOrganization : participatingOrganizationsDirectory.getListOfParticipatingOrganizations() ) {
            if ( participatingOrganization.getOrganizationCountry().equals(selectedParticipatingCountry)
                    && participatingOrganization.getOrganizationState().equals(selectedOrganizationState)
                    && participatingOrganization.getOrganizationCity().equals(selectedOrganizationCity)
                    && participatingOrganization.getTypeOfOrganization().equals(organizationType) ) {

                Object[] row = new Object[ 4 ];
                row[ 0 ] = count;
                row[ 1 ] = participatingOrganization;
                row[ 2 ] = participatingOrganization.getOrganizationAddress();
                row[ 3 ] = participatingOrganization.getOrganizationContact();

                model.addRow(row);
                count ++;
            }
        }
    }

    @SuppressWarnings ( "unchecked" )
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
        txtOrganizationName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtStreetAddress = new javax.swing.JTextField();
        txtPostalCode = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 102, 102));

        tblOrganizations.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrganizationList)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOrganizationList1)
                                            .addComponent(lblCreateNewOrganization)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblNewName, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewPhone, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewPostalCode, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNewAddress, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtPostalCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtStreetAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtOrganizationName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jSeparator1))
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbOrganizationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbState, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCountry, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(53, 53, 53))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(53, 53, 53))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrganizationList1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrganizationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblNewName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewPostalCode))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrganizationList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        Country participatingCountry = ( Country ) cmbCountry.getSelectedItem();
        State organizationState = ( State ) cmbState.getSelectedItem();
        City organizationCity = ( City ) cmbCity.getSelectedItem();
        OrganizationType organizationType = ( OrganizationType ) cmbOrganizationType.getSelectedItem();

        String organizationName = txtOrganizationName.getText();
        if ( txtOrganizationName.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Please enter the organization name");
            return;
        }

        Contact phoneNumber = new Contact(txtPhoneNumber.getText());
        if ( txtPhoneNumber.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Please enter the new organization phone");
            return;
        }

        Address organizationAddress = new Address(txtStreetAddress.getText() , txtPostalCode.getText());
        if ( txtStreetAddress.getText().isEmpty() || txtPostalCode.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Please enter the new organization address & postal code");
            return;
        }

        NvdsParticipatingOrganization newAdminOrganization = participatingOrganizationsDirectory.addNewNvdsAdminOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newClinicOrganization = participatingOrganizationsDirectory.addNewNvdsClinicOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newHospitalOrganization = participatingOrganizationsDirectory.addNewNvdsHospitalOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newCDC = participatingOrganizationsDirectory.addNewNvdsCDC(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newDistributionCenter = participatingOrganizationsDirectory.addNewNvdsDistributionCenter(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newPHD = participatingOrganizationsDirectory.addNewNvdsPHD(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newDistributor = participatingOrganizationsDirectory.addNewNvdsVaccineDistributorOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newProvider = participatingOrganizationsDirectory.addNewNvdsProviderOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);
        NvdsParticipatingOrganization newmanufacturer = participatingOrganizationsDirectory.addNewNvdsVaccineManufacturerOrganization(organizationName , organizationType , participatingCountry , organizationState , organizationCity , organizationAddress , phoneNumber);

        txtOrganizationName.setText("");
        txtPhoneNumber.setText("");
        txtStreetAddress.setText("");
        txtPostalCode.setText("");

        JOptionPane.showMessageDialog(this , "Organization created successfully");
        populateParticipatingOrganizationsListTable();

        evt.getWhen();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateCityCombo(state);
                City city = ( City ) cmbCity.getSelectedItem();
                if ( city != null ) {
                    populateOrganizationTypeCombo();
                    OrganizationType type = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
                    if ( type != null ) {
                        populateParticipatingOrganizationsListTable();
                    }
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        State state = ( State ) cmbState.getSelectedItem();
        if ( state != null ) {
            populateCityCombo(state);
            City city = ( City ) cmbCity.getSelectedItem();
            if ( city != null ) {
                populateOrganizationTypeCombo();
                OrganizationType type = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateParticipatingOrganizationsListTable();
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        OrganizationType type = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
        if ( type != null ) {
            populateParticipatingOrganizationsListTable();
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed

    private void cmbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCityActionPerformed

        City city = ( City ) cmbCity.getSelectedItem();
        if ( city != null ) {
            populateOrganizationTypeCombo();
            OrganizationType type = ( OrganizationType ) cmbOrganizationType.getSelectedItem();
            if ( type != null ) {
                populateParticipatingOrganizationsListTable();
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
    private javax.swing.JTextField txtOrganizationName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtStreetAddress;
    // End of variables declaration//GEN-END:variables

}
