package ui.cdc;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nvds.NationalVaccineDistributionSystem;
import nvds.organization.Organization.Type;
import nvds.organization.CDC;
import nvds.organization.Distributor;
import nvds.organization.Organization;
import nvds.useraccount.UserAccount;
import javax.swing.JPanel;
import nvds.geography.State;
import nvds.role.Role;
import nvds.vaccine.Vaccine;
import nvds.vaccine.VaccineCatalog;
import nvds.workqueue.DistributionRequest;
import nvds.workqueue.WorkQueue;
import nvds.workqueue.WorkRequest;

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

    public void populateVaccineCatalogTable() {

        DefaultTableModel model = ( DefaultTableModel ) tblVaccineCatalog.getModel();
        model.setRowCount(0);
        
        CDC CDC = (CDC)organization;

        for ( Vaccine vaccine : CDC.getVaccineCatalog().getVaccineList()) {
            Object[] row = new Object[ 8 ];
            row[ 0 ] = vaccine.getVaccineId();
            row[ 1 ] = vaccine;
            
            if(vaccine.getManufactureStatus() == null){
                row[ 2 ] = "N/A";
                row[ 3 ] = "N/A";
                row[ 4 ] = "N/A";
                row[ 5 ] = "N/A";
                row[ 6 ] = "N/A";
                row[ 7 ] = "N/A";
                model.addRow(row);
            }
            if(vaccine.getManufactureStatus() != null && vaccine.getManufactureStatus().equals("Requesting")){
                row[ 2 ] = "Requesting";
                row[ 3 ] = "Requesting";
                row[ 4 ] = "Requesting";
                row[ 5 ] = "Requesting";
                row[ 6 ] = "Requesting";
                row[ 7 ] = "Requesting";
                model.addRow(row);
            }
            if(vaccine.getManufactureStatus() != null && vaccine.getManufactureStatus().equals("Manufacturing")){
                row[ 2 ] = "Manufacturing";
                row[ 3 ] = "Manufacturing";
                row[ 4 ] = "Manufacturing";
                row[ 5 ] = "Manufacturing";
                row[ 6 ] = "Manufacturing";
                row[ 7 ] = "Manufacturing";
                model.addRow(row);
            }
            if(vaccine.getManufactureStatus() != null && vaccine.getManufactureStatus().equals("Manufactured")){
                row[ 2 ] = "Manufactured";
                row[ 3 ] = "Manufactured";
                row[ 4 ] = "Manufactured";
                row[ 5 ] = "Manufactured";
                row[ 6 ] = "Manufactured";
                row[ 7 ] = "Manufactured";
                model.addRow(row);
            }
            if(vaccine.getManufactureStatus() != null && vaccine.getManufactureStatus().equals("Delivered")){
                row[ 2 ] = vaccine.getBatch().getManufacturer();
                row[ 3 ] = vaccine.getBatch().getBatchId();
                row[ 4 ] = vaccine.getBatch().getPriceForEachVaccine();
                row[ 5 ] = vaccine.getBatch().getQuantity();
                row[ 6 ] = vaccine.getBatch().getManufactureDate();
                row[ 7 ] = vaccine.getBatch().getExpirationDate();
                model.addRow(row);
            }
        }
    }
    
    public void populateVaccineAllocationTable(){
        
        DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
        model.setRowCount(0);
        
        for ( WorkRequest request : userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests()) {
            
            DistributionRequest distributionRequest = (DistributionRequest) request;
            
            Object[] row = new Object[ 4 ];
            row[ 0 ] = distributionRequest; // will show as state name
            row[ 1 ] = distributionRequest.getState().getPopulation();
            row[ 2 ] = distributionRequest.getQuantity();
            row[ 3 ] = (distributionRequest.getStatus() == null)? "Waiting" : distributionRequest.getStatus();
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
        btnDeliverVaccineToDistributor = new javax.swing.JButton();
        btnSendManufactureRequest = new javax.swing.JButton();

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "State", "Population", "Allocation Quantity", "Distribution Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        lblVaccineCatalog.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblVaccineCatalog.setText("Vaccine Catalog:");

        tblVaccineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Manufacturer", "Batch ID", "Price", "Availability", "MFD", "EXD"
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
            tblVaccineCatalog.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblVaccineCatalog.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblVaccineCatalog.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        lblNewVaccineName.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblNewVaccineName.setText("New Vaccine:");

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

        btnDeliverVaccineToDistributor.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnDeliverVaccineToDistributor.setText("Deliver Vaccine To Distributor");
        btnDeliverVaccineToDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverVaccineToDistributorActionPerformed(evt);
            }
        });

        btnSendManufactureRequest.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        btnSendManufactureRequest.setText("Send Manufacture Request");
        btnSendManufactureRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendManufactureRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeliverVaccineToDistributor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTitle)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBack))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCreateNewVaccine)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSendManufactureRequest))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnViewSuggestedAllocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVaccineCatalog)
                                .addGap(571, 571, 571)))
                        .addGap(59, 59, 59))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendManufactureRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNewVaccineName)
                        .addComponent(txtNewVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreateNewVaccine)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewSuggestedAllocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliverVaccineToDistributor)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateNewVaccine, btnDeliverVaccineToDistributor, btnSendManufactureRequest, btnViewSuggestedAllocation});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

        evt.getWhen();
    }//GEN-LAST:event_btnBackActionPerformed

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
            JOptionPane.showMessageDialog(this, "Please select a vaccine from the table to view");
            return;
        }
        
        Vaccine selectedVaccine = (Vaccine)tblVaccineCatalog.getValueAt(selectedRowIndex, 1);
        if(selectedVaccine.getBatch() == null){
            JOptionPane.showMessageDialog(this, "There's no available batch of vaccine");
            DefaultTableModel model = ( DefaultTableModel ) tblVaccineAllocation.getModel();
            model.setRowCount(0);
            return;
        }
        
