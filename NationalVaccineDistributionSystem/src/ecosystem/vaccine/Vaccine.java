package ecosystem.vaccine;

import ecosystem.organization.Manufacturer;
import java.util.Date;

public class Vaccine {

    private int price;

    private int vaccineId;

    private int batchId;

    private Manufacturer manufacturer;

    private Date manufactureDate;

    private Date expirationDate;

    public Vaccine(int price, int vaccineId, int batchId, Manufacturer manufacturer) {
        this.price = price;
        this.vaccineId = vaccineId;
        this.batchId = batchId;
        this.manufacturer = manufacturer;
        expirationDate = new Date();
        manufactureDate = new Date();
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

    public Manufacturer getManufacturerOrganization() {
        return manufacturer;
    }

    public void setManufacturerOrganization(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

}
