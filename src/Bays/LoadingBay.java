/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Enums.VehicleSize;
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

    public LoadingBay(int BayID, VehicleSize size)
    {
        super(BayID, size);
    }

    @Override
    public void getVehicles()
    {
        if (plane != null)
        {
            this.fuel = manager.getFuelTruck(plane);
            if (fuel != null)
                System.out.println("Fuel Truck arrived\n");
            
            this.catering = manager.getCateringTruck(plane);
            if (catering != null)
                System.out.println("Catering Truck arrived\n");
            
            this.ramp = manager.getRamp(plane);
            if(ramp != null)
                System.out.println("Ramp arrived\n");
        }
    }

    public void refuel()
    {
        if (fuel != null)
        {
            System.out.println("Refuelling Plane");
            fuel.executeJob(this, plane);
            
        }
    }

    public void refillFood()
    {
        if (catering != null)
        {
            System.out.println("Restocking plane food");
            catering.executeJob(this, plane);
            
        }
    }

    public void callRamp()
    {
        if (ramp != null)
        {
            System.out.println("Calling ramp");
            ramp.executeJob(this, plane);
        }
    }

    @Override
    public void update() {
        //release vehicles back to vehicle store so selected bay can use them
        fuel.driveTo(VehicleStore.getInstance());
        fuel = null;
        catering.driveTo(VehicleStore.getInstance());
        catering = null;
        ramp.driveTo(VehicleStore.getInstance());
        ramp = null;
    }

}
