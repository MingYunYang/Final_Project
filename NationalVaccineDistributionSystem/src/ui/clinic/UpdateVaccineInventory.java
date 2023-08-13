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
 *
 * @author mutar
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

        Clinic clinic = ( Clinic ) organization;
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = clinic.getInventoryCatalog();

        populateClinicVaccineInventoryTable( clinicVaccineInventoryCatalog );
    }

    public final void populateClinicVaccineInventoryTable ( VaccineInventoryCatalog clinicVaccineInventoryCatalog ) {

        DefaultTableModel model = ( DefaultTableModel ) tblClinicVaccineInventoryCatalog.getModel();
        model.setRowCount( 0 );

        VaccineInventoryCatalog inventory = organization.getInventoryCatalog();
        inventory.populateVaccineTypeList();
        inventory.populateVaccineInventoryCount();

        for ( Batch batch : clinicVaccineInventoryCatalog.getBatchList() ) {

            Vaccine vaccine = batch.getVaccine();

            Object[] row = new Object[ 9 ];
            row[ 0 ] = batch.getVaccine().getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = batch.getManufacturer();
            row[ 3 ] = batch;
            row[ 4 ] = batch.getOriginalQuantity(); // recieved quantity
            row[ 5 ] = batch.getQuantity(); // Total availability
            row[ 6 ] = batch.getManufactureDate(); // allocated quantity for each clinic
            row[ 7 ] = batch.getExpirationDate();
            row[ 8 ] = clinicVaccineInventoryCatalog.getInventoryStatus( vaccine );

            model.addRow( row );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        btnUpdateVaccineAvailability.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnUpdateVaccineAvailability.setText("Update Availabilty");
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
                "Vaccine ID", "Vaccine", "Manufacturer", "Batch id", "Qty Recieved", "Availability", "MFD", "ERD", "Status"
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

        btnSendRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        lblRequestQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestQuantity.setText("Request Vaccine Quantity:");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblRequestQuantity1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestQuantity1.setText("Manage Vaccine Inventory");

        txtUpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnUpdateVaccineAvailability)
                        .addGap(18, 18, 18)
                        .addComponent(txtUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(lblRequestQuantity)
                        .addGap(18, 18, 18)
                        .addComponent(txtRequestQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblRequestQuantity1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                        .addComponent(btnSendRequest)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(lblRequestQuantity1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequestQuantity)
                    .addComponent(txtUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateVaccineAvailability))
                .addGap(18, 18, 18)
                .addComponent(btnSendRequest)
                .addGap(129, 129, 129))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateVaccineAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVaccineAvailabilityActionPerformed

        int selectedRowIndex = tblClinicVaccineInventoryCatalog.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a batch to update." );
            return;
        }

        Batch batch = ( Batch ) tblClinicVaccineInventoryCatalog.getValueAt( selectedRowIndex, 3 );
        int updateQuantity = Integer.parseInt( txtUpdateQuantity.getText() );

        if ( updateQuantity < 0 || updateQuantity > batch.getQuantity() ) {
            JOptionPane.showMessageDialog( this, "Invalid quantity." );
            return;
        }

        // Calculate the new total availability
        int newTotalAvailability = batch.getQuantity() - updateQuantity;

        // Update the Batch object
        batch.setQuantity( newTotalAvailability );

        // Update the total availability in the table
        tblClinicVaccineInventoryCatalog.setValueAt( newTotalAvailability, selectedRowIndex, 5 );

        // Clear the update quantity text field
        txtUpdateQuantity.setText( "" );

        // Refresh the table or any other UI components
        Clinic clinic = ( Clinic ) organization;
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = clinic.getInventoryCatalog();
        populateClinicVaccineInventoryTable( clinicVaccineInventoryCatalog );

    }//GEN-LAST:event_btnUpdateVaccineAvailabilityActionPerformed

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

        // create the request
        int selectedRowIndex = tblClinicVaccineInventoryCatalog.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog( this, "Please select a row from the table first" );
            return;
        }

        Vaccine vaccine = ( Vaccine ) tblClinicVaccineInventoryCatalog.getValueAt( selectedRowIndex, 1 );
        Clinic clinic = ( Clinic ) organization;
        VaccineInventoryCatalog clinicVaccineInventoryCatalog = clinic.getInventoryCatalog();

        String inventoryStatus = clinicVaccineInventoryCatalog.getInventoryStatus( vaccine );

        // Check if the inventory status is "Insufficient"
        if ( "Sufficient".equals( inventoryStatus ) ) {
            JOptionPane.showMessageDialog( this, "Inventory is Sufficient, cannot send request." );
            return; // Exit the method without sending the request
        }

        int requestQuantity = Integer.parseInt( txtRequestQuantity.getText() );
        ReviewRequest request = new ReviewRequest();

        request.setVaccine( vaccine );
        request.setQuantity( requestQuantity );
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

//        ManageVaccineInventory mvi = new ManageVaccineInventory( userProcessContainer, userAccount, organization, nvds );
//        mvi.populateWaitingWorkQueueTable();
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove( this );

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[ componentArray.length - 1 ];
        ManageVaccineInventory mvi = ( ManageVaccineInventory ) component;
        mvi.populateWaitingWorkQueueTable();

        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous( userProcessContainer );

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnUpdateVaccineAvailability;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRequestQuantity;
    private javax.swing.JLabel lblRequestQuantity1;
    private javax.swing.JTable tblClinicVaccineInventoryCatalog;
    private javax.swing.JTextField txtRequestQuantity;
    private javax.swing.JTextField txtUpdateQuantity;
    // End of variables declaration//GEN-END:variables

}
