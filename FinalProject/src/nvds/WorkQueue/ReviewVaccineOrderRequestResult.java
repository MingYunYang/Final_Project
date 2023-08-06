package nvds.WorkQueue;

public class ReviewVaccineOrderRequestResult extends WorkRequest {

    private String reviewResult;

    public ReviewVaccineOrderRequestResult() {
        super();
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

}
