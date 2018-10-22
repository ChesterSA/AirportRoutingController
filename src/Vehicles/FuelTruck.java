/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.FuelType;
import Enums.VehicleSize;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class FuelTruck extends Vehicle
{

    FuelType fuelType;
    int planeFuelQuantity;

    public FuelTruck(FuelType fuelType, VehicleSize size, Bay location)
    {
        super(size, location);
        this.fuelType = fuelType;
    }

    @Override
    public boolean doJob(Plane p) {
       this.planeFuelQuantity = p.maxFuel - p.fuelQuantity;
        p.fuelQuantity = p.maxFuel;
        return true;
    }

    @Override
    public boolean handle(Plane p) {
        if ((p.maxFuel- p.fuelQuantity) <= this.planeFuelQuantity)
        {
            return true;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            return false;
        }
    }

}
