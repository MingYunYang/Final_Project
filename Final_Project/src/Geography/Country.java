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
public class Country {
    
    private String countryName;
    private int countryPopulation;
    private ArrayList<State> stateList;

    public Country() {
        stateList = new ArrayList<>();
    }
    
    public State newState(){
        State s = new State();
        stateList.add(s);
        return s;
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
    
    public ArrayList<State> getStateList(){
        return stateList;
    }
    
    @Override
    public String toString(){
        return countryName;
    }
}
