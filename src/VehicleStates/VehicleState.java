/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * Vehicle state, extended by all states
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public abstract class VehicleState
{
    /**
     * The method for refuelling, overridden by all classes
     * @param v the vehicle to be refueled
     * @return a string describing the refueling
     */
    public abstract String refuel(Vehicle v);
    
}
