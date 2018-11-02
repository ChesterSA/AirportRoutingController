/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 *
 * @author s6089488
 */
public class Refueling extends VehicleState
{
    static Refueling instance;

    private Refueling()
    {      
    }
    
    public static Refueling state()
    {
        if (instance == null)
        {
            instance = new Refueling();
        }
        return instance;
    }
    
    @Override
    public String refuel(Vehicle v)
    {
        v.setFuel(100);
        System.out.println(v.getName() + " is refueled");
        return v.getName() + " is refueled";
    }

}
