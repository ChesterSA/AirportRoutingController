/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class CateringTruck extends Vehicle
{

    private int foodQuantity;

    public CateringTruck(VehicleSize size, int foodQuantity, Bay location)
    {
        super(size, location);
        this.foodQuantity = foodQuantity;
    }

    @Override
    public boolean doJob(Plane p)
    {
        this.foodQuantity = p.getMaxFood() - p.getFoodQuantity();
        p.setFoodQuantity(p.getMaxFood());
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if ((p.getMaxFood() - p.getFoodQuantity()) <= this.foodQuantity
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
