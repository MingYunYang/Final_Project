package nvds.vaccine;

public class Vaccine {
    
    private String name;
    
    private int price;
    
    private int vaccineId;
    
    private static int nextVaccineId = 1;

    public Vaccine(String name, int price) {
        this.name = name;
        this.price = price;
        this.vaccineId = nextVaccineId;
        nextVaccineId++;
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