//Haven't be solved 待解決       
//        // make sure we don't create duplicated distribution request everytime we click this button
//        WorkQueue waitingWorkQueue = userAccount.getRole().getWaitingWorkQueue();
//        waitingWorkQueue.getListOfWorkRequests().clear();
        
        // create distribution request for each state 
        // add these requests to CDC Allocation Role's waiting work queue
        for(State state : organization.getCountry().getStateList()){
            DistributionRequest distributionRequest = new DistributionRequest();
            distributionRequest.setVaccine(selectedVaccine);
            distributionRequest.setState(state);
            
            int availability = (Integer)tblVaccineCatalog.getValueAt(selectedRowIndex, 5);
            int totalStateNum = organization.getCountry().getStateList().size();
            double allocationQuantityDouble = distributionRequest.getState().calculateAllocationQuantity(totalStateNum, availability);
            int allocationQuantityInteger = (int)allocationQuantityDouble;
            distributionRequest.setQuantity(allocationQuantityInteger);

            userAccount.getRole().getWaitingWorkQueue().getListOfWorkRequests().add(distributionRequest);
        }

        populateVaccineAllocationTable();  
    }//GEN-LAST:event_btnViewSuggestedAllocationActionPerformed

    private void btnDeliverVaccineToDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverVaccineToDistributorActionPerformed
        
        int selectedRowIndex = tblVaccineAllocation.getSelectedRow();
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select a state to deliver");
            return;
        }
        
        DistributionRequest distributionRequest = (DistributionRequest)tblVaccineAllocation.getValueAt(selectedRowIndex, 0);
        
        Distributor distributor = null;
        for(Organization organization : nvds.getOrganizationDirectory().getListOfOrganizations()){
            if(organization.getType().equals(Type.Distributor) && organization.getCountry().equals(this.organization.getCountry())){
               distributor = (Distributor) organization;
            }
        }
        
        if(distributor != null){
            Role role = distributor.getSpecificRole(Role.RoleType.VACCINE_INVENTORY_MANAGER);
            WorkQueue mainWorkQueue = role.getMainWorkQueue();
            mainWorkQueue.getListOfWorkRequests().add(distributionRequest);
            distributionRequest.setStatus("Delivering");
            populateVaccineAllocationTable();
        } else {
            JOptionPane.showMessageDialog(this, "No distributor founded");
            return;
        }
        
    }//GEN-LAST:event_btnDeliverVaccineToDistributorActionPerformed

    private void btnSendManufactureRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendManufactureRequestActionPerformed
        
        SendManufactureRequest smr = new SendManufactureRequest(userProcessContainer , userAccount , organization , nvds);
        userProcessContainer.add("SendManufactureRequest" , smr);
        CardLayout layout = ( CardLayout ) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSendManufactureRequestActionPerformed

    private void txtNewVaccineNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewVaccineNameActionPerformed

    }//GEN-LAST:event_txtNewVaccineNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNewVaccine;
    private javax.swing.JButton btnDeliverVaccineToDistributor;
    private javax.swing.JButton btnSendManufactureRequest;
    private javax.swing.JButton btnViewSuggestedAllocation;
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
