/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vaccine;

import Organization.ManufacturerOrganization;
import java.util.Date;

/**
 *
 * @author libby
 */
public class Vaccine {
    
    private int price;
    private int vaccineId;
    private int batchId;
    private ManufacturerOrganization manufacturer;
    private Date expirationDate;
    
    
    public Vaccine(int price, int vaccineId, int batchId, ManufacturerOrganization manufacturer){
        this.price = price;
        this.vaccineId = vaccineId;
        this.batchId = batchId;
        this.manufacturer = manufacturer;
        expirationDate = new Date();
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
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

    public ManufacturerOrganization getManufacturerOrganization() {
        return manufacturer;
    }

    public void setManufacturerOrganization(ManufacturerOrganization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
