/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Enums.VehicleSize;
import Vehicles.CleaningTruck;
import Vehicles.MaintenanceTruck;

/**
 * Parking bay, used for cleaning and repairing plane, extends bay
 *
 * @author Chester Swann-Auger
 * @since 11/02/18
 */
public class ParkingBay extends Bay
{

    /**
     * The cleaning truck used by the ParkingBay
     */
    private CleaningTruck cleaning;

    /**
     * The maintenance truck used by the ParkingBay
     */
    private MaintenanceTruck maintenance;

    /**
     * The constructor for ParkingBay
     *
     * @param bayID the id of the bay
     * @param size the size vehicle it can take
     */
    public ParkingBay(int bayID, VehicleSize size)
    {
        super(bayID, size);
        name = "Parking Bay " + bayID;
    }

    /**
     * gets the cleaning and maintenance vehicles for the bay
     */
    @Override
    public void getVehicles()
    {
        if (plane != null)
        {
            this.cleaning = manager.getCleaningTruck(plane);
            this.maintenance = manager.getMaintenanceTruck(plane);
        }
    }

    /**
     * cleans the plane, using a CleaningTruck
     */
    public void clean()
    {
        if (cleaning != null)
        {
            cleaning.executeJob(this);
        }
    }

    /**
     * repair the plane using a MaintenanceTruck
     */
    public void fixPlane()
    {
        if (maintenance != null)
        {
            maintenance.executeJob(this);
        }
    }

    /**
     * release all vehicles to the VehicleStore so other bays can use them
     */
    @Override
    public void update()
    {
        cleaning.driveTo(VehicleStore.getInstance());
        cleaning = null;

        maintenance.driveTo(VehicleStore.getInstance());
        maintenance = null;
    }

    @Override
    public void initiate()
    {
        getVehicles();
        fixPlane();
        clean();
    }

}
