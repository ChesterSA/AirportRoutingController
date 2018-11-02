/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
import Bays.VehicleStore;
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
    protected String name;
    protected VehicleSize size;
    protected int fuel;
    protected Location location;
    protected VehicleState state;
    protected Chainable next;

    public Vehicle(VehicleSize size, String name)
    {
        this.size = size;
        this.name = name;
        this.location = VehicleStore.getInstance();
        this.fuel = 100;
        this.state = new Waiting();
    }

    public final void executeJob(Bay destination, Plane p)
    {
        if (driveTo(destination))
        {
            location = destination;
            state = new DoingJob();
            doJob();
            System.out.println("The job has been succesfully executed\n");
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
        
        if (fuel > 10)
        {
            state = new Driving();
            System.out.println(name + " is driving to " + destination.getName());
            fuel -= 10;
            System.out.println(name + "'s fuel is now " + fuel);
            location = destination;
            success = true;
        }
        else
        {
            System.out.println(name + " does not have enough fuel");
            refuel();
        }
        return success;
        
    }

    public abstract boolean doJob();

    public String refuel()
    {
        return state.refuel(this);
    }

    @Override
    public void addNext(Chainable c)
    {
        this.next = c;
    }

    public String getName()
    {
        return name;
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
