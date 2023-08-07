package nvds.vaccine;

import java.util.ArrayList;

public class VaccineCatalog {

    ArrayList<Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
    }

    public Vaccine newVaccine(String name, int price, int vaccineId) {
        Vaccine vaccine = new Vaccine(name, price, vaccineId);
        vaccineList.add(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

}
