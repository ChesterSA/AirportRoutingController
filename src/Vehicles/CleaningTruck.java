/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.CleaningType;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class CleaningTruck extends Vehicle{

    CleaningType cleaningType;
    
    public CleaningTruck(VehicleSize size, Bay location, CleaningType type) {
        super(size, location);
        cleaningType = type;
    }

    
    @Override
    public boolean doJob() {
        //DO THE CATERING
        return true;
    }
    
}
