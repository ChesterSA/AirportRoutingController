/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public void addToChain(Vehicle v);
}
