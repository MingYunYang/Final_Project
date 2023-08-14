/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

import nvds.geography.City;
import nvds.geography.State;
import nvds.organization.Clinic;
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
    private Clinic receivedClinic; // will be set until hospital distributes vaccine to clinic
    private int distributedQuantityForClinic; // will be set until hospital distributes vaccine to clinic
    private String paymentStatus;
    private String clinicPaymentStatus;
    
    public AllocationRequest(){
        super();
        paymentStatus = "Waiting";
        clinicPaymentStatus = "Waiting";
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

    public Clinic getReceivedClinic() {
        return receivedClinic;
    }

    public void setReceivedClinic(Clinic receivedClinic) {
        this.receivedClinic = receivedClinic;
    }

    public int getDistributedQuantityForClinic() {
        return distributedQuantityForClinic;
    }

    public void setDistributedQuantityForClinic(int distributedQuantityForClinic) {
        this.distributedQuantityForClinic = distributedQuantityForClinic;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getClinicPaymentStatus() {
        return clinicPaymentStatus;
    }

    public void setClinicPaymentStatus(String clinicPaymentStatus) {
        this.clinicPaymentStatus = clinicPaymentStatus;
    }
    
    
    
    
    @Override
    public String toString(){
        return batch.getVaccine().getName();
    }

    
    
    
}
