package nvds.Workqueue;

public class ReviewRequest extends WorkRequest {

    private String reviewResult;

    public ReviewRequest() {
        super();
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

}
