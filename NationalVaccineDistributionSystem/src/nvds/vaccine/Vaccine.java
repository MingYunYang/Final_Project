package nvds.vaccine;

import nvds.organization.Manufacturer;


public class Vaccine {
    
    private String name;  
    private int vaccineId;
    private static int nextVaccineId = 1;
    private Batch batch; // will be set after the manufacturer create the vaccine
    private String manufactureStatus;

    public Vaccine(String name){
        this.name = name;
        this.vaccineId = nextVaccineId;
        nextVaccineId++;
    }
    
    public Batch newBatch(int quantity, int priceForEachVaccine, Manufacturer manufacturer, String manufactureDate, String expirationDate, String batchId){
        Batch batch = new Batch(this, quantity, priceForEachVaccine, manufacturer, manufactureDate, expirationDate, batchId);
        setBatch(batch);
        setManufactureStatus("Manufactured");
        return batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getManufactureStatus() {
        return manufactureStatus;
    }

    public void setManufactureStatus(String manufactureStatus) {
        this.manufactureStatus = manufactureStatus;
    }
    
    

    @Override
    public String toString(){
        return name;
    }


}
