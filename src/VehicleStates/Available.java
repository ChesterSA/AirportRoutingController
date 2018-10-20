/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class Available extends VehicleState{
    
    @Override
    public boolean DoJob(Vehicle v) {
        v.state = new DoingJob();
        return true;
    }

    @Override
    public boolean Refuel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
