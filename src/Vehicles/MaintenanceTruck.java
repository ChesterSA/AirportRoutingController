/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.MaintenanceType;
import Enums.VehicleSize;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class MaintenanceTruck extends Vehicle
{

    MaintenanceType type;

    public MaintenanceTruck(MaintenanceType type, VehicleSize size, Bay location)
    {
        super(size, location);
        this.type = type;
    }

    @Override
    public boolean doJob(Plane p)
    {
        p.maintenance = MaintenanceType.FIXED;
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if (p.size.ordinal() <= this.size.ordinal()
                && p.maintenance.ordinal() <= this.type.ordinal())
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
