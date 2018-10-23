/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import airportroutingcontroller.DeliveryVehicles;
import airportroutingcontroller.Plane;

/**
 *
 * @author s6089488
 */
public abstract class Bay
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
}
