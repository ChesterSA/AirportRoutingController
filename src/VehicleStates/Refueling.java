/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package VehicleStates;

import Vehicles.Vehicle;

/**
 * Refueling state, used by vehicles while refueling
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Refueling implements VehicleState
{
    /**
     * Instance used for singleton pattern
     */
    static Refueling instance;
    
    /**
     * private constructor for singleton
     */
    private Refueling()
    {      
    }
    
    /**
     * state instance method
     * @return the Refueling state object
     */
    public static Refueling state()
    {
        if (instance == null)
        {
            instance = new Refueling();
        }
        return instance;
    }
    
    /**
     * The method used by vehicles to refuel
     * @param v the vehicle to refuel
     * @return a string confirming refueling was successful
     */
    @Override
    public String refuel(Vehicle v)
    {
        System.out.println(v.getName() + " STATE = REFUELLING");
        v.setFuel(100);      
        System.out.println(v.getName() + " is refueled");
        return v.getName() + " is refueled";
    }

}
