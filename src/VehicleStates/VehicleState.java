/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.Location;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public abstract class VehicleState
{

    public abstract boolean refuel(Vehicle v);

    public abstract boolean driveTo(Location destination, Vehicle v);
}
