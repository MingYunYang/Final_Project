/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;

/**
 *
 * @author libby
 */
public class ManageVaccineAllocation extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;
    
    public ManageVaccineAllocation(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateVaccineCombo();
        populateAllocationStandardTable();
        populateCurrentInventoryTable();
    }
    
    public void populateVaccineCombo(){
        
        DefaultTableModel model = (DefaultTableModel) tblAllocationStandard.getModel();
        model.setRowCount(0);
        
        CDC CDC = (CDC)organization;
        
        for(Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()){
            
        }
    }
    
    public void populateAllocationStandardTable(){
    
    }
    
    public void populateCurrentInventoryTable(){
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurrentInventory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblVaccine = new javax.swing.JLabel();
        cmbVaccine = new javax.swing.JComboBox<>();
        lblVaccineID = new javax.swing.JLabel();
        txtVaccineID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllocationStandard = new javax.swing.JTable();
        lblNationalVaccineAllocation = new javax.swing.JLabel();
        btnSearchCurrentInventory = new javax.swing.JButton();

        tblCurrentInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "City", "Organization Type", "Organization", "Inventory Quantity", "Inventory Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCurrentInventory);
        if (tblCurrentInventory.getColumnModel().getColumnCount() > 0) {
            tblCurrentInventory.getColumnModel().getColumn(0).setResizable(false);
            tblCurrentInventory.getColumnModel().getColumn(1).setResizable(false);
            tblCurrentInventory.getColumnModel().getColumn(2).setResizable(false);
            tblCurrentInventory.getColumnModel().getColumn(3).setResizable(false);
            tblCurrentInventory.getColumnModel().getColumn(4).setResizable(false);
        }

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Allocation");

        lblVaccine.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccine.setText("Vaccine:");

        lblVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineID.setText("Batch ID:");

        txtVaccineID.setEditable(false);

        tblAllocationStandard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "State Name", "Population", "Vaccine Allocation Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAllocationStandard);
        if (tblAllocationStandard.getColumnModel().getColumnCount() > 0) {
            tblAllocationStandard.getColumnModel().getColumn(0).setResizable(false);
            tblAllocationStandard.getColumnModel().getColumn(1).setResizable(false);
            tblAllocationStandard.getColumnModel().getColumn(2).setResizable(false);
        }

        lblNationalVaccineAllocation.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNationalVaccineAllocation.setText("National Vaccine Allocation:");

        btnSearchCurrentInventory.setText("Search Current Inventory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNationalVaccineAllocation)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVaccine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblVaccineID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSearchCurrentInventory))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(350, 350, 350)
                        .addComponent(lblTitle)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(34, 34, 34)
                .addComponent(lblNationalVaccineAllocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccine)
                    .addComponent(cmbVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVaccineID)
                    .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCurrentInventory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearchCurrentInventory;
    private javax.swing.JComboBox<String> cmbVaccine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNationalVaccineAllocation;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccine;
    private javax.swing.JLabel lblVaccineID;
    private javax.swing.JTable tblAllocationStandard;
    private javax.swing.JTable tblCurrentInventory;
    private javax.swing.JTextField txtVaccineID;
    // End of variables declaration//GEN-END:variables
}
