/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Manufacturer;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;
import nvds.workqueue.ManufactureRequest;
import nvds.workqueue.WorkQueue;

/**
 *
 * @author libby
 */
public class SendManufactureRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    Vaccine vaccine;
    
    public SendManufactureRequest(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds, Vaccine vaccine) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.vaccine = vaccine;
        
        txtVaccineType.setText(vaccine.getName());
        populateManufacturerCombo();
    }
    
    public void populateManufacturerCombo(){
        
        cmbManufacturer.removeAllItems();
        
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.Manufacturer) && organization.getCountry().equals(this.organization.getCountry())){
                Manufacturer manufacturer = (Manufacturer) organization;
                cmbManufacturer.addItem(manufacturer);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblVaccineType = new javax.swing.JLabel();
        lblExpectedQuantity = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        lblExpectedReceivedDate = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtExpectedQuantity = new javax.swing.JTextField();
        txtExpectedReceivedDate = new javax.swing.JTextField();
        btnSendManufactureRequest = new javax.swing.JButton();
        cmbManufacturer = new javax.swing.JComboBox();
        txtVaccineType = new javax.swing.JTextField();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Send Manufacture Request");

        lblVaccineType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineType.setText("Vaccine Type:");

        lblExpectedQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblExpectedQuantity.setText("Expected Quantity:");

        lblManufacturer.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufacturer.setText("Manufacturer:");

        lblExpectedReceivedDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblExpectedReceivedDate.setText("Expected Received Date:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSendManufactureRequest.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSendManufactureRequest.setText("Send Manufacture Request");
        btnSendManufactureRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendManufactureRequestActionPerformed(evt);
            }
        });

        cmbManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbManufacturerActionPerformed(evt);
            }
        });

        txtVaccineType.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSendManufactureRequest)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(156, 156, 156)
                        .addComponent(btnBack)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblExpectedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(txtExpectedQuantity))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblExpectedReceivedDate)
                                .addGap(18, 18, 18)
                                .addComponent(txtExpectedReceivedDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblManufacturer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblVaccineType, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addGap(82, 82, 82)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVaccineType))))
                        .addGap(344, 344, 344))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccineType)
                    .addComponent(txtVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManufacturer)
                    .addComponent(cmbManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpectedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpectedQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpectedReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpectedReceivedDate))
                .addGap(29, 29, 29)
                .addComponent(btnSendManufactureRequest)
                .addContainerGap(304, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVaccineManufacturing mvc = (ManageVaccineManufacturing) component;
        mvc.populateVaccineCatalogTable();
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendManufactureRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendManufactureRequestActionPerformed
        
        Manufacturer selectedManufacturer = (Manufacturer) cmbManufacturer.getSelectedItem();
        if (selectedManufacturer == null) {
            JOptionPane.showMessageDialog(this, "No available manufacturer now");
            return;
        }

        String expectedReceivedDate = txtExpectedReceivedDate.getText();
        if (txtExpectedReceivedDate.getText().isEmpty() || txtExpectedQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All the blanks must be filled");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(expectedReceivedDate);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Please check the date format");
            return;
        }

        int expectedQuantity;
        try {
            expectedQuantity = Integer.parseInt(txtExpectedQuantity.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please check the quantity format");
            return;
        }

        // create manufacture request
        // add it to Manufacture Role's main work queue
        ManufactureRequest manufactureRequest = new ManufactureRequest();
        manufactureRequest.setVaccine(vaccine);
        manufactureRequest.setRequestQuantity(expectedQuantity);
        manufactureRequest.setExpectedReceivedDate(expectedReceivedDate);

        Role role = selectedManufacturer.getSpecificRole(RoleType.VACCINE_INVENTORY_MANAGER);
        WorkQueue mainWorkQueue = role.getMainWorkQueue();
        mainWorkQueue.getListOfWorkRequests().add(manufactureRequest);

        // update selected vaccine's manufacture status
        vaccine.setManufactureStatus("Requesting");

        JOptionPane.showMessageDialog(this, "Manufacture request send successfully");

        
        // go back to the previous page automatically
        userProcessContainer.remove(this);
        
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVaccineManufacturing mvc = (ManageVaccineManufacturing) component;
        mvc.populateVaccineCatalogTable();
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnSendManufactureRequestActionPerformed

    private void cmbManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbManufacturerActionPerformed

    }//GEN-LAST:event_cmbManufacturerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendManufactureRequest;
    private javax.swing.JComboBox cmbManufacturer;
    private javax.swing.JLabel lblExpectedQuantity;
    private javax.swing.JLabel lblExpectedReceivedDate;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineType;
    private javax.swing.JTextField txtExpectedQuantity;
    private javax.swing.JTextField txtExpectedReceivedDate;
    private javax.swing.JTextField txtVaccineType;
    // End of variables declaration//GEN-END:variables
}
