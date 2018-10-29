/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.FuelType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class FuelTruck extends Vehicle
{

    private FuelType fuelType;
    private int planeFuelQuantity;

    public FuelTruck(FuelType fuelType, VehicleSize size, Bay location)
    {
        super(size, location);
        this.fuelType = fuelType;
    }

    @Override
    public boolean doJob(Plane p)
    {
        this.planeFuelQuantity = p.getMaxFuel()- p.getFuelQuantity();
        p.setFuelQuantity(p.getMaxFuel());
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if ((p.getMaxFuel() - p.getFuelQuantity()) <= this.planeFuelQuantity
                && this.state == new Waiting())
        {
            return this;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            return null;
        }
    }

}
