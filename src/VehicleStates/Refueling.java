/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * Refueling state, used by vehicles while refueling
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Refueling extends VehicleState
{
    /**
     * Instance used for singleton pattern
     */
    static Refueling instance;
    
    /**
     * private constructor for singleton
     */
    private Refueling()
    {      
    }
    
    /**
     * state instance method
     * @return the Refueling state object
     */
    public static Refueling state()
    {
        if (instance == null)
        {
            instance = new Refueling();
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
        v.setFuel(100);
        System.out.println(v.getName() + " is refueled");
        return v.getName() + " is refueled";
    }

}
