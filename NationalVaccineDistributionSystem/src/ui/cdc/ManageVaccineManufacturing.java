/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineCatalog;

/**
 *
 * @author libby
 */
public class ManageVaccineManufacturing extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;
    
    public ManageVaccineManufacturing(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        
        populateVaccineCatalogTable();
    }

    public void populateVaccineCatalogTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineCatalog.getModel();
        model.setRowCount(0);
        
        CDC CDC = (CDC)organization;
        
        for(Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()){
            Object[] row = new Object[ 4 ];
            row[ 0 ] = vaccine.getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = nvds.getTotalAvailabilityForSpecificVaccine(vaccine, CDC.getCountry());
            row[ 3 ] = (vaccine.getManufactureStatus() == null)? "Waiting" : vaccine.getManufactureStatus();
            model.addRow(row);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnCreateNewVaccine = new javax.swing.JButton();
        txtNewVaccineName = new javax.swing.JTextField();
        lblNewVaccineName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineCatalog = new javax.swing.JTable();
        btnSendManufactureRequest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Catalog");

        btnCreateNewVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreateNewVaccine.setText("Create");
        btnCreateNewVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewVaccineActionPerformed(evt);
            }
        });

        txtNewVaccineName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewVaccineNameActionPerformed(evt);
            }
        });

        lblNewVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewVaccineName.setText("New Vaccine Name:");

        tblVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Total Availability", "Manufacture Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVaccineCatalog);
        if (tblVaccineCatalog.getColumnModel().getColumnCount() > 0) {
            tblVaccineCatalog.getColumnModel().getColumn(0).setResizable(false);
            tblVaccineCatalog.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblVaccineCatalog.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSendManufactureRequest.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSendManufactureRequest.setText("Send Manufacture Request");
        btnSendManufactureRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendManufactureRequestActionPerformed(evt);
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
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateNewVaccine)
                        .addGap(81, 81, 81)
                        .addComponent(btnSendManufactureRequest))
                    .addComponent(jScrollPane2))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewVaccineName)
                    .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendManufactureRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateNewVaccine))
                .addContainerGap(413, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNewVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewVaccineActionPerformed

        String vaccineName = txtNewVaccineName.getText();
        if(txtNewVaccineName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "New vaccine name must be filled");
            return;
        }

        CDC CDC = (CDC)organization;
        VaccineCatalog vaccineCatalog = CDC.getVaccineCatalog();
        vaccineCatalog.newVaccine(vaccineName);

        JOptionPane.showMessageDialog(this, "New vaccine type added successfully");
        txtNewVaccineName.setText("");
        populateVaccineCatalogTable();
    }//GEN-LAST:event_btnCreateNewVaccineActionPerformed

    private void txtNewVaccineNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewVaccineNameActionPerformed

    }//GEN-LAST:event_txtNewVaccineNameActionPerformed

    private void btnSendManufactureRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendManufactureRequestActionPerformed

        int selectedRowIndex = tblVaccineCatalog.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a type of vaccine first");
            return;
        }
        Vaccine vaccine = (Vaccine)tblVaccineCatalog.getValueAt(selectedRowIndex, 1);
        if(vaccine.getManufactureStatus() == null){
            
            SendManufactureRequest smr = new SendManufactureRequest(userProcessContainer , userAccount , organization , nvds, vaccine);
            userProcessContainer.add("SendManufactureRequest" , smr);
            CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(this, "Selected vaccine type has already been manufactured");
            return;
        }
    }//GEN-LAST:event_btnSendManufactureRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewVaccine;
    private javax.swing.JButton btnSendManufactureRequest;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNewVaccineName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblVaccineCatalog;
    private javax.swing.JTextField txtNewVaccineName;
    // End of variables declaration//GEN-END:variables
}
