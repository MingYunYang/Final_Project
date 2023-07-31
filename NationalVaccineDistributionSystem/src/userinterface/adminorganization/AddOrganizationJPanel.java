package userinterface.adminorganization;

import ecosystem.geographies.Contact;
import ecosystem.Ecosystem;
import ecosystem.geographies.Address;
import ecosystem.geographies.City;
import ecosystem.geographies.Country;
import ecosystem.geographies.State;
import ecosystem.organization.Organization;
import ecosystem.organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddOrganizationJPanel extends javax.swing.JPanel {

    OrganizationDirectory organizationDirectory;

    JPanel userProcessContainer;

    Ecosystem ecosystem;

    public AddOrganizationJPanel(OrganizationDirectory directory, JPanel userProcessContainer, Ecosystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = directory;
        this.ecosystem = ecosystem;

        populateCountryCombobox();
        populateStateCombobox();
        populateCityCombobox();
        populateOrganizationCombobox();
    }

    private void populateCountryCombobox() {

        cmbCountry.removeAllItems();
        for (Country country : ecosystem.getListOfCountries()) {
            cmbCountry.addItem(country);
        }
    }

    private void populateStateCombobox() {

        Country country = (Country) cmbCountry.getSelectedItem();
        cmbState.removeAllItems();
        for (State state : country.getStateList()) {
            cmbState.addItem(state);
        }
    }

    private void populateCityCombobox() {

        State state = (State) cmbState.getSelectedItem();
        cmbCity.removeAllItems();
        for (City c : state.getListOfCities()) {
            cmbCity.addItem(c);
        }
    }

    private void populateOrganizationCombobox() {

        cmbOrganizationType.removeAllItems();
        for (Organization o : organizationDirectory.getListOfOrganizations()) {
            cmbOrganizationType.addItem(o);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbOrganizationType = new javax.swing.JComboBox();
        lblSelectOrgType = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblOrganizationType = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblLocatedCountry = new javax.swing.JLabel();
        lblLocatedState = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox();
        cmbState = new javax.swing.JComboBox();
        cmbCity = new javax.swing.JComboBox();
        lblLocatedCity = new javax.swing.JLabel();
        lblSelectOrgType6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        txtPostalCode = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        cmbOrganizationType.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        lblSelectOrgType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSelectOrgType.setText("Organization Name:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Add New Organization");

        lblOrganizationType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationType.setText("Organization Type:");

        txtName.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblLocatedCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblLocatedCountry.setText("Located Country:");

        lblLocatedState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblLocatedState.setText("Located State:");

        cmbCountry.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        cmbState.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        cmbCity.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        lblLocatedCity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblLocatedCity.setText("Located City:");

        lblSelectOrgType6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSelectOrgType6.setText("Organization Phone:");

        txtPhone.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Postal code");

        lblAddress.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblAddress.setText("Street");

        txtStreet.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        txtPostalCode.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle))
                        .addComponent(lblSelectOrgType, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSelectOrgType6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOrganizationType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLocatedCountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLocatedState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLocatedCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(lblAddress))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbState, 0, 167, Short.MAX_VALUE)
                                .addComponent(cmbCity, 0, 167, Short.MAX_VALUE)
                                .addComponent(cmbOrganizationType, 0, 167, Short.MAX_VALUE)
                                .addComponent(cmbCountry, 0, 167, Short.MAX_VALUE)
                                .addComponent(txtPostalCode)
                                .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbCity, cmbCountry, cmbOrganizationType, cmbState, lblLocatedCity, lblLocatedCountry, lblLocatedState, lblOrganizationType, lblSelectOrgType, lblSelectOrgType6, txtName, txtPhone});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSelectOrgType)
                                .addGap(11, 11, 11)))
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSelectOrgType6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocatedCountry)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocatedState)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocatedCity)
                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(82, 82, 82))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbCity, cmbCountry, cmbOrganizationType, cmbState, lblLocatedCity, lblLocatedCountry, lblLocatedState, lblOrganizationType, lblSelectOrgType, lblSelectOrgType6, txtName, txtPhone});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length - 1];
        ManageOrganizationJPanel mo = (ManageOrganizationJPanel) c;
        mo.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        String organizationName = txtName.getText();
        Contact phone = new Contact(txtPhone.getText());
        Address address = new Address(txtStreet.getText(), txtPostalCode.getText());

        Organization organizationType = (Organization) cmbOrganizationType.getSelectedItem();
        if (organizationType == null) {
            JOptionPane.showMessageDialog(this, "Please select an organization type first");
            return;
        }

        Country country = (Country) cmbCountry.getSelectedItem();
        if (country == null) {
            JOptionPane.showMessageDialog(this, "Please select a country to which the new organization belongs!");
            return;
        }

        State state = (State) cmbState.getSelectedItem();
        if (state == null) {
            JOptionPane.showMessageDialog(this, "Please select a state to which the new organization belongs!");
            return;
        }

        City city = (City) cmbCity.getSelectedItem();
        if (city == null) {
            JOptionPane.showMessageDialog(this, "Please select a city to which the new organization belongs!");
            return;
        }

        organizationDirectory.addOrganization(organizationName, organizationType.getType(), country, state, city, address, phone);

        txtName.setText("");
        txtPhone.setText("");
        txtStreet.setText("");
        txtPostalCode.setText("");

        evt.getWhen();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        evt.getWhen();
    }//GEN-LAST:event_txtNameActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        evt.getWhen();
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed
        evt.getWhen();
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed
        // TODO add your handling code here:
        evt.getWhen();
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbCity;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblLocatedCity;
    private javax.swing.JLabel lblLocatedCountry;
    private javax.swing.JLabel lblLocatedState;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblSelectOrgType;
    private javax.swing.JLabel lblSelectOrgType6;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtStreet;
    // End of variables declaration//GEN-END:variables
}
