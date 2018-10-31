/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Enums.*;
import Vehicles.*;
import Bays.LoadingBay;
import Bays.ParkingBay;

/**
 *
 * @author s6089488
 */
public class Driver
{
    public static void main(String[] args)
    {
        Plane smallPlane = new Plane(100, 75, 250, 150, FuelType.AVGAS, VehicleSize.SMALL, CleaningType.MODERATE, RampType.OPEN, MaintenanceType.FIXED);
        Plane mediumPlane = new Plane(250, 25, 500, 20, FuelType.AVGAS, VehicleSize.MEDIUM, CleaningType.SIMPLE, RampType.ENCLOSED, MaintenanceType.FIXED);
        Plane largePlane = new Plane(500, 400, 750, 600, FuelType.AVGAS, VehicleSize.LARGE, CleaningType.SEVERE, RampType.ENCLOSED, MaintenanceType.STANDARD);       
        Plane jet = new Plane(0,0, 250, 100, FuelType.JET_A1, VehicleSize.SMALL, CleaningType.CLEAN, RampType.OPEN, MaintenanceType.SPECIALIST);
        
        FuelTruck smallFuel = new FuelTruck(FuelType.AVGAS, VehicleSize.SMALL, 150);
        FuelTruck mediumFuel = new FuelTruck(FuelType.AVGAS, VehicleSize.MEDIUM, 500);
        FuelTruck largeFuel = new FuelTruck(FuelType.AVGAS, VehicleSize.LARGE, 300);
        FuelTruck jetFuel = new FuelTruck(FuelType.JET_A1, VehicleSize.SMALL, 200);
        
        CateringTruck smallCatering = new CateringTruck(VehicleSize.SMALL, 50);
        CateringTruck mediumCatering = new CateringTruck(VehicleSize.MEDIUM, 250);
        CateringTruck largeCatering = new CateringTruck(VehicleSize.LARGE, 300);
        
        Ramp smallEnclosed = new Ramp(RampType.ENCLOSED, VehicleSize.SMALL);
        Ramp mediumEnclosed = new Ramp(RampType.ENCLOSED, VehicleSize.MEDIUM);
        Ramp largeEnclosed = new Ramp(RampType.ENCLOSED, VehicleSize.LARGE);
        Ramp smallOpen = new Ramp(RampType.OPEN, VehicleSize.SMALL);
        Ramp mediumOpen = new Ramp(RampType.OPEN, VehicleSize.MEDIUM);
        Ramp largeOpen = new Ramp(RampType.OPEN, VehicleSize.LARGE);
        
        CleaningTruck smallCleaning = new CleaningTruck(VehicleSize.SMALL, CleaningType.SIMPLE);
        CleaningTruck largeCleaning = new CleaningTruck(VehicleSize.LARGE, CleaningType.SEVERE);
        
        MaintenanceTruck smallMaintenance = new MaintenanceTruck(MaintenanceType.STANDARD, VehicleSize.SMALL);
        MaintenanceTruck largeMaintenance = new MaintenanceTruck(MaintenanceType.STANDARD, VehicleSize.LARGE);
        MaintenanceTruck specialistMaintenance = new MaintenanceTruck(MaintenanceType.SPECIALIST, VehicleSize.MEDIUM);
        
        
        smallFuel.addNext(mediumFuel);
        mediumFuel.addNext(largeFuel);
        largeFuel.addNext(jetFuel);
        
        smallCatering.addNext(mediumCatering);
        mediumCatering.addNext(largeCatering);
        
        smallEnclosed.addNext(mediumEnclosed);
        mediumEnclosed.addNext(largeEnclosed);
        largeEnclosed.addNext(smallOpen);
        smallOpen.addNext(mediumOpen);
        mediumOpen.addNext(largeOpen);
        
        smallCleaning.addNext(largeCleaning);
        
        smallMaintenance.addNext(largeMaintenance);
        largeMaintenance.addNext(specialistMaintenance);
        
        
    }
}
