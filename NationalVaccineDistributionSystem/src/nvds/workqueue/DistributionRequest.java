/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nvds.workqueue;

import nvds.geography.State;

/**
 *
 * @author libby
 */
public class DistributionRequest extends WorkRequest{
    
    private State state;
    
    public DistributionRequest(){
        super();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    @Override
    public String toString(){
        return state.getName();
    }

    
    
    
}
