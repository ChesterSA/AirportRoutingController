/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Enums.VehicleSize;
import Vehicles.CleaningTruck;
import Vehicles.MaintenanceTruck;

/**
 *
 * @author s6089488
 */
public class ParkingBay extends Bay
{

    private CleaningTruck cleaning;
    private MaintenanceTruck maintenance;

    public ParkingBay(int bayID, VehicleSize size)
    {
        super(bayID, size);
        name = "Parking Bay " + bayID;
    }

    @Override
    public void getVehicles()
    {
        if (plane != null)
        {
            this.cleaning = manager.getCleaningTruck(plane);
            this.maintenance = manager.getMaintenanceTruck(plane);
        }
    }

    public void clean()
    {
        if (cleaning != null)
        {
            cleaning.executeJob(this, plane);
        }

    }

    public void fixPlane()
    {
        if (maintenance != null)
        {
            maintenance.executeJob(this, plane);
        }
    }

    @Override
    public void update()
    {
        cleaning.driveTo(VehicleStore.getInstance());
        cleaning = null;
        maintenance.driveTo(VehicleStore.getInstance());
        maintenance = null;
    }
}
