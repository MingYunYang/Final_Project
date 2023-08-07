package nvds.WorkQueue;

import nvds.VaccineManagement.AdverseEventTracking;

public class AdverseEventTrackingWorkRequest extends WorkRequest {

    private AdverseEventTracking adverseEventTracking;

    public AdverseEventTrackingWorkRequest() {
        this.adverseEventTracking = new AdverseEventTracking();
    }

    public AdverseEventTracking getAdverseEventTracking() {
        return adverseEventTracking;
    }

    public void setAdverseEventTracking(AdverseEventTracking adverseEventTracking) {
        this.adverseEventTracking = adverseEventTracking;
    }


}
