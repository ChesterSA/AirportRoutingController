/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package Bays;

/**
 * The location object that all other locations extend
 * @author Chester Swann-Auger
 */
public abstract class Location
{
    /**
     * the name of the location, used for identification
     */
    String name;

    /**
     * getter for the name object
     * @return the name string
     */
    public String getName()
    {
        return name;
    }    
}
