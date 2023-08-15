package nvds.workqueue;

import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
public class WorkQueue {

    private final ArrayList<WorkRequest> listOfWorkRequests;

    public WorkQueue() {
        listOfWorkRequests = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getListOfWorkRequests() {
        return listOfWorkRequests;
    }

}
