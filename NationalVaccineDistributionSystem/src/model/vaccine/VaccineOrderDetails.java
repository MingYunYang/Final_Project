/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vaccine;

import model.organization.NvdsVaccineManufacturer;
import java.util.Date;

/**
 *
 * @author libby
 */
public class VaccineOrderDetails {

    private Vaccine vaccine;

    private NvdsVaccineManufacturer manufacturer;

    private int batchId;

    private Date manufactureDate;

    private Date expirationDate;

    public VaccineOrderDetails(Vaccine vaccine , NvdsVaccineManufacturer manufacturer , int batchId) {
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

    public NvdsVaccineManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(NvdsVaccineManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }


}
