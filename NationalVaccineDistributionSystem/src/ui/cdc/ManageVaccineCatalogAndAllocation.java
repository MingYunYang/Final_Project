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

public class ManageVaccineCatalogAndAllocation extends javax.swing.JPanel {

    JPanel userProcessContainer;

    NationalVaccineDistributionSystem nvds;

    UserAccount userAccount;

    Organization organization;

    public ManageVaccineCatalogAndAllocation(JPanel userProcessContainer , UserAccount userAccount , Organization organization , NationalVaccineDistributionSystem nvds) {
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
            row[ 2 ] = vaccine.getPrice();
            row[ 3 ] = (vaccine.getManufacturer() == null)? "N/A" : vaccine.getManufacturer();
            row[ 4 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getBatchId();
            row[ 5 ] = (vaccine.getBatch() == null)? "N/A" : vaccine.getBatch().getQuantity();
            row[ 6 ] = (vaccine.getManufactureDate() == null)? "N/A" : vaccine.getManufactureDate();
            row[ 7 ] = (vaccine.getExpirationDate() == null)? "N/A" : vaccine.getExpirationDate();
            model.addRow(row);
        }
    }
    
    private void populateVaccineAllocationTable(int batchQuantity){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
        model.setRowCount(0);
        
        for ( State state : organization.getCountry().getStateList()) {
            Object[] row = new Object[ 3 ];
            row[ 0 ] = state;
            row[ 1 ] = state.getPopulation();
            
            int totalStateNum = organization.getCountry().getStateList().size();
            double allocationQuantityDouble = state.countAllocationQuantity(totalStateNum, batchQuantity);
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
        btnSearchVaccineAllocation = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblTitle.setText("Manage Vaccine Catalog & Allocation");

        btnBack.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblVaccineAllocation.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
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

        tblVaccineCatalog.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        tblVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine Name", "Price", "Manufacturer", "Batch ID", "Batch Quantity", "Manufacture Date", "Expiration Date"
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

        btnSearchVaccineAllocation.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSearchVaccineAllocation.setText("Search Vaccine Allocation");
        btnSearchVaccineAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchVaccineAllocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVaccineCatalog, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCreateNewVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearchVaccineAllocation))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(32, 32, 32)
                .addComponent(lblVaccineCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewVaccineName)
                    .addComponent(btnCreateNewVaccine)
                    .addComponent(btnSearchVaccineAllocation, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
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
        vaccineCatalog.newVaccine(vaccineName, 0, null, null, null, null);
        
        txtNewVaccineName.setText("");
        populateVaccineCatalogTable();
    }//GEN-LAST:event_btnCreateNewVaccineActionPerformed

    private void btnSearchVaccineAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchVaccineAllocationActionPerformed
        
        int selectedRowIndex = tblVaccineCatalog.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select one type of vaccine first");
            return;
        } else {
            int batchQuantity = (Integer)tblVaccineCatalog.getValueAt(selectedRowIndex, 5);
            populateVaccineAllocationTable(batchQuantity);
        }    
    }//GEN-LAST:event_btnSearchVaccineAllocationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewVaccine;
    private javax.swing.JButton btnSearchVaccineAllocation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNewVaccineName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccineCatalog;
    private javax.swing.JTable tblVaccineAllocation;
    private javax.swing.JTable tblVaccineCatalog;
    private javax.swing.JTextField txtNewVaccineName;
    // End of variables declaration//GEN-END:variables

}
