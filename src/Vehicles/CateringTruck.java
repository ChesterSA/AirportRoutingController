/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class CateringTruck extends Vehicle
{

    private int foodQuantity;

    public CateringTruck(VehicleSize size, String name, int foodQuantity)
    {
        super(size, name);
        this.foodQuantity = foodQuantity;
    }

    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        this.foodQuantity = p.getMaxFood() - p.getFoodQuantity();
        p.setFoodQuantity(p.getMaxFood());
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if ((p.getMaxFood() - p.getFoodQuantity()) <= this.foodQuantity
                && this.state == Waiting.state())
        {
            System.out.println("Catering truck " + name + " found");
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
