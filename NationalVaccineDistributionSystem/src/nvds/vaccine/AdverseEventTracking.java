package nvds.vaccine;

import java.util.Date;

public class AdverseEventTracking {

    private int eventId;

    private static int nextEventId = 0;

    private String description;

    private String batchId;

    private String vaccineName;

    private String manufacturer;

    private int affectedPeople;

    private int deaths;

    private Date dateReported;

    private String recallStatus;

    private String recallReason;

    public AdverseEventTracking() {
        this.eventId =  ++ nextEventId;
        this.dateReported = new Date();
    }


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeopleAffected() {
        return affectedPeople;
    }

    public void setAffectedPeople(int affectedPeople) {
        this.affectedPeople = affectedPeople;
    }


    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public String getRecallStatus() {
        return recallStatus;
    }

    public void setRecallStatus(String recallStatus) {
        this.recallStatus = recallStatus;
    }

    public String getRecallReason() {
        return recallReason;
    }

    public void setRecallReason(String recallReason) {
        this.recallReason = recallReason;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }


    public static int getNextEventId() {
        return nextEventId;
    }

    public static void setNextEventId(int aNextEventId) {
        nextEventId = aNextEventId;
    }


}
