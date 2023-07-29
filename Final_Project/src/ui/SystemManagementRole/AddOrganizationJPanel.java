/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemManagementRole;

import Contact.Contact;
import Ecosystem.Ecosystem;
import Geography.Address;
import Geography.City;
import Geography.Country;
import Geography.State;
import Organization.Organization;
import Organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author libby
 */
public class AddOrganizationJPanel extends javax.swing.JPanel {

    OrganizationDirectory directory;
    JPanel userProcessContainer;
    Ecosystem ecosystem;
    
    public AddOrganizationJPanel(OrganizationDirectory directory, JPanel userProcessContainer, Ecosystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.ecosystem = ecosystem;
        
        populateOrganizationCombo();
        populateCountryCombo();
        populateStateCombo();
        populateCityCombo();
        
//        Country selectedCountry = (Country) cmbCountry.getSelectedItem();
//        if (selectedCountry != null) {
//            populateStateCombo(selectedCountry);
//        }
//        
//        State state = (State) cmbState.getSelectedItem();
//        if(state != null){
//            populateCityCombo(state);
//        }
    }
    
    private void populateOrganizationCombo(){
        
        cmbOrganizationType.removeAllItems();
        for(Organization o : directory.getOrganizationList()){
            cmbOrganizationType.addItem(o);
        }
    }
    
    private void populateCountryCombo(){
        
        cmbCountry.removeAllItems();
        for (Country country : ecosystem.getCountryList()) {
            cmbCountry.addItem(country);
        }
    }
    
    private void populateStateCombo(){
        
        Country country = (Country)cmbCountry.getSelectedItem();
        cmbState.removeAllItems();
        for (State state : country.getStateList()){
            cmbState.addItem(state);
        }
    }
    
    private void populateCityCombo(){
        
        State state = (State)cmbState.getSelectedItem();
        cmbCity.removeAllItems();
        for (City c : state.getCityList()){
            cmbCity.addItem(c);
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
        jSeparator1 = new javax.swing.JSeparator();
        lblAddress = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        lblSelectOrgType6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPostalCode = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 0));

        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        lblSelectOrgType.setText("Organization Name:");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Add New Organization");

        lblOrganizationType.setText("Organization Type:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblLocatedCountry.setText("Located Country:");

        lblLocatedState.setText("Located State:");

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        lblLocatedCity.setText("Located City:");

        lblAddress.setText("Street & Postal Code:");

        lblSelectOrgType6.setText("Organization Phone:");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddress)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSelectOrgType6)
                                .addComponent(lblSelectOrgType))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblOrganizationType)
                                        .addGap(52, 52, 52))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblLocatedCity)
                                            .addComponent(lblLocatedState)
                                            .addComponent(lblLocatedCountry))
                                        .addGap(61, 61, 61)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(346, 346, 346)
                .addComponent(txtPostalCode)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblTitle)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrgType)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrgType6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrganizationType))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocatedCountry)
                    .addComponent(cmbCountry))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocatedState)
                    .addComponent(cmbState))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCity)
                    .addComponent(lblLocatedCity))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnBack))
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ManageOrganizationJPanel mo = (ManageOrganizationJPanel) c;
        mo.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String organizationName = txtName.getText();
        Contact phone = new Contact(txtPhone.getText());
        Address address = new Address(txtStreet.getText(), txtPostalCode.getText());
        
        Organization organizationType = (Organization)cmbOrganizationType.getSelectedItem();
        if(organizationType == null){
            JOptionPane.showMessageDialog(this, "Please select an organization type first");
            return;
        }
        
        Country country = (Country)cmbCountry.getSelectedItem();
        if(country == null){
            JOptionPane.showMessageDialog(this, "Please select a country for the new organization");
            return;
        }
        
        State state = (State)cmbState.getSelectedItem();
        if(state == null){
            JOptionPane.showMessageDialog(this, "Please select a state for the new organization");
            return;
        }
        
        City city = (City)cmbCity.getSelectedItem();
        if(city == null){
            JOptionPane.showMessageDialog(this, "Please select a city for the new organization");
            return;
        }
        
        directory.newOrganization(organizationType.getType(), country, state, city, address, phone);
        
        txtName.setText("");
        txtPhone.setText("");
        txtStreet.setText("");
        txtPostalCode.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        
//        Country selectedCountry = (Country) cmbCountry.getSelectedItem();
//        if (selectedCountry != null) {
//            populateStateCombo(selectedCountry);
//        }
//        
//        State state = (State) cmbState.getSelectedItem();
//        if(state != null){
//                populateCityCombo(state);
//        }
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed
        
//        State state = (State) cmbState.getSelectedItem();
//        if(state != null){
//                populateCityCombo(state);
//        }
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed
        // TODO add your handling code here:
        // for(Organization organization : )
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbCity;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JSeparator jSeparator1;
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
