/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Enums.CleaningType;
import Enums.MaintenanceType;
import Enums.RampType;
import Enums.VehicleSize;

/**
 *
 * @author s6089488
 */
public class Plane
{

    public final int maxFood;
    public int foodQuantity;
    public final int maxFuel;
    public int fuelQuantity;
    public VehicleSize size;
    public CleaningType cleanType;
    public RampType ramp;
    public MaintenanceType maintenance;

    public Plane(int maxFood, int foodQuantity, int maxFuel, int fuelQuantity, VehicleSize size, CleaningType cleanType, RampType ramp, MaintenanceType maintenance)
    {
        this.maxFood = maxFood;
        this.foodQuantity = foodQuantity;
        this.maxFuel = maxFuel;
        this.fuelQuantity = fuelQuantity;
        this.size = size;
        this.cleanType = cleanType;
        this.ramp = ramp;
        this.maintenance = maintenance;
    }

}
