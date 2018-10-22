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

    int BayID;
    Plane plane;
    DeliveryVehicles manager;

    public Bay(int BayID, DeliveryVehicles manager)
    {
        this.BayID = BayID;
        this.manager = manager;
    }

    public abstract void getVehicles();
}
