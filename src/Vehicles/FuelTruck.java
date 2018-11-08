/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Vehicles;

import Locations.Bay;
import Locations.VehicleStore;
import Enums.FuelType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 * FuelTruck, refuels the plane, extends Vehicle
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class FuelTruck extends QuantityVehicle
{
    /**
     * The type of fuel the truck uses
     */
    private final FuelType fuelType;
    
    /**
     * the amount of plane fuel on the truck
     */
    private int planeFuelQuantity;

    /**
     * constructor for the vehicle
     * @param size the size of the vehicle
     * @param name the name, used as an identifier
     * @param fuelType the type of fuel it will use
     * @param planeFuelQuantity the amount of plane fuel on the truck
     */
    public FuelTruck(VehicleSize size, String name, FuelType fuelType,  int planeFuelQuantity)
    {
        super(size, name);
        this.fuelType = fuelType;
        this.planeFuelQuantity = planeFuelQuantity;
    }

    /**
     * sets the plane's fuel level to max
     * @return a boolean indicating if the job was successful
     */
    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        System.out.println(p.getPlaneID() + " has been refilled");
        
        p.setFuelQuantity(p.getMaxFuel());
        this.planeFuelQuantity = p.getMaxFuel()- p.getFuelQuantity();
        
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
        if ((p.getMaxFuel() - p.getFuelQuantity()) <= this.planeFuelQuantity
                && this.fuelType == p.getFuelType()
                && this.state == Waiting.state())
        {
            System.out.println("Fuel truck " + name + " found\n");
            return this;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            System.out.println("No Fuel Truck found\n");
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
        if (c instanceof FuelTruck)
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
        if (c instanceof FuelTruck)
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
    
    /**
     * Sets the fuel quantity to a different value depending on VehicleSize
     */
    @Override
    public void refill()
    {
        if(location == VehicleStore.getInstance())
        {
            switch(size)
            {
                case SMALL:
                    planeFuelQuantity = 150;
                    break;
                case MEDIUM:
                    planeFuelQuantity = 50;
                    break;
                case LARGE:
                    planeFuelQuantity = 800;
                    break;    
            }     
        }
        System.out.println(name + " has been refilled, it now has " + planeFuelQuantity + " fuel");
    }
}
