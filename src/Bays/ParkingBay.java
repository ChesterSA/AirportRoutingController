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
    CleaningTruck cleaningTruck;
    MaintenanceTruck maintenanceTruck;

    public ParkingBay(int BayID, DeliveryVehicles manager)
    {
        super(BayID, manager);
    }

    @Override
    public void getVehicles()
    {
        if (P != null)
        {
            manager.getCleaningTruck(P, this);
            manager.getMaintenanceTruck(P, this);
        }
    }
}
