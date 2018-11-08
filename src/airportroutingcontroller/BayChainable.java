/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package airportroutingcontroller;

import Locations.Bay;

/**
 * Chainable interface used by the bays
 *
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public interface BayChainable
{

    /**
     * adds another BayChainable to the chain
     *
     * @param next the BayChainable to add
     */
    public void addNext(BayChainable next);

    /**
     * checks if the current BayChainable can handle the plane
     *
     * @param p the plane to handle
     * @return A Bay that can handle the plane, or null if none available
     */
    public Bay handle(Plane p);

    public void addToChain(BayChainable b);
}
