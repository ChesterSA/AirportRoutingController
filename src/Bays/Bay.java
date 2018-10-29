/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import airportroutingcontroller.DeliveryVehicles;
import airportroutingcontroller.Plane;
import airportroutingcontroller.Subscriber;

/**
 *
 * @author s6089488
 */
public abstract class Bay extends Location implements Subscriber
{

    protected int BayID;
    protected Plane plane;
    protected DeliveryVehicles manager;

    public Bay(int BayID)
    {
        this.BayID = BayID;
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
    
    
}
