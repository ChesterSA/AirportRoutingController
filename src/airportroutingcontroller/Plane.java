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

    private final int maxFood;
    private int foodQuantity;
    private final int maxFuel;
    private int fuelQuantity;
    private final VehicleSize size;
    private CleaningType cleanType;
    private RampType ramp;
    private MaintenanceType maintenance;

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

    public int getMaxFood() {
        return maxFood;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public int getFuelQuantity() {
        return fuelQuantity;
    }

    public VehicleSize getSize() {
        return size;
    }

    public CleaningType getCleanType() {
        return cleanType;
    }

    public RampType getRamp() {
        return ramp;
    }

    public MaintenanceType getMaintenance() {
        return maintenance;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setCleanType(CleaningType cleanType) {
        this.cleanType = cleanType;
    }

    public void setRamp(RampType ramp) {
        this.ramp = ramp;
    }

    public void setMaintenance(MaintenanceType maintenance) {
        this.maintenance = maintenance;
    }
    
    
    

}
