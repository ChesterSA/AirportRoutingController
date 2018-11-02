/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
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

    private final FuelType fuelType;
    private int planeFuelQuantity;

    public FuelTruck(VehicleSize size, String name, FuelType fuelType,  int planeFuelQuantity)
    {
        super(size, name);
        this.fuelType = fuelType;
        this.planeFuelQuantity = planeFuelQuantity;
    }

    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        p.setFuelQuantity(p.getMaxFuel());
        this.planeFuelQuantity = p.getMaxFuel()- p.getFuelQuantity();
        
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if ((p.getMaxFuel() - p.getFuelQuantity()) <= this.planeFuelQuantity
                && this.fuelType == p.getFuelType()
                && this.state == Waiting.state())
        {
            System.out.println("Fuel truck " + name + " found");
            return this;
        }
        else if (next != null)
        {
            System.out.println("Trying next truck");
            return next.handle(p);
        }
        else
        {
            System.out.println("no fuel found");
            return null;
        }
    }

}
