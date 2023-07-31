package ecosystem.diseases;

import ecosystem.vaccine.Vaccine;

public class Disease {

    private static int nextId = 1;

    private final int id;

    private String name;

    private Vaccine vaccine;

    public Disease(String name, Vaccine vaccine) {
        this.name = name;
        this.vaccine = vaccine;
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public String toString() {
        return name;
    }

}
