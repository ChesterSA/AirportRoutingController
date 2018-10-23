/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import VehicleStates.Available;
import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class VehicleStore extends Location
{
    static private VehicleStore instance;

    
    
    private VehicleStore()
    {
        
    }
    
    static public VehicleStore getInstance()
    {
        if (instance == null)
        {
            instance = new VehicleStore();
        }
        return instance;
    }

    
    public static void refuel(Vehicle v)
    {
        v.setFuel(100);
        v.setState(new Available());
    }
    
}
