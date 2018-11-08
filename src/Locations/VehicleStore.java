/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Locations;

/**
 * VehicleStore class, stores vehicles that aren't in use and refuels them
 */
public class VehicleStore extends Location
{
    /**
     * instance object for singleton 
     */
    static private VehicleStore instance;
 
    /**
     *  constructor, private for singleton
     */
    private VehicleStore()
    {
        name = "Vehicle Store";
    }
    
    /**
     * getInstance, necessary for Singleton
     * 
     * @return the VehicleStore instance
     */
    static public VehicleStore getInstance()
    {
        if (instance == null)
        {
            instance = new VehicleStore();
        }
        return instance;
    }
    
}
