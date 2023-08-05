package nvds.VaccineManagement;

public class Vaccine {

    private String vaccineName;

    private int price;

    private int vaccineId;

    public Vaccine(String name , int price , int vaccineId) {
        this.vaccineName = name;
        this.price = price;
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
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
    public String toString() {
        return vaccineName;
    }


}
