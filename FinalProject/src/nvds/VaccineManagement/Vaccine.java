package nvds.VaccineManagement;

import nvds.Organization.Manufacturer;

public class Vaccine {

    private int vaccineId;

    private Batch batch;

    private String vaccineName;

    private Manufacturer manufacturer;

    private int price;

    public Vaccine() {

    }

    public Vaccine(String name , int price , int vaccineId) {
        this.vaccineName = name;
        this.price = price;
        this.vaccineId = vaccineId;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
