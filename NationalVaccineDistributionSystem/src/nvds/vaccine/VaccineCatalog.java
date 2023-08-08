package nvds.vaccine;

import java.util.ArrayList;
import nvds.organization.Manufacturer;

public class VaccineCatalog { // for cdc

    ArrayList<Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
    }

    public Vaccine newVaccine(String name, int price, Manufacturer manufacturer , Batch batch, String manufactureDate, String expirationDate){
        Vaccine vaccine = new Vaccine(name, price, manufacturer, batch, manufactureDate, expirationDate);
        vaccineList.add(vaccine);
        return vaccine;
    }
    
    // Get the quantity for a specific batch ID
    public int getQuantityForBatch(String batchId) {
        for (Vaccine vaccine : vaccineList) {
        if (vaccine.getBatch().getBatchId().equals(batchId)) {
            return vaccine.getBatch().getQuantity();
            }
        }
        return 0; // Return 0 if the batch ID is not found
    }
    
    public int getTotalQuantityOfAllVaccines() {
        int total = 0;
        for (Vaccine vaccine : vaccineList) {
            total += vaccine.getBatch().getQuantity(); // Sum the quantities of all batches
        }
        return total;
    }
    
    public int getTotalQuantityOfSpecificVaccine(String vaccineName) {
        int total = 0;
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.getName().equalsIgnoreCase(vaccineName)) { // Check if the vaccine name matches
                total += vaccine.getBatch().getQuantity(); // Sum the quantities of matching batches
            }
        }
        return total;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

}
