/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * Driving state, used by vehicles while driving
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Driving implements VehicleState
{
    /**
     * Instance used for singleton pattern
     */
    static Driving instance;

    /**
     * private constructor for singleton
     */
    private Driving()
    {      
    }
    
    /**
     * state instance method
     * @return the Driving state object
     */
    public static Driving state()
    {
        if (instance == null)
        {
            instance = new Driving();
        }
        return instance;
    }
    
    /**
     * Stops the vehicle refueling while in this state
     * 
     * @param v the Vehicle to refuel
     * @return a string explaining that refueling failed
     */
    @Override
    public String refuel(Vehicle v)
    {
        System.out.println(v.getName() + " is driving and can't refuel");
        return v.getName() + " is driving and can't refuel";
    }
    
}
