/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

import nvds.vaccine.Batch;

/**
 * @author libby
 * @author mutara
 */
public class ReviewRequest extends WorkRequest {

    private String result;
    private int originalQuantity; // allocated quantity for clinic 分配給診所的數量
    private int availableQuantity; // left quantity in clinic 診所實際上剩下的數量
    private Batch batch;

    public ReviewRequest () {
        super();
    }

    public String getResult () {
        return result;
    }

    public void setResult ( String result ) {
        this.result = result;
    }

    public int getOrginalQuantity () {
        return originalQuantity;
    }

    public void setOrginalQuantity ( int orginalQuantity ) {
        this.originalQuantity = orginalQuantity;
    }

    public int getAvailableQuantity () {
        return availableQuantity;
    }

    public void setAvailableQuantity ( int availableQuantity ) {
        this.availableQuantity = availableQuantity;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    
    
    

}
