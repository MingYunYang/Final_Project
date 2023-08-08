/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.VaccineManagement.Vaccine;
import nvds.geography.Country;
import nvds.geography.State;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.organization.Organization.Type;
import nvds.role.Role;
import nvds.useraccount.UserAccount;
import nvds.vaccine.VaccineInventoryCatalog;
import nvds.workqueue.ReviewVaccineOrderRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

/**
 *
 * @author tugum
 */
public class ManageVaccineInventoryJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    /**
     * Creates new form CreateVaccineJPanel
     *
     * @param userProcessContainer
     * @param userAccount
     * @param organization
     * @param nvds
     */
    public ManageVaccineInventoryJPanel(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.nvds = nvds;
        this.userAccount = userAccount;
        this.organization = organization;

        populateVaccineInventoryTable();
        populateWaitingWorkQueueTable();

        populateCountryCombo();
        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateOrganizationTypeCombo();
                Type type = ( Type ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateOrganizationCombo(country , state , type);
                    Organization organisation = ( Organization ) cmbOrganization.getSelectedItem();
                    if ( organisation != null ) {
                        // populateTable(organisation);
                    }
                }
            }
        }
    }


    private void populateCountryCombo() {

        cmbCountry.removeAllItems();
        for ( Country country : nvds.getCountryList() ) {
            if ( country.equals(organization.getCountry()) && organization instanceof CDC ) {
                cmbCountry.addItem(country);
            }
        }
    }

    private void populateStateCombo(Country country) {

        cmbState.removeAllItems();
        for ( State state : country.getStateList() ) {
            cmbState.addItem(state);
        }
    }

    private void populateOrganizationTypeCombo() {

        cmbOrganizationType.removeAllItems();
        for ( Organization.Type type : Organization.Type.values() ) {
            if ( type == Organization.Type.Public_Health_Department ) {
                cmbOrganizationType.addItem(type);
            } else {

            }

        }
    }

    private void populateOrganizationCombo(Country country , State state , Type type) {

        cmbOrganization.removeAllItems();
        for ( Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations() ) {
            if ( organization.getCountry().equals(country)
                    && organization.getState().equals(state)
                    && organization.getType().equals(type) ) {

                cmbOrganization.addItem(organization);
            }
        }
    }


    private void populateVaccineInventoryTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
        model.setRowCount(0);

        VaccineInventoryCatalog inventory = organization.getInventoryCatalog();
        inventory.populateVaccineTypeList();
        inventory.populateVaccineInventoryCount();

        for ( nvds.vaccine.Vaccine vaccine : inventory.getVaccineInventoryCount().keySet() ) {
            Object[] row = new Object[ 4 ];
            row[ 0 ] = vaccine.getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = inventory.getVaccineInventoryCount().get(vaccine);
            row[ 3 ] = inventory.getInventoryStatus(vaccine);

            model.addRow(row);
        }
    }

    private void populateWaitingWorkQueueTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventoryManagementWorkQueue.getModel();
        model.setRowCount(0);

        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests() ) {
            Object[] row = new Object[ 7 ];
            row[ 0 ] = request.getVaccine().getVaccineId();
            row[ 1 ] = request.getVaccine().getName();
            row[ 2 ] = request.getRequestQuantity();
            row[ 3 ] = request.getSender();
            row[ 4 ] = request.getReceiver();
            row[ 5 ] = request.getStatus();

            String result = (( ReviewVaccineOrderRequest ) request).getResult();
            row[ 6 ] = ((result == null) ? "Waiting" : result);

            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRequestQuantity = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblRequestQuantity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineInventory = new javax.swing.JTable();
        btnBack1 = new javax.swing.JButton();
        btnSendRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineInventoryManagementWorkQueue = new javax.swing.JTable();
        lblInventoryWorkQueue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox();
        lblOrganization = new javax.swing.JLabel();
        cmbOrganization = new javax.swing.JComboBox();
        cmbCountry = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();
        lblOrganizationType = new javax.swing.JLabel();
        cmbOrganizationType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        txtRequestQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestQuantityActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage CDCVaccine Inventory");

        lblRequestQuantity.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblRequestQuantity.setText("Request Vaccine Quantity:");

        tblVaccineInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Inventory", "Inventory Status"
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

        btnBack1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
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

        lblInventoryWorkQueue.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblInventoryWorkQueue.setText("Sending Vaccine Request:");

        lblState.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblState.setText("State:");

        cmbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateActionPerformed(evt);
            }
        });

        lblOrganization.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganization.setText("Organization:");

        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        lblCountry.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblCountry.setText("Country:");

        lblOrganizationType.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblOrganizationType.setText("Organization Type:");

        cmbOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationTypeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("Vaccine name");

        jTextField1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel3.setText("Batch id");

        jTextField2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N

        jButton1.setText("Add vaccine");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRequestQuantity)
                                .addGap(18, 18, 18)
                                .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSendRequest))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBack1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblOrganizationType)
                                                    .addComponent(lblCountry))
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(76, 76, 76)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblOrganization))
                                                    .addGap(16, 16, 16)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInventoryWorkQueue)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack1)
                    .addComponent(lblTitle))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblState))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOrganization)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCountry))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblOrganizationType)
                                    .addComponent(cmbOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendRequest)
                    .addComponent(txtRequestQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequestQuantity))
                .addGap(18, 18, 18)
                .addComponent(lblInventoryWorkQueue)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

        // create the request
        int selectedRowIndex = tblVaccineInventory.getSelectedRow();
        if ( selectedRowIndex < 0 ) {
            JOptionPane.showMessageDialog(this , "Please select a row from the table first");
            return;
        }

        Vaccine vaccine = ( Vaccine ) tblVaccineInventory.getValueAt(selectedRowIndex , 1);
        int requestQuantity = Integer.parseInt(txtRequestQuantity.getText());
        ReviewVaccineOrderRequest request = new ReviewVaccineOrderRequest();

        request.getVaccine().setName(vaccine.getName());
        request.setRequestQuantity(requestQuantity);
        request.setSender(userAccount);
        request.setStatus("Sent");

        // add the request to Inventory Role's work queue
        // add the request to the Review Role's work queue as well
        Role reviewRole = organization.getSpecificRole(Role.RoleType.VACCINE_REQUEST_REVIEWER);
        WorkQueue inventoryRoleWaitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();

        if ( reviewRole != null ) {
            reviewRole.getMainWorkQueue().getListOfWorkRequests().add(request);
            inventoryRoleWaitingWorkQueue.getListOfWorkRequests().add(request);
        } else {
            JOptionPane.showMessageDialog(this , "There's no review service now");
            return;
        }

        JOptionPane.showMessageDialog(this , "Request sent successfully");
        txtRequestQuantity.setText("");
        populateWaitingWorkQueueTable();
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void txtRequestQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestQuantityActionPerformed

    private void cmbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        State state = ( State ) cmbState.getSelectedItem();

        if ( state != null && country != null ) {
            populateOrganizationTypeCombo();
            Type type = ( Type ) cmbOrganizationType.getSelectedItem();
            if ( type != null ) {
                populateOrganizationCombo(country , state , type);
                Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
                if ( organization != null ) {
                    // populateTable(organization);
                } else {
                    DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
                    model.setRowCount(0);
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbStateActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed

        Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
        if ( organization != null ) {
            // populateTable(organization);
        } else {
            DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
            model.setRowCount(0);
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        if ( country != null ) {
            populateStateCombo(country);
            State state = ( State ) cmbState.getSelectedItem();
            if ( state != null ) {
                populateOrganizationTypeCombo();
                Type type = ( Type ) cmbOrganizationType.getSelectedItem();
                if ( type != null ) {
                    populateOrganizationCombo(country , state , type);
                    Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
                    if ( organization != null ) {
                        // populateTable(organization);
                    } else {
                        DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
                        model.setRowCount(0);
                    }
                }
            }
        }

        evt.getWhen();
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationTypeActionPerformed

        Country country = ( Country ) cmbCountry.getSelectedItem();
        State state = ( State ) cmbState.getSelectedItem();
        Type type = ( Type ) cmbOrganizationType.getSelectedItem();

        if ( type != null ) {
            populateOrganizationCombo(country , state , type);
            Organization organization = ( Organization ) cmbOrganization.getSelectedItem();
            if ( organization != null ) {
                // populateTable(organization);
            } else {
                DefaultTableModel model = ( DefaultTableModel ) tblVaccineInventory.getModel();
                model.setRowCount(0);
            }
        }
    }//GEN-LAST:event_cmbOrganizationTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JComboBox cmbCountry;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JComboBox cmbOrganizationType;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblInventoryWorkQueue;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblOrganizationType;
    private javax.swing.JLabel lblRequestQuantity;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblVaccineInventory;
    private javax.swing.JTable tblVaccineInventoryManagementWorkQueue;
    private javax.swing.JTextField txtRequestQuantity;
    // End of variables declaration//GEN-END:variables
}
