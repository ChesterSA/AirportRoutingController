/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;
import VehicleStates.Available;
import VehicleStates.DoingJob;
import VehicleStates.VehicleState;

/**
 *
 * @author s6089488
 */
public abstract class Vehicle
{

    VehicleSize size;
    public int fuel;
    public Bay location;
    public VehicleState state;

    public Vehicle(VehicleSize size, Bay location)
    {
        this.size = size;
        this.location = location;
        this.fuel = 100;
        state = new Available();
    }

    public final boolean executeJob(Bay destination)
    {
        boolean success = false;
        if (driveTo(location))
        {
            state = new DoingJob();
            success = doJob();
        }
        return success;
    }

    private boolean driveTo(Bay destination)
    {
        return state.driveTo(destination, this);
    }

    public abstract boolean doJob();

    public void refuel()
    {
        state.refuel(this);
    }
}
