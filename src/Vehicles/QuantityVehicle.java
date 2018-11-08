/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Vehicles;

import Enums.VehicleSize;

/**
 * Child of vehicle, 
 * used to distinguish vehicles that need refilling, eg Fuel and Catering
 * 
 * @author Chester Swann-Auger
 * @since 08/11/2018
 */
public abstract class QuantityVehicle extends Vehicle
{
    /**
     * Constructor, calls the super
     * @param size the size of the vehicle
     * @param name the name of the vehicle
     */
    public QuantityVehicle(VehicleSize size, String name)
    {
        super(size, name);
    }

    /**
     * Called when a vehicle needs refilling
     */
    public abstract void refill();
}
