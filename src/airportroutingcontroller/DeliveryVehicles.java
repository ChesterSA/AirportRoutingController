/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.*;
import Vehicles.*;

/**
 *
 * @author s6089488
 */
public class DeliveryVehicles
{

    static private DeliveryVehicles instance;

    private FuelTruck firstFuel;
    private CateringTruck firstCatering;
    private Ramp firstRamp;
    private CleaningTruck firstCleaning;
    private MaintenanceTruck firstMaintenance;

    private DeliveryVehicles()
    {

    }

    static public DeliveryVehicles getInstance()
    {
        if (instance == null)
        {
            instance = new DeliveryVehicles();
        }
        return instance;
    }

    public FuelTruck getFuelTruck(Plane plane, LoadingBay bay)
    {
        return (FuelTruck) firstFuel.handle(plane);
    }

    public CateringTruck getCateringTruck(Plane plane, LoadingBay bay)
    {
        return (CateringTruck) firstCatering.handle(plane);
    }

    public Ramp getRamp(Plane plane, LoadingBay bay)
    {
        return (Ramp) firstRamp.handle(plane);
    }

    public CleaningTruck getCleaningTruck(Plane plane, ParkingBay bay)
    {
        return (CleaningTruck) firstCleaning.handle(plane);
    }

    public MaintenanceTruck getMaintenanceTruck(Plane plane, ParkingBay bay)
    {
        return (MaintenanceTruck) firstMaintenance.handle(plane);
    }

    public void setFirstFuel(FuelTruck firstFuel)
    {
        this.firstFuel = firstFuel;
    }

    public void setFirstCatering(CateringTruck firstCatering)
    {
        this.firstCatering = firstCatering;
    }

    public void setFirstRamp(Ramp firstRamp)
    {
        this.firstRamp = firstRamp;
    }

    public void setFirstCleaning(CleaningTruck firstCleaning)
    {
        this.firstCleaning = firstCleaning;
    }

    public void setFirstMaintenance(MaintenanceTruck firstMaintenance)
    {
        this.firstMaintenance = firstMaintenance;
    }

}
