package nvds.vaccine;

public class Vaccine {
    
    private String name;
    
    private int price;
    
    private int vaccineId;

    public Vaccine(String name, int price, int vaccineId) {
        this.name = name;
        this.price = price;
        this.vaccineId = vaccineId;
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
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return name;
    }


}
