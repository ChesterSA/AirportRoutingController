/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;
import airportroutingcontroller.Chainable;
import VehicleStates.Available;
import VehicleStates.DoingJob;
import VehicleStates.VehicleState;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public abstract class Vehicle implements Chainable
{
 
    protected VehicleSize size;
    protected int fuel;
    protected Bay location;
    protected VehicleState state;
    protected Chainable next;

    public Vehicle(VehicleSize size, Bay location)
    {
        this.size = size;
        this.location = location;
        this.fuel = 100;
        state = new Available();
    }

    public final boolean executeJob(Bay destination, Plane p)
    {
        boolean success = false;
        if (driveTo(location))
        {
            state = new DoingJob();
            success = doJob(p);
        }
        return success;
    }

    public boolean driveTo(Bay destination)
    {
        return state.driveTo(destination, this);
    }

    public abstract boolean doJob(Plane p);

    public void refuel()
    {
        state.refuel(this);
    }

    public void addNext(Chainable c)
    {
        this.next = c;
    }
    
    public int getFuel()
    {
        return fuel;
    }

    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }

    public Bay getLocation()
    {
        return location;
    }

    public void setLocation(Bay location)
    {
        this.location = location;
    }

    public VehicleState getState()
    {
        return state;
    }

    public void setState(VehicleState state)
    {
        this.state = state;
    }
}
