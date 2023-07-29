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
public class City {
    
    private int cityId;
    private static int count = 1;
    private String cityName;
    private int cityPopulation;
    private ArrayList<ClinicSite> siteList;

    public City() {
        cityId = count;
        count++;
        siteList = new ArrayList<>();
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public ArrayList<ClinicSite> getSiteList() {
        return siteList;
    }

    @Override
    public String toString(){
        return cityName;
    }
 

    
    
}
