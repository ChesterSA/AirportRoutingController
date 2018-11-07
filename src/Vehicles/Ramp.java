/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.RampType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 * Ramp, drives to the plane, extends Vehicle
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Ramp extends Vehicle
{
    /**
     * the type of ramp this is, defines what planes it can be used with
     */
    private final RampType type;

    /**
     * constructor for the vehicle
     * @param size the size of the vehicle
     * @param name the name, used as an identifier
     * @param type the type of ramp this will be
     */
    public Ramp(VehicleSize size, String name, RampType type)
    {
        super(size, name);
        this.type = type;
    }

    /**
     * will handle whether it can reach the plane
     * @return a boolean indicating if the job was successful
     */
    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        System.out.println(p.getPlaneID() + " has a ramp present");
        return true;
    }

    /**
     * Works out whether the current truck can handle the plane
     * if not passes it along the chain
     * 
     * @param p the plane to check
     * @return an object that can handle the plane, or null if none available
     */
    @Override
    public Vehicle handle(Plane p)
    {
        if (p.getSize().ordinal() <= this.size.ordinal()
                && p.getRamp() == this.type
                && this.state == Waiting.state())
        {
            System.out.println("Ramp " + name + " found\n");
            return this;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            System.out.println("No ramps available\n");
            return null;
        }
    }
    
    @Override
    public void addNext(Chainable c)
    {
        if (c instanceof Ramp)
        {
            this.next = c;
        }
    }
}
