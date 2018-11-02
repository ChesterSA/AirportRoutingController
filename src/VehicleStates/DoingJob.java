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
public class DoingJob extends VehicleState
{
    static DoingJob instance;

    private DoingJob()
    {      
    }
    
    public static DoingJob state()
    {
        if (instance == null)
        {
            instance = new DoingJob();
        }
        return instance;
    }
    
    @Override
    public String refuel(Vehicle v)
    {
        System.out.println(v.getName() + " is doing a job and can't refuel");
        return v.getName() + " is doing a job and can't refuel";
    }
    
}