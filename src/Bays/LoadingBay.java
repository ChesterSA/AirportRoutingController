/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Vehicles.CateringTruck;
import Vehicles.FuelTruck;
import Vehicles.Ramp;
import airportroutingcontroller.DeliveryVehicles;

/**
 *
 * @author s6089488
 */
public class LoadingBay extends Bay
{

    private FuelTruck fuel;
    private CateringTruck catering;
    private Ramp ramp;
    
    
    public LoadingBay(int BayID, DeliveryVehicles manager) {
        super(BayID, manager);
    }
    
    @Override
    public void getVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
