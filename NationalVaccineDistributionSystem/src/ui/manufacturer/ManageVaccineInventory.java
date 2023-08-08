/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;

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
            JOptionPane.showMessageDialog(this, "No CDC founded");
            return;
        }
    }
    
    public void populateVaccineInventoryTable(){
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVaccineInventory = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineInventory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblCreateVaccineItem = new javax.swing.JLabel();
        lblVaccineType = new javax.swing.JLabel();
        lblBatchID = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblManufactureDate = new javax.swing.JLabel();
        lblExpirationDate = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtBatchID = new javax.swing.JTextField();
        txtManufactureDate = new javax.swing.JTextField();
        txtExpirationDate = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnViewBatchDetails = new javax.swing.JButton();
        cmbVaccineType = new javax.swing.JComboBox();

        lblVaccineInventory.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineInventory.setText("Vaccine Inventory:");

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        tblVaccineInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Inventory Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVaccineInventory);
        if (tblVaccineInventory.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventory.getColumnModel().getColumn(2).setResizable(false);
        }

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblCreateVaccineItem.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCreateVaccineItem.setText("Create Vaccine Item:");

        lblVaccineType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineType.setText("Vaccine Type:");

        lblBatchID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblBatchID.setText("Batch ID:");

        lblQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblQuantity.setText("Quantity:");

        lblManufactureDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblManufactureDate.setText("Manufacture Date:");

        lblExpirationDate.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblExpirationDate.setText("Expiration Date:");

        btnCreate.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreate.setText("Create");

        btnViewBatchDetails.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnViewBatchDetails.setText("View Batch Details");

        cmbVaccineType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVaccineTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVaccineInventory)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(537, 537, 537))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVaccineType)
                                    .addComponent(lblBatchID))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBatchID)
                                    .addComponent(cmbVaccineType, 0, 150, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lblQuantity)
                                .addGap(68, 68, 68)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCreate)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblManufactureDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblExpirationDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCreateVaccineItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewBatchDetails))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblVaccineInventory)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreateVaccineItem)
                    .addComponent(btnViewBatchDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccineType)
                    .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBatchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBatchID)
                        .addComponent(lblQuantity)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManufactureDate)
                    .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpirationDate)
                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbVaccineTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineTypeActionPerformed

        evt.getWhen();
    }//GEN-LAST:event_cmbVaccineTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnViewBatchDetails;
    private javax.swing.JComboBox cmbVaccineType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBatchID;
    private javax.swing.JLabel lblCreateVaccineItem;
    private javax.swing.JLabel lblExpirationDate;
    private javax.swing.JLabel lblManufactureDate;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineInventory;
    private javax.swing.JLabel lblVaccineType;
    private javax.swing.JTable tblVaccineInventory;
    private javax.swing.JTextField txtBatchID;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtManufactureDate;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
