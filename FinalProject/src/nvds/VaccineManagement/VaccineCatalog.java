package nvds.VaccineManagement;

import java.util.ArrayList;

public class VaccineCatalog {

    ArrayList<Vaccine> listOfAvailableVaccines;

    public VaccineCatalog() {
        listOfAvailableVaccines = new ArrayList<>();
    }

    public Vaccine newVaccine(String name, int price, int vaccineId) {
        Vaccine vaccine = new Vaccine(name, price, vaccineId);
        listOfAvailableVaccines.add(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getListOfAvailableVaccines() {
        return listOfAvailableVaccines;
    }

}
