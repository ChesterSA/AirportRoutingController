/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.Bay;
import Bays.Location;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class Broken extends VehicleState
{

    @Override
    public boolean refuel(Vehicle v)
    {
        return false;
    }

    @Override
    public boolean driveTo(Location destination, Vehicle v)
    {
        return false;
    }

}
