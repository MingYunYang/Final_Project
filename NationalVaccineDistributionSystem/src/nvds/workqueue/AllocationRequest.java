/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

import nvds.geography.City;
import nvds.geography.State;
import nvds.organization.Hospital;
import nvds.vaccine.Batch;

/**
 *
 * @author libby
 */
public class AllocationRequest extends WorkRequest{
    
    private Batch batch;
    private State state;
    private City city;
    private Hospital receivedHospital;
    
    public AllocationRequest(){
        super();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Hospital getReceivedHospital() {
        return receivedHospital;
    }

    public void setReceivedHospital(Hospital receivedHospital) {
        this.receivedHospital = receivedHospital;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }


    
    
    
    
    @Override
    public String toString(){
        return state.getName();
    }

    
    
    
}
