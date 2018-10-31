/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Enums.VehicleSize;
import airportroutingcontroller.BayChainable;
import airportroutingcontroller.Chainable;
import airportroutingcontroller.DeliveryVehicles;
import airportroutingcontroller.Plane;
import airportroutingcontroller.Subscriber;

/**
 *
 * @author s6089488
 */
public abstract class Bay extends Location implements Subscriber, BayChainable
{
    protected int BayID;
    protected Plane plane;
    protected DeliveryVehicles manager;
    protected VehicleSize size;
    protected BayChainable next;

    public Bay(int BayID, VehicleSize size)
    {
        this.BayID = BayID;
        this.size = size;
        this.manager = DeliveryVehicles.getInstance();
    }

    public abstract void getVehicles();

    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }
    
    @Override
    public Bay handle(Plane p)
    {
        if (this.size.ordinal() >= p.getSize().ordinal())
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
    
    public void movePlane(Bay b)
    {
        if (b.size.ordinal() >= plane.getSize().ordinal()
                && b.plane == null)
        {
            b.plane = plane;
            plane = null;
        }
    }
    
    @Override
    public void addNext(BayChainable b)
    {
        next = b;
    }

    public int getBayID()
    {
        return BayID;
    }
    
    
}
