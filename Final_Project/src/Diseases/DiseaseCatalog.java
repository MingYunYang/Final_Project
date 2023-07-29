/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package Diseases;

import java.util.ArrayList;

/**
 *
 * @author twmut
 */
public class DiseaseCatalog {

    private ArrayList<Disease> diseases;

    public DiseaseCatalog() {
        this.diseases = new ArrayList<>();
    }

    public Disease addDisease(Disease disease) {
        diseases.add(disease);
        return disease;
    }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

}
