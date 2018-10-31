/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
import Enums.CleaningType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class CleaningTruck extends Vehicle
{

    private final CleaningType cleaningType;

    public CleaningTruck(VehicleSize size, CleaningType type)
    {
        super(size);
        cleaningType = type;
    }

    @Override
    public boolean doJob()
    {
        System.out.println("Cleaning Plane");
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        p.setCleanType(CleaningType.CLEAN);
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if (p.getSize().ordinal() <= size.ordinal()
                && this.cleaningType.ordinal() >= p.getCleanType().ordinal()
                //&& this.state == new Waiting()
                )
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
