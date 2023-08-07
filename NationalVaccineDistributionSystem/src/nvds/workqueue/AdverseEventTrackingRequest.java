package nvds.workqueue;

import nvds.vaccine.AdverseEventTracking;

public class AdverseEventTrackingRequest extends WorkRequest {

    private AdverseEventTracking adverseEventTracking;

    public AdverseEventTrackingRequest() {
        super();
        adverseEventTracking = new AdverseEventTracking(); //不確定這樣可不可以
    }

    public AdverseEventTracking getAdverseEventTracking() {
        return adverseEventTracking;
    }

    public void setAdverseEventTracking(AdverseEventTracking adverseEventTracking) {
        this.adverseEventTracking = adverseEventTracking;
    }
    
    @Override
    public String toString(){
        return String.valueOf(adverseEventTracking.getEventId());
    }


}
