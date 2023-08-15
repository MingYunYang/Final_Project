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
import nvds.organization.Clinic;
import nvds.organization.Organization;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Batch;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;
import nvds.workqueue.ReviewRequest;
import nvds.workqueue.WorkQueue;

/**
 * @author libby
 * @author mutara
 */
public class UpdateVaccineInventory extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem nvds;
    UserAccount userAccount;
    Organization organization;

    /**
     * Creates new form ManageClinicVaccineInventory
     *
     * @param userProcessContainer
     * @param userAccount
     * @param organization
     * @param nvds
     */
    public UpdateVaccineInventory ( JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem nvds ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateClinicVaccineInventoryTable();
    }

    public final void populateClinicVaccineInventoryTable () {

        DefaultTableModel model = ( DefaultTableModel ) tblClinicVaccineInventoryCatalog.getModel();
        model.setRowCount( 0 );

        VaccineInventoryCatalog inventory = organization.getInventoryCatalog();
        inventory.populateVaccineTypeList();
        inventory.populateVaccineInventoryCount();

        for ( Batch batch : inventory.getBatchList() ) {

            Vaccine vaccine = batch.getVaccine();

            Object[] row = new Object[ 9 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = batch.getManufacturer();
            row[ 3 ] = batch;
            row[ 4 ] = batch.getOriginalQuantity(); // recieved quantity by clinic
            row[ 5 ] = batch.getAvailableQuantity(); // available quantity left in clinic
            row[ 6 ] = batch.getManufactureDate();
            row[ 7 ] = batch.getExpirationDate();
            row[ 8 ] = batch.getInventoryStatus();

            model.addRow( row );
        }
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdateVaccineAvailability = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClinicVaccineInventoryCatalog = new javax.swing.JTable();
        btnSendRequest = new javax.swing.JButton();
        txtRequestQuantity = new javax.swing.JTextField();
        lblRequestQuantity = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblRequestQuantity1 = new javax.swing.JLabel();
        txtUpdateQuantity = new javax.swing.JTextField();
        lblTakeOutQuantity = new javax.swing.JLabel();

        btnUpdateVaccineAvailability.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnUpdateVaccineAvailability.setText("Update");
        btnUpdateVaccineAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVaccineAvailabilityActionPerformed(evt);
            }
        });

        tblClinicVaccineInventoryCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Manufacturer", "Batch ID", "Recv. Qty", "Avail. Qty", "MFD", "EXD", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClinicVaccineInventoryCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClinicVaccineInventoryCatalog);
        if (tblClinicVaccineInventoryCatalog.getColumnModel().getColumnCount() > 0) {
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(4).setHeaderValue("Recv. Qty");
            tblClinicVaccineInventoryCatalog.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        btnSendRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        lblRequestQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestQuantity.setText("Request Quantity:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblRequestQuantity1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblRequestQuantity1.setText("Check / Update Inventory");

        txtUpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateQuantityActionPerformed(evt);
            }
        });

        lblTakeOutQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblTakeOutQuantity.setText("Take Out Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblRequestQuantity1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblRequestQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTakeOutQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateVaccineAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSendRequest)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRequestQuantity1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateVaccineAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTakeOutQuantity)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequestQuantity)
                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendRequest))
                .addGap(100, 100, 100))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, btnSendRequest, btnUpdateVaccineAvailability});

    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateVaccineAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVaccineAvailabilityActionPerformed

        int selectedRowIndex = tblClinicVaccineInventoryCatalog.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a batch to update." );
            return;
        }

        Batch batch = ( Batch ) tblClinicVaccineInventoryCatalog.getValueAt( selectedRowIndex, 3 );
        
        int updateQuantity = Integer.parseInt( txtUpdateQuantity.getText() );
        if ( updateQuantity < 0 || updateQuantity > batch.getAvailableQuantity() ) {
            JOptionPane.showMessageDialog( this, "Invalid quantity." );
            return;
        }

        // Calculate the new total availability
        int newTotalAvailability = batch.getAvailableQuantity() - updateQuantity;
        // Update the Batch object
        batch.setAvailableQuantity(newTotalAvailability );

        // Update the total availability in the table
        populateClinicVaccineInventoryTable ();

        // Clear the update quantity text field
        txtUpdateQuantity.setText( "" );
    }//GEN-LAST:event_btnUpdateVaccineAvailabilityActionPerformed

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

        // create the request
        int selectedRowIndex = tblClinicVaccineInventoryCatalog.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a row from the table first" );
            return;
        }

        // Check if the inventory status is "Insufficient"
        int selectedVaccineAvailability = (Integer)tblClinicVaccineInventoryCatalog.getValueAt(selectedRowIndex, 5);
        if ( selectedVaccineAvailability > 50 ) {
            JOptionPane.showMessageDialog( this, "Inventory is Sufficient, cannot send request." );
            return; // Exit the method without sending the request
        }

        // create review request
        int requestQuantity = Integer.parseInt( txtRequestQuantity.getText() );
        Vaccine vaccine = (Vaccine)tblClinicVaccineInventoryCatalog.getValueAt(selectedRowIndex, 1);
        ReviewRequest request = new ReviewRequest();
        request.setVaccine( vaccine );
        Batch batch = (Batch) tblClinicVaccineInventoryCatalog.getValueAt( selectedRowIndex, 3);
        
        request.setBatch(batch);
        int originalQuantity = batch.getOriginalQuantity();
        request.setOrginalQuantity( originalQuantity );
        int availableQuantity  = batch.getAvailableQuantity();
        request.setAvailableQuantity( availableQuantity );
        
        request.setRequestQuantity( requestQuantity );
        request.setSender( userAccount );
        request.setStatus( "Sent" );

        // add the request to Inventory Role's work queue
        // add the request to the Review Role's work queue as well
        Role reviewRole = organization.getSpecificRole( RoleType.VACCINE_REQUEST_REVIEWER );
        WorkQueue inventoryRoleWaitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();

        if ( reviewRole != null ) {
            reviewRole.getMainWorkQueue().getListOfWorkRequests().add( request );
            inventoryRoleWaitingWorkQueue.getListOfWorkRequests().add( request );
        } else {
            JOptionPane.showMessageDialog( this, "There's no review service now" );
            return;
        }

        JOptionPane.showMessageDialog( this, "Request sent successfully" );
        txtRequestQuantity.setText( "" );
        
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove( this );

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[ componentArray.length - 1 ];
        if( component instanceof ManageVaccineInventory){
            ManageVaccineInventory mvi = ( ManageVaccineInventory ) component;
            mvi.populateWaitingWorkQueueTable();
            mvi.populateReceivedDeliveryNotificationsTable();
        }

        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateQuantityActionPerformed
    
    }//GEN-LAST:event_txtUpdateQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnUpdateVaccineAvailability;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRequestQuantity;
    private javax.swing.JLabel lblRequestQuantity1;
    private javax.swing.JLabel lblTakeOutQuantity;
    private javax.swing.JTable tblClinicVaccineInventoryCatalog;
    private javax.swing.JTextField txtRequestQuantity;
    private javax.swing.JTextField txtUpdateQuantity;
    // End of variables declaration//GEN-END:variables

}
