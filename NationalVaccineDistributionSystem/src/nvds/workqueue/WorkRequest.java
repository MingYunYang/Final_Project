package nvds.workqueue;

import nvds.useraccount.UserAccount;
import java.util.Date;
import nvds.vaccine.Vaccine;

/**
 * @author libby
 * @author mutara
 */
public abstract class WorkRequest {
    
    // already used
    private String status;
    private Vaccine vaccine;
    private int requestQuantity; 
    private UserAccount sender;
    private UserAccount receiver;
    
    
    private UserAccount clinicReviewer;
    private UserAccount hospitalReviewer;
    private UserAccount phdReviewer;
    private UserAccount cdcReviewer;
    private Date requestDate;


    public WorkRequest() {
        requestDate = new Date();
    }

    public UserAccount getHospitalReviewer() {
        return hospitalReviewer;
    }
    
    public void setHospitalReviewer(UserAccount userAccount){
        hospitalReviewer = userAccount;
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

    public UserAccount getClinicReviewer() {
        return clinicReviewer;
    }

    public void setClinicReviewer(UserAccount reviewer) {
        this.clinicReviewer = reviewer;
    }

    public UserAccount getPhdReviewer() {
        return phdReviewer;
    }

    public void setPhdReviewer(UserAccount phdReviewer) {
        this.phdReviewer = phdReviewer;
    }

    public UserAccount getCdcReviewer() {
        return cdcReviewer;
    }

    public void setCdcReviewer(UserAccount cdcReviewer) {
        this.cdcReviewer = cdcReviewer;
    }
    
    
    
    
    
    @Override
    public String toString(){
        return vaccine.getName();
    }
    
    


}
