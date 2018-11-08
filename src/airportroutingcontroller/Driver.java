/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package airportroutingcontroller;

import Enums.*;
import Vehicles.*;
import Locations.LoadingBay;
import Locations.ParkingBay;
import java.util.ArrayList;

/**
 * Driver, runs a simulation of the airport
 *
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public class Driver
{

    /**
     * main method, instantiates planes and vehicles then runs a simulation
     *
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<Plane> planes = new ArrayList<>();
        
        //Initialising Planes
        planes.add(new Plane("SML1", 100, 75, 250, 150, FuelType.AVGAS, VehicleSize.SMALL, CleaningType.MODERATE, RampType.OPEN, MaintenanceType.FIXED));
        planes.add(new Plane("MED1", 250, 25, 500, 20, FuelType.AVGAS, VehicleSize.MEDIUM, CleaningType.SIMPLE, RampType.ENCLOSED, MaintenanceType.FIXED));
        planes.add(new Plane("LRG1", 500, 400, 750, 600, FuelType.AVGAS, VehicleSize.LARGE, CleaningType.SEVERE, RampType.ENCLOSED, MaintenanceType.STANDARD));
        planes.add( new Plane("JETX1", 0, 0, 250, 100, FuelType.JET_A1, VehicleSize.SMALL, CleaningType.CLEAN, RampType.OPEN, MaintenanceType.SPECIALIST)); 
        
        planes.add(new Plane("SML2", 100, 75, 250, 150, FuelType.AVGAS, VehicleSize.SMALL, CleaningType.MODERATE, RampType.OPEN, MaintenanceType.FIXED));
        planes.add(new Plane("MED2", 250, 25, 500, 20, FuelType.AVGAS, VehicleSize.MEDIUM, CleaningType.SIMPLE, RampType.ENCLOSED, MaintenanceType.FIXED));
        planes.add(new Plane("LRG2", 500, 400, 750, 600, FuelType.AVGAS, VehicleSize.LARGE, CleaningType.SEVERE, RampType.ENCLOSED, MaintenanceType.STANDARD));
        planes.add(new Plane("JETX2", 0, 0, 250, 100, FuelType.JET_A1, VehicleSize.SMALL, CleaningType.CLEAN, RampType.OPEN, MaintenanceType.SPECIALIST));
        
        planes.add(new Plane("SML3", 100, 75, 250, 150, FuelType.AVGAS, VehicleSize.SMALL, CleaningType.MODERATE, RampType.OPEN, MaintenanceType.FIXED));
        planes.add(new Plane("MED3", 250, 25, 500, 20, FuelType.AVGAS, VehicleSize.MEDIUM, CleaningType.SIMPLE, RampType.ENCLOSED, MaintenanceType.FIXED));
        planes.add(new Plane("LRG3", 500, 400, 750, 600, FuelType.AVGAS, VehicleSize.LARGE, CleaningType.SEVERE, RampType.ENCLOSED, MaintenanceType.STANDARD));
        planes.add(new Plane("JETX3", 0, 0, 250, 100, FuelType.JET_A1, VehicleSize.SMALL, CleaningType.CLEAN, RampType.OPEN, MaintenanceType.SPECIALIST));

        initVehicles();
        AirportRoutingController arc = new AirportRoutingController();
        
        planes.forEach((p) -> {
            arc.handlePlane(p);
        });
    }
    
    /**
     * Initialises all the vehicles at the airport
     */
    public static void initVehicles()
    {
        //Initialising Vehicles
        FuelTruck smallFuel = new FuelTruck(VehicleSize.SMALL, "smlFuel", FuelType.AVGAS, 150);
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

        //Initialising Bays
        LoadingBay smallLoading = new LoadingBay(1, VehicleSize.SMALL);
        LoadingBay mediumLoading = new LoadingBay(2, VehicleSize.MEDIUM);
        LoadingBay largeLoading = new LoadingBay(3, VehicleSize.LARGE);

        ParkingBay smallParking = new ParkingBay(4, VehicleSize.SMALL);
        ParkingBay mediumParking = new ParkingBay(5, VehicleSize.MEDIUM);
        ParkingBay largeParking = new ParkingBay(6, VehicleSize.LARGE);
    }

}
