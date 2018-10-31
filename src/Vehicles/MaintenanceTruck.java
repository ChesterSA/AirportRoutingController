/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.MaintenanceType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class MaintenanceTruck extends Vehicle
{

    private final MaintenanceType type;

    public MaintenanceTruck(MaintenanceType type, VehicleSize size)
    {
        super(size);
        this.type = type;
    }

    @Override
    public boolean doJob()
    {
        System.out.println("Fixing truck");
        Bay current = (Bay)location;
        current.getPlane().setMaintenance(MaintenanceType.FIXED);
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if (p.getSize().ordinal() <= this.size.ordinal()
                && p.getMaintenance().ordinal() <= this.type.ordinal()
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
