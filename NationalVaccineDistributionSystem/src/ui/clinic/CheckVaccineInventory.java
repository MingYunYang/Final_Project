/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Hospital;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;
import nvds.workqueue.ReviewRequest;

/**
 * @author libby
 * @author mutara
 */
public class CheckVaccineInventory extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount userAccount;
    Organization organization;
    ReviewRequest reviewRequest;

    public CheckVaccineInventory ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds, ReviewRequest reviewRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;
        this.reviewRequest = reviewRequest;

        populateRequestInfo();
        populateClinicVaccineInventoryTable();
    }
    
    public void populateRequestInfo(){
        
        txtVaccineID.setText(String.valueOf(reviewRequest.getVaccine().getVaccineId()));
        txtVaccine.setText(reviewRequest.getVaccine().getName());
        txtRequestQuantity.setText(String.valueOf(reviewRequest.getRequestQuantity()));
    }

    public final void populateClinicVaccineInventoryTable () {

        DefaultTableModel model = ( DefaultTableModel ) tblClinicVaccineInventoryCatalog.getModel();
        model.setRowCount( 0 );

        VaccineInventoryCatalog inventory = organization.getInventoryCatalog();
        inventory.populateVaccineTypeList();
        inventory.populateVaccineInventoryCount();

        for ( Batch batch : inventory.getBatchList() ) {

            Vaccine vaccine = batch.getVaccine();

            Object[] row = new Object[ 7 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = batch.getAvailableQuantity(); // available quantity left in clinic
            row[ 3 ] = batch;
            row[ 4 ] = batch.getManufactureDate();
            row[ 5 ] = batch.getExpirationDate();
            row[ 6 ] = batch.getInventoryStatus();
            model.addRow( row );
        }
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblClinicVaccineInventoryCatalog = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblRequestQuantity1 = new javax.swing.JLabel();
        txtVaccine = new javax.swing.JTextField();
        lblRequestVaccineID = new javax.swing.JLabel();
        lblRequestVaccineName = new javax.swing.JLabel();
        txtVaccineID = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtRequestQuantity = new javax.swing.JTextField();
        lblQuantity1 = new javax.swing.JLabel();
        txtRequestQuantity1 = new javax.swing.JTextField();

        tblClinicVaccineInventoryCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Avail. Qty", "Batch ID", "MFD", "EXD", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClinicVaccineInventoryCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClinicVaccineInventoryCatalog);
        if (tblClinicVaccineInventoryCatalog.getColumnModel().getColumnCount() > 0) {
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(5).setPreferredWidth(60);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblRequestQuantity1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblRequestQuantity1.setText("Check Clinic Inventory");

        txtVaccine.setEditable(false);

        lblRequestVaccineID.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestVaccineID.setText("Request Vaccine ID:");

        lblRequestVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestVaccineName.setText("Request Vaccine:");

        txtVaccineID.setEditable(false);

        lblQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblQuantity.setText("Request Quantity:");

        txtRequestQuantity.setEditable(false);

        lblQuantity1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblQuantity1.setText("Vaccine Sufficient Standard:");

        txtRequestQuantity1.setEditable(false);
        txtRequestQuantity1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        txtRequestQuantity1.setForeground(new java.awt.Color(102, 102, 102));
        txtRequestQuantity1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRequestQuantity1.setText("50");
        txtRequestQuantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestQuantity1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRequestVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRequestVaccineName)
                            .addComponent(lblQuantity))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(lblQuantity1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtRequestQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblRequestQuantity1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequestQuantity1)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequestVaccineID)
                    .addComponent(txtVaccineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequestVaccineName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity1)
                    .addComponent(txtRequestQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove( this );

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[ componentArray.length - 1 ];
        ManageVaccineRequest mva = ( ManageVaccineRequest ) component;
        mva.populateMainWorkQueue();
        mva.populateWaitingWorkQueue();

        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtRequestQuantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestQuantity1ActionPerformed
        
    }//GEN-LAST:event_txtRequestQuantity1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantity1;
    private javax.swing.JLabel lblRequestQuantity1;
    private javax.swing.JLabel lblRequestVaccineID;
    private javax.swing.JLabel lblRequestVaccineName;
    private javax.swing.JTable tblClinicVaccineInventoryCatalog;
    private javax.swing.JTextField txtRequestQuantity;
    private javax.swing.JTextField txtRequestQuantity1;
    private javax.swing.JTextField txtVaccine;
    private javax.swing.JTextField txtVaccineID;
    // End of variables declaration//GEN-END:variables

}
