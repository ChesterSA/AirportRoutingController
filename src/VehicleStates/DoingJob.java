/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * DoingJob state, used by vehicles while doing job
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class DoingJob extends VehicleState
{
    /**
     * Instance used for singleton pattern
     */
    static DoingJob instance;

    /**
     * private constructor for singleton
     */
    private DoingJob()
    {      
    }
    
    /**
     * state instance method
     * @return the DoingJob state object
     */
    public static DoingJob state()
    {
        if (instance == null)
        {
            instance = new DoingJob();
        }
        return instance;
    }
    
    /**
     * Stops the vehicle refueling while in this state
     * 
     * @param v the Vehicle to refuel
     * @return a string explaining that refueling failed
     */
    @Override
    public String refuel(Vehicle v)
    {
        System.out.println(v.getName() + " is doing a job and can't refuel");
        return v.getName() + " is doing a job and can't refuel";
    }
    
}