/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.VehicleStore;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class Refueling extends VehicleState
{

    @Override
    public String refuel(Vehicle v)
    {
            v.setFuel(100);
            return "All refueled";    
    }
    
}
