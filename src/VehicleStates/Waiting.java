/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Bays.VehicleStore;
import Vehicles.Vehicle;

/**
 * Waiting state, used by vehicles while doing nothing else
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Waiting implements VehicleState
{
    /**
     * Instance used for singleton pattern
     */
    static Waiting instance;

    /**
     * private constructor for singleton
     */
    private Waiting()
    {      
    }
    
    /**
     * state instance method
     * @return the Waiting state object
     */
    public static Waiting state()
    {
        if (instance == null)
        {
            instance = new Waiting();
        }
        return instance;
    }
    
    /**
     * The method used by vehicles to refuel
     * @param v the vehicle to refuel
     * @return a string confirming refueling was successful
     */
    @Override
    public String refuel(Vehicle v)
    {
        v.driveTo(VehicleStore.getInstance());
        v.setState(Refueling.state()); 
        
        System.out.println(v.getName() + " is refueling");
        return v.getName() + " is driving to refuel\n" + v.refuel();
    }
}
