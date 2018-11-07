/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Bays;

import Enums.VehicleSize;
import Vehicles.CleaningTruck;
import Vehicles.MaintenanceTruck;
import Vehicles.Vehicle;
import airportroutingcontroller.BayChainable;

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
        Vehicle[] vehicles = new Vehicle[]
        {
            cleaning, maintenance
        };

        for (Vehicle v : vehicles)
        {
            if (v != null)
            {
                System.out.println(v.getName() + " returns to vehicle store");
                v.driveTo(VehicleStore.getInstance());
                System.out.println();
                
                if (v instanceof CleaningTruck)
                    cleaning = null;
                else if (v instanceof MaintenanceTruck)
                    maintenance = null;
            }
        }
    }

    /**
     * Gets all the vehicles needed for the plane, then makes them do job
     */
    @Override
    public void initiate()
    {
        getVehicles();
        fixPlane();
        clean();
    }
    
    /**
     * Adds a LoadingBay to the end of the current chain
     * @param b the bay to be added
     */
    @Override
    public void addToChain(BayChainable b)
    {
        if (b instanceof ParkingBay)
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
