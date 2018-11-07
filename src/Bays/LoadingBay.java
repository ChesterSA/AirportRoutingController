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
import Vehicles.Vehicle;
import airportroutingcontroller.BayChainable;

/**
 * Loading bay, inherits from Bay Refuels, restocks food, and gets ramp for
 * plane
 *
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class LoadingBay extends Bay
{

    /**
     * the fuel truck present at the Loading Bay
     */
    private FuelTruck fuel;

    /**
     * the catering truck present at the Loading Bay
     */
    private CateringTruck catering;

    /**
     * the ramp present at the Loading Bay
     */
    private Ramp ramp;

    /**
     * constructor for the LoadingBay class
     *
     * @param bayID the id for the LoadingBay
     * @param size the size of vehicle it can take
     */
    public LoadingBay(int bayID, VehicleSize size)
    {
        super(bayID, size);
        name = "Loading Bay " + bayID;
    }

    /**
     * gets the fuel, catering, and ramp vehicles for the plane
     */
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

    /**
     * fills the plane's fuel back to maximum using a FuelTruck
     */
    public void refuel()
    {
        if (fuel != null)
        {
            System.out.println("Refuelling Plane");
            fuel.executeJob(this);
        }
    }

    /**
     * refills the plane's food using a CateringTruck
     */
    public void refillFood()
    {
        if (catering != null)
        {
            System.out.println("Restocking plane food");
            catering.executeJob(this);
        }
    }

    /**
     * calls a Ramp object for the plane to use
     */
    public void callRamp()
    {
        if (ramp != null)
        {
            System.out.println("Calling ramp");
            ramp.executeJob(this);
        }
    }

    /**
     * releases any present vehicles to the Vehicle store so other bays can use
     * them
     */
    @Override
    public void update()
    {
        Vehicle[] vehicles = new Vehicle[]
        {
            fuel, catering, ramp
        };

        for (Vehicle v : vehicles)
        {
            if (v != null)
            {
                System.out.println(v.getName() + " returns to vehicle store");
                v.driveTo(VehicleStore.getInstance());
                
                if (v instanceof FuelTruck)
                    fuel = null;
                else if (v instanceof CateringTruck)
                    catering = null;
                else if (v instanceof Ramp)
                    ramp = null;                    
            }
        }
        
        if (fuel != null)
            {
                System.out.println(fuel.getName() + " returns to vehicle store");
                fuel.driveTo(VehicleStore.getInstance());
                fuel = null;
            }
    }

    @Override
    public void initiate()
    {
        getVehicles();

        refuel();
        refillFood();
        callRamp();
    }
    
    
    @Override
    public void addToChain(Bay b)
    {
        if (b instanceof LoadingBay)
        {
            if (this.next == null)
            {
                addNext(b);
            }
            else
            {
                next.addToChain(b);
            }
        }
    }

}
