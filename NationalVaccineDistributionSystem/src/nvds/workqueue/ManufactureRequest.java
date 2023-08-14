/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;


/**
 *
 * @author libby
 */
public class ManufactureRequest extends WorkRequest{

    private String expectedReceivedDate;
    
    public ManufactureRequest(){
        super();
    }

    public String getExpectedReceivedDate() {
        return expectedReceivedDate;
    }

    public void setExpectedReceivedDate(String expectedReceivedDate) {
        this.expectedReceivedDate = expectedReceivedDate;
    }
    
    @Override
    public String toString(){
        return expectedReceivedDate;
    }
    
    
}
