package model.workqueue;

import model.useraccount.UserAccount;
import java.util.Date;
import model.vaccine.Vaccine;

public abstract class WorkRequest {

    private Vaccine vaccine;
    
    private int requestQuantity;
    
    private UserAccount sender;

    private UserAccount receiver;

    private String status;

    private Date requestDate;


    public WorkRequest() {
        requestDate = new Date();
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }
    
    @Override
    public String toString(){
        return vaccine.getName();
    }
    
    


}
