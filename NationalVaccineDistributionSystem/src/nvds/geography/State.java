package nvds.geography;

import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
public class State {

    private String name;

    private int population;

    private ArrayList<City> cityList;

    public State(String name) {
        this.name = name;
        cityList = new ArrayList<>();
    }

    public City addCity(String name, int cityPopulation) {
        City city = new City(name, cityPopulation);
        cityList.add(city);
        return city;
    }
    
    public double calculateAllocationQuantity(int totalStateNum, int availability){
        double distributionPercentageForHighPopulation = 1.0 / totalStateNum;
        double distributionPercentageForLowPopulation = 1.0 / (totalStateNum + 1);
        
        if(population > 500){ // high population
            return availability * distributionPercentageForHighPopulation;
        } else { // low population
            return availability * distributionPercentageForLowPopulation;
        }
    }
    
    public int calculateStatePopulation(){
        int sum = 0;
        for(City city : cityList){
            sum = sum + (city.getPopulation());
        }
        return sum;
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
