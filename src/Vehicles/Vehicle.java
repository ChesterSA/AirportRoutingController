/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
import Enums.VehicleSize;
import airportroutingcontroller.Chainable;
import VehicleStates.Waiting;
import VehicleStates.DoingJob;
import VehicleStates.Driving;
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
    protected Location location;
    protected VehicleState state;
    protected Chainable next;

    public Vehicle(VehicleSize size, Bay location)
    {
        this.size = size;
        this.location = location;
        this.fuel = 100;
        state = new Waiting();
    }

    public final void executeJob(Bay destination, Plane p)
    {
        if (driveTo(location))
        {
            state = new DoingJob();
            doJob(p);
            System.out.println("The job has been succesfully executed");
            state = new Waiting();
        }
        else
        {
            System.out.println("You don't have enough fuel to drive");
            state = new Waiting();
        }
    }

    public boolean driveTo(Location destination)
    {
        boolean success = false;
        state = new Driving();
        if (fuel > 10)
        {
            System.out.println("Driving to destination");
            fuel -= 10;
            location = destination;
            success = true;
        }
        return success;
        
    }

    public abstract boolean doJob(Plane p);

    public String refuel()
    {
        return state.refuel(this);
    }

    @Override
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

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
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
