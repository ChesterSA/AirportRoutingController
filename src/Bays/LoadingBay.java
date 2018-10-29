/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Vehicles.CateringTruck;
import Vehicles.FuelTruck;
import Vehicles.Ramp;

/**
 *
 * @author s6089488
 */
public class LoadingBay extends Bay
{

    private FuelTruck fuel;
    private CateringTruck catering;
    private Ramp ramp;

    public LoadingBay(int BayID)
    {
        super(BayID);
    }

    @Override
    public void getVehicles()
    {
        if (plane != null)
        {
            this.fuel = manager.getFuelTruck(plane);
            this.catering = manager.getCateringTruck(plane);
            this.ramp = manager.getRamp(plane);
        }
    }

    public void refuel()
    {
        if (fuel != null)
        {
            fuel.executeJob(this, plane);
        }
    }

    public void refillFood()
    {
        if (catering != null)
        {
            catering.executeJob(this, plane);
        }
    }

    public void callRamp()
    {
        if (ramp != null)
        {
            ramp.executeJob(this, plane);
        }
    }

    @Override
    public void update() {
        //release vehicles back to vehicle store so selected bay can use them
        fuel.driveTo(VehicleStore.getInstance());
        catering.driveTo(VehicleStore.getInstance());
        ramp.driveTo(VehicleStore.getInstance());
    }

}
