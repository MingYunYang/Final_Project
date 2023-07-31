package ecosystem.diseases;

import java.util.ArrayList;

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

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

}
