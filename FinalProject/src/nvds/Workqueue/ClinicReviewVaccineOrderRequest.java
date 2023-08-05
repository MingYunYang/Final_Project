package nvds.Workqueue;

public class ClinicReviewVaccineOrderRequest extends WorkRequest {

    private String reviewResult;

    public ClinicReviewVaccineOrderRequest() {
        super();
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

}
