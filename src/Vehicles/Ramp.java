/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Bays.Location;
import Enums.RampType;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public class Ramp extends Vehicle implements Chainable
{

    private final RampType type;

    public Ramp(RampType type, VehicleSize size)
    {
        super(size);
        this.type = type;
    }

    @Override
    public boolean doJob()
    {
        return true;
    }

    @Override
    public Vehicle handle(Plane p)
    {
        if (p.getSize().ordinal() <= this.size.ordinal()
                && p.getRamp() == this.type
                //&& this.state == new Waiting()
                )
        {
            System.out.println("Ramp found");
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
