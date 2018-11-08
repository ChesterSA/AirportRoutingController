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

    public QuantityVehicle(VehicleSize size, String name)
    {
        super(size, name);
    }

    public abstract void refill();
}
