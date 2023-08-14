/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

import nvds.vaccine.Batch;

/**
 *
 * @author libby
 */
public class DeliveryRequest extends WorkRequest{
    
    Batch batch;
    
    public DeliveryRequest(){
        super();
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
    
    @Override
    public String toString(){
        return batch.getBatchId();
    }
    
    
}
