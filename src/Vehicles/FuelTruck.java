/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.FuelType;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class FuelTruck extends Vehicle
{

    FuelType fuelType;

    public FuelTruck(FuelType fuelType, VehicleSize size, Bay location)
    {
        super(size, location);
        this.fuelType = fuelType;
    }

    @Override
    public boolean doJob()
    {
        // Do Fueling idk
        return true;
    }

}
