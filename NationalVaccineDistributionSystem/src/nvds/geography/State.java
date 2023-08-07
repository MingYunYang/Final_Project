package nvds.geography;

import java.util.ArrayList;

public class State {

    private String stateName;

    private int statePopulation;

    private final ArrayList<City> listOfCities;

    public State(String stateName) {
        this.stateName = stateName;
        listOfCities = new ArrayList<>();
    }

    public City addCity(String name) {
        City city = new City(name);
        listOfCities.add(city);
        return city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(int statePopulation) {
        this.statePopulation = statePopulation;
    }

    public ArrayList<City> getListOfCities() {
        return listOfCities;
    }

    @Override
    public String toString() {
        return stateName;
    }

}
