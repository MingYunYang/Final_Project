/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package nvds.ui.clinic;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import nvds.NationalVaccineDistributionSystem;
import nvds.Organization.NvdsParticipatingOrganization;
import nvds.Useraccount.UserAccount;
import nvds.VaccineManagement.Vaccine;
import nvds.VaccineManagement.VaccineInventoryCatalog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole.OrganizationEmployeeRoleType;
import nvds.Workqueue.ReviewVaccineOrderRequestResult;
import nvds.Workqueue.WorkQueue;
import nvds.Workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineInventory extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    
    NationalVaccineDistributionSystem nvds;
    
    UserAccount clinicVaccineInventoryManagerUserAccount;
    
    NvdsParticipatingOrganization participatingOrganization;
    
    public ManageVaccineInventory(JPanel userProcessContainer , UserAccount clinicVaccineInventoryManagerUserAccount , NvdsParticipatingOrganization participatingOrganization , NationalVaccineDistributionSystem nvds) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.clinicVaccineInventoryManagerUserAccount = clinicVaccineInventoryManagerUserAccount;
        this.participatingOrganization = participatingOrganization;
        
        populateVaccineInventoryDetailsTable();
        populateAwaitingReviewResultWorkQueueTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineInventory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        btnSendRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineInventoryManagementWorkQueue = new javax.swing.JTable();
        lblInventoryWorkQueue = new javax.swing.JLabel();
        lblInventoryList = new javax.swing.JLabel();
        txtRequestQuantity = new javax.swing.JTextField();
        lblRequestQuantity = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Inventory");

        tblVaccineInventory.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tblVaccineInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Current Inventory", "Inventory Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVaccineInventory);
        if (tblVaccineInventory.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventory.getColumnModel().getColumn(0).setResizable(false);
            tblVaccineInventory.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblVaccineInventory.getColumnModel().getColumn(1).setResizable(false);
            tblVaccineInventory.getColumnModel().getColumn(2).setResizable(false);
            tblVaccineInventory.getColumnModel().getColumn(3).setResizable(false);
        }

        btnBack.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewDetails.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnViewDetails.setText("View Vaccine Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnSendRequest.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        tblVaccineInventoryManagementWorkQueue.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        tblVaccineInventoryManagementWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Order Qty", "Request Sender", "Request Reciever", "Request Status", "Review Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVaccineInventoryManagementWorkQueue);
        if (tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumnCount() > 0) {
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(0).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(1).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(2).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(3).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(4).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(5).setResizable(false);
            tblVaccineInventoryManagementWorkQueue.getColumnModel().getColumn(6).setResizable(false);
        }

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblInventoryWorkQueue.setText("Outgoing list of Vaccine order Requests:");

        lblInventoryList.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblInventoryList.setText("Clinic Vaccine Inventory:");

        txtRequestQuantity.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        lblRequestQuantity.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        lblRequestQuantity.setText("Request Vaccine order request Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInventoryList)
                            .addComponent(lblInventoryWorkQueue))
                        .addGap(342, 383, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRequestQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSendRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewDetails)))
                .addGap(0, 106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(20, 20, 20)
                .addComponent(lblInventoryList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequestQuantity)
                    .addComponent(btnViewDetails))
                .addGap(17, 17, 17)
                .addComponent(btnSendRequest)
                .addGap(17, 17, 17)
                .addComponent(lblInventoryWorkQueue)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * This method is triggered when the "Send Request" button is clicked.
     *
     * The purpose of this method is to create and send a vaccine review request
     * to the organization's Review Role from the current user (who is assumed
     * to have an Inventory Role). The review request includes a selected
     * vaccine, the quantity of vaccine to be reviewed, and the user who is
     * sending the request.
     *
     * The method performs the following actions:
     *
     * 1. It fetches the index of the selected row from the vaccine inventory
     * table. If no row is selected, the method shows an error message and
     * returns without further action.
     *
     * 2. It retrieves the vaccine and request quantity from the selected row
     * and input field respectively, and creates a new ClinicReviewRequest with
     * these details.
     *
     * 3. The sender of the request is set as the current user, and the request
     * status is set to "Sent".
     *
     * 4. The method then fetches the Review Role from the organization, as well
     * as the work queue for the current user's role.
     *
     * 5. If the Review Role is present, the request is added to the work queues
     * of both the current user's role and the Review Role. If the Review Role
     * is not present, an error message is displayed.
     *
     * 6. Upon successful submission of the request, a success message is
     * displayed and the request quantity input field is cleared. The work queue
     * table is then updated to reflect the new request.
     *
     * @param evt The ActionEvent object generated when the button is clicked.
     * This parameter is not used in the method implementation, but is required
     * due to the method being an event handler.
     */
    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

        // create the vaccineOrderRequest
        int selectedRowIndex = tblVaccineInventory.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog(this , "Please select a row from the table first");
            return;
        }
        /**
         * It retrieves the vaccine and request quantity from the selected row
         * and input field respectively, and creates a new ClinicReviewRequest
         * with these details
         *
         * The sender of the request is set as the current user, and the request
         * status is set to "Sent"
         *
         * The method then fetches the Review Role from the organization, as
         * well as the work queue for the current user's role
         *
         * If the Review Role is present, the request is added to the work
         * queues of both the current user's role and the Review Role, If the
         * ReviewRole is not present, an error message is displayed
         *
         * Upon successful submission of the request, a success message is
         * displayed and the request quantity input field is cleared, The work
         * queue table is then updated to reflect the new request
         */
        Vaccine vaccine = ( Vaccine ) tblVaccineInventory.getValueAt(selectedRowIndex , 1);
        int requestQuantity = Integer.parseInt(txtRequestQuantity.getText());
        ReviewVaccineOrderRequestResult vaccineOrderRequest = new ReviewVaccineOrderRequestResult();
        
        vaccineOrderRequest.setVaccine(vaccine);
        vaccineOrderRequest.setVaccineOrderRequestQuantity(requestQuantity);
        vaccineOrderRequest.setVaccineOrderRequestSender(clinicVaccineInventoryManagerUserAccount); // will show the employee's name

        for ( UserAccount vaccineOrderRequestReviewRoleUserAccount : participatingOrganization.getUserAccountDirectory().getListOfUserAccounts() ) {
            OrganizationEmployeeUserAccountRole vaccineOrderRequestReviewRole = participatingOrganization.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER);
            if ( vaccineOrderRequestReviewRoleUserAccount.getOrganizationEmployeeRole().equals(vaccineOrderRequestReviewRole) ) {
                vaccineOrderRequest.setRequestReceiver(vaccineOrderRequestReviewRoleUserAccount);
                break; // Optionally, you can break out of the loop if you've found the reviewer
            }
        }
        
        vaccineOrderRequest.setVaccineOrderRequestStatus("Sent");

        // add the vaccineOrderRequest to Inventory OrganizationEmployeeUserAccountRole's work queue
        // add the vaccineOrderRequest to the Review OrganizationEmployeeUserAccountRole's work queue as well
        OrganizationEmployeeUserAccountRole vaccineOrderRequestReviewRole = participatingOrganization.getSpecificRole(OrganizationEmployeeRoleType.VACCINE_ORDER_REQUEST_REVIEWER);
        
        WorkQueue vaccineInventoryManagementRoleAwaitingVaccineOrderRequestReviewResultWorkQueue = clinicVaccineInventoryManagerUserAccount.getOrganizationEmployeeRole().getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue();
        
        if ( vaccineOrderRequestReviewRole != null ) {
            vaccineOrderRequestReviewRole.getIncomingVaccineOrderRequestsWorkQueue().getListOfWorkRequests().add(vaccineOrderRequest);
            vaccineInventoryManagementRoleAwaitingVaccineOrderRequestReviewResultWorkQueue.getListOfWorkRequests().add(vaccineOrderRequest);
        } else {
            JOptionPane.showMessageDialog(this , "There's no review service now");
            return;
        }
        
        JOptionPane.showMessageDialog(this , "Request sent successfully");
        txtRequestQuantity.setText("");
        populateAwaitingReviewResultWorkQueueTable();
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        

    }//GEN-LAST:event_btnViewDetailsActionPerformed
    
    private void populateVaccineInventoryDetailsTable() {
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
        model.setRowCount(0);
        
        VaccineInventoryCatalog inventoryCatalog = participatingOrganization.getVaccineInventoryCatalog();
        inventoryCatalog.populateVaccineTypeList();
        inventoryCatalog.populateVaccineInventoryCount();
        
        for ( Vaccine vaccine : inventoryCatalog.getVaccineInventoryCount().keySet() ) {
            Object[] row = new Object[ 4 ];
            row[ 0 ] = vaccine.getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = inventoryCatalog.getVaccineInventoryCount().get(vaccine);
            row[ 3 ] = inventoryCatalog.getInventoryStatus(vaccine);
            
            model.addRow(row);
        }
    }
    
    private void populateAwaitingReviewResultWorkQueueTable() {
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventoryManagementWorkQueue.getModel();
        model.setRowCount(0);
        
        for ( WorkRequest request : clinicVaccineInventoryManagerUserAccount.getOrganizationEmployeeRole().getVaccineOrderRequestsCurrentlyUnderReviewWorkQueue().getListOfWorkRequests() ) {
            Object[] row = new Object[ 7 ];
            row[ 0 ] = request.getVaccine().getVaccineId();
            row[ 1 ] = request.getVaccine().getVaccineName();
            row[ 2 ] = request.getVaccineRequestQuantity();
            row[ 3 ] = request.getVaccineRequestSender();
            row[ 4 ] = request.getVaccineRequestReceiver();
            row[ 5 ] = request.getVaccineRequestStatus();
            
            String result = (( ReviewVaccineOrderRequestResult ) request).getReviewResult();
            row[ 6 ] = ((result == null) ? "Waiting" : result);
            
            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInventoryList;
    private javax.swing.JLabel lblInventoryWorkQueue;
    private javax.swing.JLabel lblRequestQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblVaccineInventory;
    private javax.swing.JTable tblVaccineInventoryManagementWorkQueue;
    private javax.swing.JTextField txtRequestQuantity;
    // End of variables declaration//GEN-END:variables
}
