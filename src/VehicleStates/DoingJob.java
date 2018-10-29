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

    @Override
    public String refuel(Vehicle v)
    {
        return "You can't refuel right now";
    }
    
}