/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.CleaningType;
import Enums.VehicleSize;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class CleaningTruck extends Vehicle
{

    CleaningType cleaningType;

    public CleaningTruck(VehicleSize size, Bay location, CleaningType type)
    {
        super(size, location);
        cleaningType = type;
    }


    @Override
    public boolean doJob(Plane p) {
        p.cleanType = CleaningType.CLEAN;
        return true;
    }

    @Override
    public boolean handle(Plane p) {
        if (p.size.ordinal() <= size.ordinal() &&
            this.cleaningType.ordinal() >= p.cleanType.ordinal())    
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
