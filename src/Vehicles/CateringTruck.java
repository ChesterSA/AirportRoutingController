/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class CateringTruck extends Vehicle
{

    int foodQuantity;

    public CateringTruck(int foodQuantity, VehicleSize size, Bay location)
    {
        super(size, location);
        this.foodQuantity = foodQuantity;
    }

    @Override
    public boolean doJob()
    {
        //DO THE CATERING
        return true;
    }

}
