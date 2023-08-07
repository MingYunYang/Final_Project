/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

/**
 *
 * @author libby
 */
public class ReviewVaccineOrderRequest extends WorkRequest {
    
    private String result;
    
    public ReviewVaccineOrderRequest() {
        super();
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
