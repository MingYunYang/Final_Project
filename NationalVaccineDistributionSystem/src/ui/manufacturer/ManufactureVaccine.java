/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Manufacturer;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;

/**
 *
 * @author libby
 */
public class ManufactureVaccine extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManufactureVaccine(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateVaccineTypeCombo();
    }
    
    public void populateVaccineTypeCombo(){
        
        cmbVaccineType.removeAllItems();
        
        CDC CDC = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.CDC) && organization.getCountry().equals(this.organization.getCountry())){
                CDC = (CDC)organization;
            }
        }
        if(CDC != null){
            for(Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()){
                cmbVaccineType.addItem(vaccine);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblManufactureDate = new javax.swing.JLabel();
        btnManufactureVaccine = new javax.swing.JButton();
        lblExpirationDate = new javax.swing.JLabel();
        cmbVaccineType = new javax.swing.JComboBox();
        lblVaccineType = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtBatchID = new javax.swing.JTextField();
        lblBatchID = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtManufactureDate = new javax.swing.JTextField();
        txtExpirationDate = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        lblManufactureDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufactureDate.setText("Manufacture Date:");

        btnManufactureVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnManufactureVaccine.setText("Manufacture Vaccine");
        btnManufactureVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManufactureVaccineActionPerformed(evt);
            }
        });

        lblExpirationDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblExpirationDate.setText("Expiration Date:");

        cmbVaccineType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVaccineTypeActionPerformed(evt);
            }
        });

        lblVaccineType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineType.setText("Vaccine Type:");

        lblPrice.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblPrice.setText("Price:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblQuantity.setText("Quantity:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manufacture Vaccine");

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtManufactureDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufactureDateActionPerformed(evt);
            }
        });

        txtExpirationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpirationDateActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManufactureVaccine)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(166, 166, 166)
                        .addComponent(btnBack))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblVaccineType)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblBatchID)
                                        .addGap(82, 82, 82))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblQuantity)
                                            .addComponent(lblPrice))
                                        .addGap(82, 82, 82))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblManufactureDate)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblExpirationDate)
                                    .addGap(26, 26, 26)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtBatchID)
                                .addComponent(txtQuantity)
                                .addComponent(txtPrice)
                                .addComponent(txtManufactureDate)
                                .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccineType)
                    .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBatchID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManufactureDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpirationDate)
                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnManufactureVaccine)
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManufactureVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManufactureVaccineActionPerformed

        Manufacturer manufacturer = (Manufacturer) organization;
        Vaccine selectedVaccine = (Vaccine)cmbVaccineType.getSelectedItem();
        if(selectedVaccine == null){
            JOptionPane.showMessageDialog(this, "No qualified vaccine now");
            return;
        }
        // make sure we don't create second batch for the vaccine that alrady has a batch
        for(Batch batch : organization.getInventoryCatalog().getBatchList()){
            if(batch.getVaccine().getName().equals(selectedVaccine.getName())){
                JOptionPane.showMessageDialog(this, "Selected vaccine already has a batch");
                return;
            }
        }

        String batchID = txtBatchID.getText();
        String manufactureDate = txtManufactureDate.getText();
        String expirationDate = txtExpirationDate.getText();
        if(batchID.isEmpty() || manufactureDate.isEmpty() || expirationDate.isEmpty()){
            JOptionPane.showMessageDialog(this, "All the fields must be filled");
            return;
        }

        int price;
        int quantity;
        try{
            price = Integer.parseInt(txtPrice.getText());
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Please check the price and quantity format");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(manufactureDate);
            dateFormat.parse(expirationDate);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Please check the date format");
            return;
        }

        // create new vaccine batch
        Batch batch = selectedVaccine.newBatch(quantity, price, manufacturer, manufactureDate, expirationDate, batchID);

        // add new vaccine batch to Manufacturer's inventory catalog's batch list
        VaccineInventoryCatalog inventoryCatalog = organization.getInventoryCatalog();
        inventoryCatalog.getBatchList().add(batch);

        JOptionPane.showMessageDialog(this, "New batch of vaccine created succesfully");

        txtPrice.setText("");
        txtBatchID.setText("");
        txtQuantity.setText("");
        txtManufactureDate.setText("");
        txtExpirationDate.setText("");
    }//GEN-LAST:event_btnManufactureVaccineActionPerformed

    private void cmbVaccineTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineTypeActionPerformed

        evt.getWhen();
    }//GEN-LAST:event_cmbVaccineTypeActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtManufactureDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufactureDateActionPerformed
        
    }//GEN-LAST:event_txtManufactureDateActionPerformed

    private void txtExpirationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpirationDateActionPerformed
        
    }//GEN-LAST:event_txtExpirationDateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVaccineInventory mvi = (ManageVaccineInventory) component;
        mvi.populateVaccineInventoryTable();
        mvi.populateReceivedManufactureRequestsTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnManufactureVaccine;
    private javax.swing.JComboBox cmbVaccineType;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblExpirationDate;
    private javax.swing.JLabel lblManufactureDate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineType;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtManufactureDate;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
