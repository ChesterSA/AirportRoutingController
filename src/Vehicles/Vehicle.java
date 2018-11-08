/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Vehicles;

import Bays.*;
import Enums.VehicleSize;
import airportroutingcontroller.Chainable;
import VehicleStates.*;
import airportroutingcontroller.DeliveryVehicles;

/**
 * Vehicle abstract class
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public abstract class Vehicle implements Chainable
{
    /**
     * the name of the vehicle, used for identification
     */
    protected String name;
    
    /**
     * size of the vehicle
     */
    protected VehicleSize size;
    
    /**
     * how much fuel the vehicle has
     */
    protected int fuel;
    
    /**
     * location of the vehicle
     */
    protected Location location;
    
    /**
     * current state of the vehicle
     */
    protected VehicleState state;
    
    /**
     * the next vehicle in the chain
     */
    protected Chainable next;

    /**
     * constructor for vehicles
     * @param size the size of the vehicle
     * @param name the name of the vehicle, used as an identifier
     */
    public Vehicle(VehicleSize size, String name)
    {
        this.size = size;
        this.name = name;
        this.location = VehicleStore.getInstance();
        this.fuel = 100;
        this.state = Waiting.state();
        
        DeliveryVehicles.getInstance().addToChain(this);
    }

    /**
     * template method, call driveto(), then doJon() then driveTo() for every vehicle
     * @param destination where the vehicle needs to go for the job
     */
    public final void executeJob(Bay destination)
    {
        if (driveTo(destination))
        {
            System.out.println(name + " STATE = DOINGJOB");
            state = DoingJob.state();
            doJob();
            System.out.println("The job has been succesfully executed\n");
            System.out.println(name + " STATE = WAITING");
            state = Waiting.state();
        }
        else
        {
            System.out.println("Vehicle cannot drive to location");
            System.out.println("Refueling instead");
            refuel();
        }
    }

    /**
     * changes the vehicles location to destination, 
     * changes state to driving while working
     * @param destination where to drive to
     * @return a boolean indicating the success
     */
    public boolean driveTo(Location destination)
    {
        boolean success = false;
        if (fuel > 10)
        {
            System.out.println(name + " STATE = DRIVING");
            state = Driving.state();
            System.out.println(name + " is driving to " + destination.getName());
            fuel -= 10;
            System.out.println(name + "'s fuel is now " + fuel);
            location = destination;
            success = true;
        }
        else if (fuel == 10 && destination == VehicleStore.getInstance())
        {
            System.out.println(name + " does not have enough fuel");
            refuel();
        }
        state = Waiting.state();
        return success;
        
    }
    
    /**
     * doJob, overriden by all vehicles
     * @return 
     */
    protected abstract boolean doJob();
    
    /**
     * Cancels whatever job a vehicle is performing and returns to waiting state
     * @return a string confirming the vehicle's state has changed
     */
    public String cancel()
    {
        setState(Waiting.state());
        
        return getName() + " is now waiting";
    }

    /**
     * calls the vehicle state to see if the vehicle can refuel
     * @return a string indicating whether it worked
     */
    public String refuel()
    {
        return state.refuel(this);
    }
    
    /**
     * getter for name object
     * @return the name as a string
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * getter for fuel
     * @return the fuel object
     */
    public int getFuel()
    {
        return fuel;
    }

    /**
     * setter for the fuel object
     * @param fuel 
     */
    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }

    /**
     * setter for the state
     * @param state to be set to
     */
    public void setState(VehicleState state)
    {
        this.state = state;
    }
    
    /**
     * getter for the state
     * @return the state the vehicle is currently in
     */
    public VehicleState getState()
    {
        return state;
    }
    
    
}
