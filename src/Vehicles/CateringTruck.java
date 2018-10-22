/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class CateringTruck extends Vehicle
{
    int foodQuantity;

    public CateringTruck(VehicleSize size, int foodQuantity, Bay location)
    {
        super(size, location);
        this.foodQuantity = foodQuantity;
    }

    @Override
    public boolean doJob(Plane p) {
        this.foodQuantity = p.maxFood - p.foodQuantity;
        p.foodQuantity = p.maxFood;
        return true;
    }

    @Override
    public Vehicle handle(Plane p) {
        if ((p.maxFood - p.foodQuantity) <= this.foodQuantity)
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
