package nvds.WorkQueue;

import nvds.Useraccount.UserAccount;
import java.util.Date;
import nvds.VaccineManagement.Vaccine;

public abstract class WorkRequest {

    private String status;

    private String message;

    private Date requestDate;

    private Vaccine vaccine;

    private int requestQuantity;

    private UserAccount requestSender;

    private UserAccount requestReceiver;

    private UserAccount requestReviewer;

    private UserAccount hospitalReviewer;


    public WorkRequest() {
        requestDate = new Date();
    }

    public UserAccount getHospitalReviewer() {
        return hospitalReviewer;
    }


    public void setHospitalReviewer(UserAccount userAccount) {
        hospitalReviewer = userAccount;
    }

    public UserAccount getRequestSender() {
        return requestSender;
    }

    public void setVaccineOrderRequestSender(UserAccount requestSender) {
        this.requestSender = requestSender;
    }

    public UserAccount getRequestReceiver() {
        return requestReceiver;
    }

    public void setRequestReceiver(UserAccount requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    public String getVaccineRequestStatus() {
        return status;
    }

    public void setVaccineOrderRequestStatus(String status) {
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

    public void setVaccineOrderRequestQuantity(int vaccineRequestQuantity) {
        this.requestQuantity = vaccineRequestQuantity;
    }

    public UserAccount getRequestReviewer() {
        return requestReviewer;
    }

    public void setRequestReviewer(UserAccount reviewer) {
        this.requestReviewer = reviewer;
    }


    @Override
    public String toString() {
        return vaccine.getVaccineName();
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public void setRequestSender(UserAccount requestSender) {
        this.requestSender = requestSender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
