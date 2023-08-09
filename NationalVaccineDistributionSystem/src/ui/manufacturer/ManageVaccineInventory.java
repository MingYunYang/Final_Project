/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
public class ManageVaccineInventory extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManageVaccineInventory(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateVaccineTypeCombo();
        populateVaccineInventoryTable();
    }
    
    
    public void populateVaccineTypeCombo(){
        
        CDC CDC = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType() == Type.CDC && organization.getCountry().equals(this.organization.getCountry())){
                CDC = (CDC) organization;
            }
        } 
        if(CDC != null){
            for(Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()){
                cmbVaccineType.addItem(vaccine);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No qualified vaccine now");
            return;
        }
    }
    
    public void populateVaccineInventoryTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
        model.setRowCount(0);

        for ( Batch batch : organization.getInventoryCatalog().getBatchList()) {
            Object[] row = new Object[ 7 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = batch.getVaccine().getName();
            row[ 2 ] = batch.getBatchId();
            row[ 3 ] = batch.getPriceForEachVaccine();
            row[ 4 ] = batch.getQuantity();
            row[ 5 ] = batch.getManufactureDate();
            row[ 6 ] = batch.getExpirationDate();
            model.addRow(row);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBatchID = new javax.swing.JTextField();
        lblVaccineInventory = new javax.swing.JLabel();
        txtManufactureDate = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        txtExpirationDate = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        lblCreateVaccineBatch = new javax.swing.JLabel();
        cmbVaccineType = new javax.swing.JComboBox();
        lblVaccineType = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblBatchID = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineInventory = new javax.swing.JTable();
        lblManufactureDate = new javax.swing.JLabel();
        lblExpirationDate = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();

        lblVaccineInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineInventory.setText("Vaccine Inventory:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblCreateVaccineBatch.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCreateVaccineBatch.setText("Create Vaccine Batch:");

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

        tblVaccineInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Batch ID", "Price", "Availability", "Manufacture Date", "Expiration Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineInventory.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVaccineInventory);
        if (tblVaccineInventory.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventory.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblVaccineInventory.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        lblManufactureDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufactureDate.setText("Manufacture Date:");

        lblExpirationDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblExpirationDate.setText("Expiration Date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblVaccineInventory)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCreateVaccineBatch)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblBatchID)
                                                .addGap(82, 82, 82))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblVaccineType)
                                                .addGap(38, 38, 38)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblManufactureDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPrice)
                                        .addGap(98, 98, 98))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblExpirationDate)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)
                            .addComponent(btnCreate))
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVaccineInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCreateVaccineBatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExpirationDate)
                            .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblManufactureDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineType)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity)
                            .addComponent(lblBatchID))))
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
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
        
        // add the new vaccine batch to the manufacturer's inventory catalog
        VaccineInventoryCatalog inventoryCatalog = organization.getInventoryCatalog();
        inventoryCatalog.getBatchList().add(batch);
        
        JOptionPane.showMessageDialog(this, "New batch of vaccine created succesfully");
        populateVaccineInventoryTable();
        
        txtPrice.setText("");
        txtBatchID.setText("");
        txtQuantity.setText("");
        txtManufactureDate.setText("");
        txtExpirationDate.setText("");
    }//GEN-LAST:event_btnCreateActionPerformed

    private void cmbVaccineTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineTypeActionPerformed

        evt.getWhen();
    }//GEN-LAST:event_cmbVaccineTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbVaccineType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblCreateVaccineBatch;
    private javax.swing.JLabel lblExpirationDate;
    private javax.swing.JLabel lblManufactureDate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineInventory;
    private javax.swing.JLabel lblVaccineType;
    private javax.swing.JTable tblVaccineInventory;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtManufactureDate;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
