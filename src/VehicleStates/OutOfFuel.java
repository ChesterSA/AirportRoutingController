/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.Bay;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class OutOfFuel extends VehicleState{

    @Override
    public boolean Refuel(Vehicle v) {
        v.fuel = 100;
        return true;
    }

    @Override
    public boolean DriveTo(Bay destination, Vehicle v) {
        return false;
    }
    
}
