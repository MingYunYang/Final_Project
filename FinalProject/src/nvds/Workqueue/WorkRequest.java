package nvds.Workqueue;

import nvds.Useraccount.UserAccount;
import java.util.Date;
import nvds.VaccineManagement.Vaccine;

public abstract class WorkRequest {

    private Vaccine vaccine;

    private int vaccineRequestQuantity;

    private UserAccount requestSender;

    private UserAccount requestReceiver;

    private UserAccount requestReviewer;

    private UserAccount hospitalReviewer;

    private String status;

    private Date requestDate;

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

    public String getStatus() {
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

    public int getVaccineRequestQuantity() {
        return vaccineRequestQuantity;
    }

    public void setVaccineOrderRequestQuantity(int vaccineRequestQuantity) {
        this.vaccineRequestQuantity = vaccineRequestQuantity;
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


}
