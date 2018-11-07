/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package airportroutingcontroller;

import Vehicles.Vehicle;

/**
 * Chainable interface used by the vehicles
 * 
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public interface Chainable
{
    /**
     * adds another Chainable to the chain
     * @param next the Chainable to add
     */
    public void addNext(Chainable next);

    /**
     * checks if the current Chainable can handle the plane
     * @param p the plane to handle
     * @return A vehicle that can handle the plane, or null if none available
     */
    public Vehicle handle(Plane p);
    
    public void addToChain(Chainable c);
}
