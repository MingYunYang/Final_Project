package nvds.vaccine;

import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
public class VaccineCatalog { // for CDC

    ArrayList<Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
    }

    public Vaccine newVaccine(String name){
        Vaccine vaccine = new Vaccine(name);
        vaccineList.add(vaccine);
        return vaccine;
    }
    
    
    // get the quantity for a specific batch ID 
    // 找出整個目錄中某批疫苗的數量
    public int getQuantityForBatch(String batchId) {
        for (Vaccine vaccine : vaccineList) {
        if (vaccine.getBatch().getBatchId().equals(batchId)) {
            return vaccine.getBatch().getQuantity();
            }
        }
        return 0; // return 0 if the batch ID is not found
    }
    
    // maybe we don't need this method 
    // 也許不用這個方法，因為不需要知道所有種類疫苗的總和
    public int getTotalQuantityOfAllVaccines() {
        int total = 0;
        for (Vaccine vaccine : vaccineList) {
            total += vaccine.getBatch().getQuantity(); // Sum the quantities of all batches
        }
        return total;
    }
    
    // maybe we don't need this method
    // 如果目錄裡每種疫苗只會出現一次，為什麼還要這個方法，可以直接getBatchQuantity就好了
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
