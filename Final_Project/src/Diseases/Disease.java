package Diseases;

import Vaccine.Vaccine;

/**
 * Class to represent a disease. Each disease has a unique id and a name.
 */
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Disease)) {
            return false;
        }
        Disease disease = (Disease) o;
        return id == disease.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Disease{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

}
