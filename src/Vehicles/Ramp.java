/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.RampType;
import Enums.VehicleSize;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class Ramp extends Vehicle implements Chainable
{

    RampType type;

    public Ramp(RampType type, VehicleSize size, Bay location)
    {
        super(size, location);
        this.type = type;
    }

    @Override
    public boolean doJob(Plane p)
    {
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if (p.size.ordinal() <= this.size.ordinal()
                && p.ramp == this.type)
        {
            return this;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void addNext(Chainable c)
    {
        next = c;
    }
}
