/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Vehicles.CleaningTruck;
import Vehicles.MaintenanceTruck;
import airportroutingcontroller.DeliveryVehicles;

/**
 *
 * @author s6089488
 */
public class ParkingBay extends Bay
{
    CleaningTruck cleaning;
    MaintenanceTruck maintenance;

    public ParkingBay(int BayID, DeliveryVehicles manager)
    {
        super(BayID, manager);
    }

    @Override
    public void getVehicles()
    {
        if (plane != null)
        {
            this.cleaning = manager.getCleaningTruck(plane, this);
            this.maintenance = manager.getMaintenanceTruck(plane, this);
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
        if(maintenance != null)
        {
            maintenance.executeJob(this, plane);
        }
    }
}
