package nvds.geography;

import java.util.ArrayList;

public class State {

    private String name;

    private int population;

    private final ArrayList<City> cityList;

    public State(String name, int population) {
        this.name = name;
        this.population = population;
        cityList = new ArrayList<>();
    }

    public City addCity(String name) {
        City city = new City(name);
        cityList.add(city);
        return city;
    }
    
    public double countAllocationQuantity(int totalStateNum, int availabilityQuantity){
        double distributionPercentageForHighPopulation = 1 / totalStateNum;
        double distributionPercentageForLowPopulation = 1 / (totalStateNum + 1);
        
        if(population > 500){ // high population
            return availabilityQuantity * distributionPercentageForHighPopulation;
        } else { // low population
            return availabilityQuantity * distributionPercentageForLowPopulation;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }
    
    
    

    @Override
    public String toString() {
        return name;
    }

}
