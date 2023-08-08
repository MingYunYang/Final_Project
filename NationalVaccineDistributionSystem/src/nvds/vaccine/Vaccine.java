package nvds.vaccine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import nvds.organization.Manufacturer;

public class Vaccine {
    
    private String name;
    
    private int price;
    
    private int vaccineId;
    
    private static int nextVaccineId = 1;
    
    private Manufacturer manufacturer;
    
    private int vaccineItemId;
    
    private static int count = 1;

    private Batch batch;

    private String manufactureDate;

    private String expirationDate;

    public Vaccine(String name, int price, Manufacturer manufacturer , Batch batch, String manufactureDate, String expirationDate){
        this.name = name;
        this.price = price;
        this.vaccineId = nextVaccineId;
        nextVaccineId++;
        this.batch = batch;
        this.manufacturer = manufacturer;
        vaccineItemId = count;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        count++;
    }
    
    private boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public static int getNextVaccineId() {
        return nextVaccineId;
    }

    public static void setNextVaccineId(int nextVaccineId) {
        Vaccine.nextVaccineId = nextVaccineId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getVaccineItemId() {
        return vaccineItemId;
    }

    public void setVaccineItemId(int vaccineItemId) {
        this.vaccineItemId = vaccineItemId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Vaccine.count = count;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    
    
    

    
    
    @Override
    public String toString(){
        return name;
    }


}
