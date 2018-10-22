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

    private FuelTruck firstFuel;
    private CateringTruck firstCatering;
    private Ramp firstRamp;
    private CleaningTruck firstCleaning;
    private MaintenanceTruck firstMaintenance;

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
}
