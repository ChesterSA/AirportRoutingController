/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.MaintenanceType;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class MaintenanceTruck extends Vehicle
{

    MaintenanceType type;

    public MaintenanceTruck(MaintenanceType type, VehicleSize size, Bay location)
    {
        super(size, location);
        this.type = type;
    }

    @Override
    public boolean doJob()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}