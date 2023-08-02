/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.workqueue;

/**
 *
 * @author libby
 */
public class ClinicReviewRequest extends WorkRequest {
    
    private String result;
    
    public ClinicReviewRequest() {
        super();
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
