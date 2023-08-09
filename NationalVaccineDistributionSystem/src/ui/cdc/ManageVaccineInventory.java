package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.geography.State;
import nvds.organization.CDC;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineCatalog;

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
        
        populateVaccineCatalogTable();
    }

    private void populateVaccineCatalogTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineCatalog.getModel();
        model.setRowCount(0);
        
        CDC CDC = (CDC)organization;

        for ( Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()) {
            Object[] row = new Object[ 8 ];
            row[ 0 ] = vaccine.getVaccineId();
            row[ 1 ] = vaccine;
            row[ 2 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getManufacturer();
            row[ 3 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getBatchId();
            row[ 4 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getPriceForEachVaccine();
            row[ 5 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getQuantity();
            row[ 6 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getManufactureDate();
            row[ 7 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getExpirationDate();
            model.addRow(row);
        }
    }
    
    private void populateVaccineAllocationTable(int availability){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
        model.setRowCount(0);
        
        for ( State state : organization.getCountry().getStateList()) {
            Object[] row = new Object[ 3 ];
            row[ 0 ] = state;
            row[ 1 ] = state.getPopulation();
            
            int totalStateNum = organization.getCountry().getStateList().size();
            double allocationQuantityDouble = state.calculateAllocationQuantity(totalStateNum, availability);
            int allocationQuantityInteger = (int)allocationQuantityDouble;
            row[ 2 ] = allocationQuantityInteger;
            
            model.addRow(row);
        }
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineAllocation = new javax.swing.JTable();
        lblVaccineCatalog = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVaccineCatalog = new javax.swing.JTable();
        lblNewVaccineName = new javax.swing.JLabel();
        txtNewVaccineName = new javax.swing.JTextField();
        btnCreateNewVaccine = new javax.swing.JButton();
        btnViewSuggestedAllocation = new javax.swing.JButton();
        btnSendDistributionRequest = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSendingRequestList = new javax.swing.JTable();
        lblSendingRequestList = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Catalog & Allocation");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblVaccineAllocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "State Name", "Population", "Allocation Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineAllocation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVaccineAllocation);
        if (tblVaccineAllocation.getColumnModel().getColumnCount() > 0) {
            tblVaccineAllocation.getColumnModel().getColumn(2).setResizable(false);
        }

        lblVaccineCatalog.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineCatalog.setText("National Vaccine Catalog:");

        tblVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Manufacturer", "Batch ID", "Price", "Availability", "Manufacture Date", "Expiration Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVaccineCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVaccineCatalog);
        if (tblVaccineCatalog.getColumnModel().getColumnCount() > 0) {
            tblVaccineCatalog.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblVaccineCatalog.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblVaccineCatalog.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        lblNewVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewVaccineName.setText("New Vaccine Name:");

        txtNewVaccineName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewVaccineNameActionPerformed(evt);
            }
        });

        btnCreateNewVaccine.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnCreateNewVaccine.setText("Create");
        btnCreateNewVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewVaccineActionPerformed(evt);
            }
        });

        btnViewSuggestedAllocation.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnViewSuggestedAllocation.setText("View Suggested Allocation");
        btnViewSuggestedAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSuggestedAllocationActionPerformed(evt);
            }
        });

        btnSendDistributionRequest.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSendDistributionRequest.setText("Send Distribution Request");
        btnSendDistributionRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendDistributionRequestActionPerformed(evt);
            }
        });

        tblSendingRequestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Batch ID", "Vaccine Name", "Price", "Manufacturer", "Allocated State", "Allocated Quantity", "Sender", "Recipient", "Request Status", "Request Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblSendingRequestList);

        lblSendingRequestList.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblSendingRequestList.setText("Sending Request List:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSendDistributionRequest)
                    .addComponent(lblSendingRequestList)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                        .addComponent(lblVaccineCatalog, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCreateNewVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewSuggestedAllocation))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack)))
                    .addComponent(jScrollPane3))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(27, 27, 27)
                .addComponent(lblVaccineCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewVaccineName)
                    .addComponent(btnCreateNewVaccine)
                    .addComponent(btnViewSuggestedAllocation, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendDistributionRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSendingRequestList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNewVaccineNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewVaccineNameActionPerformed
       
    }//GEN-LAST:event_txtNewVaccineNameActionPerformed

    private void btnCreateNewVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewVaccineActionPerformed
        
        String vaccineName = txtNewVaccineName.getText();
        if(txtNewVaccineName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "New vaccine name must be filled out");
            return;
        }
        
        CDC CDC = (CDC)organization;
        VaccineCatalog vaccineCatalog = CDC.getVaccineCatalog();
        vaccineCatalog.newVaccine(vaccineName);
        
        txtNewVaccineName.setText("");
        populateVaccineCatalogTable();
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnCreateNewVaccineActionPerformed

    private void btnViewSuggestedAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSuggestedAllocationActionPerformed
        
        int selectedRowIndex = tblVaccineCatalog.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select one vaccine from the table to view");
            return;
        }
        
        Vaccine selectedVaccine = (Vaccine)tblVaccineCatalog.getValueAt(selectedRowIndex, 1);
        if(selectedVaccine.getBatch() == null){
            JOptionPane.showMessageDialog(this, "There's no available batch of vaccine");
            DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
            model.setRowCount(0);
            return;
        }
        
        int availability = (Integer)tblVaccineCatalog.getValueAt(selectedRowIndex, 5);
        populateVaccineAllocationTable(availability);  
    }//GEN-LAST:event_btnViewSuggestedAllocationActionPerformed

    private void btnSendDistributionRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendDistributionRequestActionPerformed
        
        
    }//GEN-LAST:event_btnSendDistributionRequestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewVaccine;
    private javax.swing.JButton btnSendDistributionRequest;
    private javax.swing.JButton btnViewSuggestedAllocation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNewVaccineName;
    private javax.swing.JLabel lblSendingRequestList;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineCatalog;
    private javax.swing.JTable tblSendingRequestList;
    private javax.swing.JTable tblVaccineAllocation;
    private javax.swing.JTable tblVaccineCatalog;
    private javax.swing.JTextField txtNewVaccineName;
    // End of variables declaration//GEN-END:variables

}
