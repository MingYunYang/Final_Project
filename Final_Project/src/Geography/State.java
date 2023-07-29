/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geography;

import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class State {
    
    private String stateName;
    private int statePopulation;
    private ArrayList<City> cityList;

    public State() {
        cityList = new ArrayList<>();
    }
    
    public City newCity(){
        City l = new City();
        cityList.add(l);
        return l;
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

    public ArrayList<City> getCityList() {
        return cityList;
    }
    
    @Override
    public String toString(){
        return stateName;
    }

    
}
