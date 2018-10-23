/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.Bay;
import Bays.Location;
import Bays.VehicleStore;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class Available extends VehicleState
{

    @Override
    public boolean refuel(Vehicle v)
    {
        v.driveTo(VehicleStore.getInstance());
        VehicleStore.refuel(v);
        return true;
    }

    @Override
    public boolean driveTo(Location destination, Vehicle v)
    {
        v.setState(new Driving());
        v.setLocation(destination);
        v.setFuel(v.getFuel()-10);
        
        if (v.getFuel() > 10)
        {
            v.setState(new Available());
        }
        else
        {
            v.setState(new OutOfFuel());
        }

        return true;
    }

}
