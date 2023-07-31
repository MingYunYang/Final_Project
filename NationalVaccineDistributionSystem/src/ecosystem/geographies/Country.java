package ecosystem.geographies;

import java.util.ArrayList;

public class Country {

    private String countryName;

    private int countryPopulation;

    private final ArrayList<State> stateList;

    public Country(String countryName) {
        this.countryName = countryName;
        stateList = new ArrayList<>();
    }

    public State addState(String name) {
        State state = new State(name);
        stateList.add(state);
        return state;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    @Override
    public String toString() {
        return countryName;
    }

}
