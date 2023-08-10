/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.clinic;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineInventoryCatalog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.role.Role;
import nvds.role.Role.RoleType;
import nvds.workqueue.ReviewRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author libby
 */
public class ManageVaccineInventory extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NationalVaccineDistributionSystem ecosystem;
    UserAccount userAccount;
    Organization organization;

    public ManageVaccineInventory(JPanel userProcessContainer, UserAccount userAccount, Organization organization, NationalVaccineDistributionSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.userAccount = userAccount;
        this.organization = organization;

        populateVaccineInventoryTable();
        populateWaitingWorkQueueTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineInventory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
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

        tblVaccineInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Availability", "Inventory Status"
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

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSendRequest.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        tblVaccineInventoryManagementWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Quantity", "Sender", "Recipient", "Request Status", "Review Result"
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

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryWorkQueue.setText("Sending Request List:");

        lblInventoryList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryList.setText("Clinic Vaccine Inventory:");

        lblRequestQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestQuantity.setText("Request Vaccine Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblInventoryList)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblRequestQuantity)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSendRequest))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblInventoryWorkQueue))
                            .addGap(3, 3, 3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(350, 350, 350)
                            .addComponent(lblTitle)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(20, 20, 20)
                .addComponent(lblInventoryList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendRequest, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRequestQuantity)))
                .addGap(18, 18, 18)
                .addComponent(lblInventoryWorkQueue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
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

        // create the request
        int selectedRowIndex = tblVaccineInventory.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from the table first");
            return;
        }

        Vaccine vaccine = (Vaccine) tblVaccineInventory.getValueAt(selectedRowIndex, 1);
        int requestQuantity = Integer.parseInt(txtRequestQuantity.getText());
        ReviewRequest request = new ReviewRequest();

        request.setVaccine(vaccine);
        request.setQuantity(requestQuantity);
        request.setSender(userAccount);
        request.setStatus("Sent");

        // add the request to Inventory Role's work queue
        // add the request to the Review Role's work queue as well
        Role reviewRole = organization.getSpecificRole(RoleType.VACCINE_REQUEST_REVIEWER);
        WorkQueue inventoryRoleWaitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();

        if (reviewRole != null) {
            reviewRole.getMainWorkQueue().getListOfWorkRequests().add(request);
            inventoryRoleWaitingWorkQueue.getListOfWorkRequests().add(request);
        } else {
            JOptionPane.showMessageDialog(this, "There's no review service now");
            return;
        }

        JOptionPane.showMessageDialog(this, "Request sent successfully");
        txtRequestQuantity.setText("");
        populateWaitingWorkQueueTable();
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void populateVaccineInventoryTable() {

        DefaultTableModel model = (DefaultTableModel) tblVaccineInventory.getModel();
        model.setRowCount(0);

        VaccineInventoryCatalog inventory = organization.getInventoryCatalog();
        inventory.populateVaccineTypeList();
        inventory.populateVaccineInventoryCount();

        for (Vaccine vaccine : inventory.getVaccineInventoryCount().keySet()) {
            Object[] row = new Object[4];
            row[0] = vaccine.getVaccineId();
            row[1] = vaccine;
            row[2] = inventory.getVaccineInventoryCount().get(vaccine);
            row[3] = inventory.getInventoryStatus(vaccine);

            model.addRow(row);
        }
    }

    private void populateWaitingWorkQueueTable() {

        DefaultTableModel model = (DefaultTableModel) tblVaccineInventoryManagementWorkQueue.getModel();
        model.setRowCount(0);

        for (WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            Object[] row = new Object[7];
            row[0] = request.getVaccine().getVaccineId();
            row[1] = request.getVaccine().getName();
            row[2] = request.getQuantity();
            row[3] = request.getSender();
            row[4] = request.getReceiver();
            row[5] = request.getStatus();

            String result = ((ReviewRequest) request).getResult();
            row[6] = ((result == null) ? "Waiting" : result);

            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
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
