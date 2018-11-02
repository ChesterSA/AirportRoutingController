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
public class Driving extends VehicleState
{
    static Driving instance;

    private Driving()
    {      
    }
    
    public static Driving state()
    {
        if (instance == null)
        {
            instance = new Driving();
        }
        return instance;
    }
    
    @Override
    public String refuel(Vehicle v)
    {
        System.out.println(v.getName() + " is driving and can't refuel");
        return v.getName() + " is driving and can't refuel";
    }
    
}
