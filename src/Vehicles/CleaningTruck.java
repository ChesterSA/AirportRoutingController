/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Vehicles;

import Locations.Bay;
import Enums.CleaningType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 * Cleaning Truck, cleans the plane, extends Vehicle
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class CleaningTruck extends Vehicle
{
    /**
     * the type of plane that this vehicle can clean
     */
    private final CleaningType cleaningType;

    /**
     * constructor for the vehicle
     * @param size the size of the vehicle
     * @param name the name, used as an identifier
     * @param type the type of cleaning the vehicle can do
     */
    public CleaningTruck(VehicleSize size, String name, CleaningType type)
    {
        super(size, name);
        cleaningType = type;
    }

    /**
     * changes plane CleanType to clean
     * @return a boolean indicating if the job was successful
     */
    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        System.out.println(p.getPlaneID() + " has been cleaned");
        
        p.setCleanType(CleaningType.CLEAN);
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
        if (p.getSize().ordinal() <= size.ordinal()
                && this.cleaningType.ordinal() >= p.getCleanType().ordinal()
                && this.state == Waiting.state())
        {
            System.out.println("Cleaning truck " + name + " found\n");
            return this;
        }
        else if (next != null)
        {
            
            return next.handle(p);
        }
        else
        {
            System.out.println("No Cleaning truck found\n");
            return null;
        }
    }

    /**
     * Sets next equal to another chainable 
     * @param c The chainable object to add
     */
    @Override
    public void addNext(Chainable c)
    {
        if (c instanceof CleaningTruck)
        {
            this.next = c;
        }
    } 
    
    /**
     * Adds a vehicle to the end of the current chain
     * @param c the chainable type to be added
     */
    @Override
    public void addToChain(Chainable c)
    {
        if (c instanceof CleaningTruck)
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
