/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Vehicles;

import Bays.Bay;
import Enums.MaintenanceType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 * FuelTruck, repairs the plane, extends Vehicle
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class MaintenanceTruck extends Vehicle
{
    /**
     * the type of maintenance this vehicle can perform
     */
    private final MaintenanceType type;

    /**
     * constructor for the vehicle
     * @param size the size of the vehicle
     * @param name the name, used as an identifier
     * @param type the type of maintenance the truck can do
     */
    public MaintenanceTruck(VehicleSize size, String name, MaintenanceType type)
    {
        super(size, name);
        this.type = type;
    }

    /**
     * sets the plane's maintenanceType to repaired
     * @return a boolean indicating if the job was successful
     */
    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        System.out.println(p.getPlaneID() + " has been repaired");
        return true;
    }

    /**
     * Works out whether the current truck can handle the plane
     * if not passes it along the chain
     * 
     * @param p the plane to check
     * @return an object that can handle the plane, or null if none available
     */
    @Override
    public Vehicle handle(Plane p)
    {
        if (p.getSize().ordinal() <= this.size.ordinal()
                && p.getMaintenance().ordinal() <= this.type.ordinal()
                && this.state == Waiting.state())
        {
            System.out.println("Maintenance truck " + name + " found\n");
            return this;
        }
        else if (next != null)
        {          
            return next.handle(p);
        }
        else
        {
            System.out.println("No Maintenance truck available\n");
            return null;
        }
    }
    
    @Override
    public void addNext(Chainable c)
    {
        if (c instanceof MaintenanceTruck)
        {
            this.next = c;
        }
    }
    
    @Override
    public void addToChain(Chainable c)
    {
        if (c instanceof MaintenanceTruck)
        {
            if (this.next == null)
            {
                addNext(c);
            }
            else
            {
                next.addToChain(c);
            }
        }

    }

}
