package nvds.workqueue;

import nvds.vaccine.AdverseEventTracking;

public class AdverseEventTrackingRequest extends WorkRequest {

    private AdverseEventTracking adverseEventTracking;

    public AdverseEventTrackingRequest() {
        super();
        adverseEventTracking = new AdverseEventTracking();
    }

    public AdverseEventTracking getAdverseEventTracking() {
        return adverseEventTracking;
    }
    
    @Override
    public String toString(){
        return String.valueOf(adverseEventTracking.getEventId());
    }


}
