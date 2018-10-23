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
public class Available extends VehicleState
{

    @Override
    public boolean refuel(Vehicle v)
    {
        v.setFuel(100);
        return true;
    }

    @Override
    public boolean driveTo(Bay destination, Vehicle v)
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
