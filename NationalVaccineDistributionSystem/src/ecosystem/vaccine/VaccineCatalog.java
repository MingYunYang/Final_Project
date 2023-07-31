package ecosystem.vaccine;

import ecosystem.organization.Manufacturer;
import java.util.ArrayList;

public class VaccineCatalog {

    ArrayList<Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
    }

    public Vaccine newVaccine(int price, int vaccineId, int batchId, Manufacturer manufacturer) {
        Vaccine vaccine = new Vaccine(price, vaccineId, batchId, manufacturer);
        vaccineList.add(vaccine);
        return vaccine;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

}
