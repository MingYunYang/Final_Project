/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.VaccineManagement;

import nvds.Organization.VaccineManufacturer;
import java.util.Date;

/**
 *
 * @author libby
 */
public class VaccineOrderDetails {

    private Vaccine vaccine;

    private VaccineManufacturer manufacturer;

    private int batchId;

    private Date manufactureDate;

    private Date expirationDate;

    public VaccineOrderDetails(Vaccine vaccine , VaccineManufacturer manufacturer , int batchId) {
        this.vaccine = vaccine;
        this.batchId = batchId;
        this.manufacturer = manufacturer;
        manufactureDate = new Date();
        expirationDate = new Date();
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public VaccineManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(VaccineManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }


}
