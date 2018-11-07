/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * Vehicle state, extended by all states
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public interface VehicleState
{
    /**
     * The method for refuelling, overridden by all classes
     * @param v the vehicle to be refueled
     * @return a string describing the refueling
     */
    public abstract String refuel(Vehicle v);
}
