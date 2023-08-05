package nvds.Workqueue;

import java.util.ArrayList;

public class WorkQueue {

    private final ArrayList<WorkRequest> listOfWorkRequests;

    public WorkQueue() {
        listOfWorkRequests = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getListOfWorkRequests() {
        return listOfWorkRequests;
    }

}
