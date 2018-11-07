/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.Bay;
import Vehicles.Vehicle;

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
     * @param next the BayChainable to add
     */
    public void addNext(BayChainable next);

    /**
     * checks if the current BayChainable can handle the plane
     * @param p the plane to handle
     * @return A Bay that can handle the plane, or null if none available
     */
    public Bay handle(Plane p);
    
    public void addToChain(Bay b);
}
