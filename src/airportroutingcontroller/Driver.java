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
        //Initialising Planes
        Plane smallPlane = new Plane("SML123", 100, 75, 250, 150, FuelType.AVGAS, VehicleSize.SMALL, CleaningType.MODERATE, RampType.OPEN, MaintenanceType.FIXED);
        Plane mediumPlane = new Plane("MED456", 250, 25, 500, 20, FuelType.AVGAS, VehicleSize.MEDIUM, CleaningType.SIMPLE, RampType.ENCLOSED, MaintenanceType.FIXED);
        Plane largePlane = new Plane("LRG789", 500, 400, 750, 600, FuelType.AVGAS, VehicleSize.LARGE, CleaningType.SEVERE, RampType.ENCLOSED, MaintenanceType.STANDARD);
        Plane jet = new Plane("JETX2", 0, 0, 250, 100, FuelType.JET_A1, VehicleSize.SMALL, CleaningType.CLEAN, RampType.OPEN, MaintenanceType.SPECIALIST);

        //Initialising Vehicles
        FuelTruck smallFuel = new FuelTruck(VehicleSize.SMALL, "smlFuel", FuelType.AVGAS,  150);
        FuelTruck mediumFuel = new FuelTruck(VehicleSize.MEDIUM, "medFuel", FuelType.AVGAS, 500);
        FuelTruck largeFuel = new FuelTruck(VehicleSize.LARGE, "lrgFuel", FuelType.AVGAS, 300);
        FuelTruck jetFuel = new FuelTruck(VehicleSize.SMALL, "jetFuel", FuelType.JET_A1, 200);

        CateringTruck smallCatering = new CateringTruck(VehicleSize.SMALL, "smlCater", 50);
        CateringTruck mediumCatering = new CateringTruck(VehicleSize.MEDIUM, "medCater", 250);
        CateringTruck largeCatering = new CateringTruck(VehicleSize.LARGE, "lrgCater", 300);

        Ramp smallEnclosed = new Ramp(VehicleSize.SMALL, "smlRmpEnc", RampType.ENCLOSED);
        Ramp mediumEnclosed = new Ramp(VehicleSize.MEDIUM, "medRmpEnc", RampType.ENCLOSED);
        Ramp largeEnclosed = new Ramp(VehicleSize.LARGE, "lrgRmpEnc", RampType.ENCLOSED);
        Ramp smallOpen = new Ramp(VehicleSize.SMALL, "smlRmpOpn", RampType.OPEN);
        Ramp mediumOpen = new Ramp(VehicleSize.MEDIUM, "medRmpOpn", RampType.OPEN);
        Ramp largeOpen = new Ramp(VehicleSize.LARGE, "lrgRmpOpn", RampType.OPEN);


        CleaningTruck smallCleaning = new CleaningTruck(VehicleSize.SMALL, "smlClean", CleaningType.SIMPLE);
        CleaningTruck largeCleaning = new CleaningTruck(VehicleSize.LARGE, "lrgClean", CleaningType.SEVERE);

        MaintenanceTruck smallMaintenance = new MaintenanceTruck(VehicleSize.SMALL, "smlMaint", MaintenanceType.STANDARD);
        MaintenanceTruck largeMaintenance = new MaintenanceTruck(VehicleSize.LARGE, "lrgMaint", MaintenanceType.STANDARD);      
        MaintenanceTruck specialistMaintenance = new MaintenanceTruck(VehicleSize.MEDIUM, "medMaint", MaintenanceType.SPECIALIST);
        
        //Setting chains for vehicles
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

        //Initialising Bays
        LoadingBay smallLoading = new LoadingBay(1, VehicleSize.SMALL);
        LoadingBay mediumLoading = new LoadingBay(2, VehicleSize.MEDIUM);
        LoadingBay largeLoading = new LoadingBay(3, VehicleSize.LARGE);

        ParkingBay smallParking = new ParkingBay(4, VehicleSize.SMALL);
        ParkingBay mediumParking = new ParkingBay(5, VehicleSize.MEDIUM);
        ParkingBay largeParking = new ParkingBay(6, VehicleSize.LARGE);

        //Initialising Chains for bays
        smallLoading.addNext(mediumLoading);
        mediumLoading.addNext(largeLoading);

        smallParking.addNext(mediumParking);
        mediumParking.addNext(largeParking);

        //Add vehicle chains to delivery manager
        DeliveryVehicles.getInstance().setFirstFuel(smallFuel);
        DeliveryVehicles.getInstance().setFirstCatering(smallCatering);
        DeliveryVehicles.getInstance().setFirstRamp(smallEnclosed);
        DeliveryVehicles.getInstance().setFirstCleaning(smallCleaning);
        DeliveryVehicles.getInstance().setFirstMaintenance(smallMaintenance);

        //Add bay chains to ARC 
        AirportRoutingController.setFirstLoadingBay(smallLoading);
        AirportRoutingController.setFirstParkingBay(smallParking);

        AirportRoutingController arc = new AirportRoutingController();

        arc.handlePlane(smallPlane);
        managePlane(smallPlane, arc);

        arc.handlePlane(mediumPlane);
        managePlane(mediumPlane, arc);
        
        arc.handlePlane(largePlane);
        managePlane(largePlane, arc);
    }

    public static void managePlane(Plane p, AirportRoutingController arc)
    {
        if (p.getParkingBay() != null)
        {
            ParkingBay pb = p.getParkingBay();
            pb.getVehicles();

            pb.fixPlane();
            pb.clean();

            arc.handlePlane(p);
        }

        LoadingBay lb = p.getLoadingBay();
        lb.getVehicles();

        lb.refuel();
        lb.refillFood();
        lb.callRamp();
        
        lb.finishPlane();
    }
}