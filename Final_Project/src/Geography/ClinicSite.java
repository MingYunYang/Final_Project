/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geography;

/**
 *
 * @author libby
 */
public class ClinicSite {
    
    private int siteId;
    private static int count = 1;
    private String siteName;
    private int sitePopulation;

    public ClinicSite(){
        siteId = count;
        count++;
    }

    public int getSiteId() {
        return siteId;
    }

    public static int getCount() {
        return count;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getSitePopulation() {
        return sitePopulation;
    }

    public void setSitePopulation(int sitePopulation) {
        this.sitePopulation = sitePopulation;
    }
    
}
