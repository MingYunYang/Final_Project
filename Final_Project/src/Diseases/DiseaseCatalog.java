package Diseases;

import java.util.ArrayList;
// import java.util.Collections;

/**
 * Class to represent a catalog of diseases.
 * 
 * @author William
 * @author Libby
 */
public class DiseaseCatalog {

    private final ArrayList<Disease> diseases;

    public DiseaseCatalog() {
        this.diseases = new ArrayList<>();
    }

    public Disease addDisease(Disease disease) {
        diseases.add(disease);
        return disease;
    }

    public void removeDisease(Disease disease) {
        diseases.remove(disease);
    }

    public Disease findDiseaseById(int id) {
        return diseases.stream().filter(disease -> disease.getId() == id).findFirst().orElse(null);
    }

    public Disease findDiseaseByName(String name) {
        return diseases.stream().filter(disease -> disease.getName().equals(name)).findFirst().orElse(null);
    }

    public ArrayList<Disease> getDiseases() {
        return new ArrayList<>(diseases);
    }

}
