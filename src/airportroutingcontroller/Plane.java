/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.Bay;
import Enums.*;

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
    private FuelType fuelType;
    
    private final VehicleSize size;
    private CleaningType cleanType;
    private RampType ramp;
    private MaintenanceType maintenance;
    
    private Bay currentBay;

    public Plane(int maxFood, int foodQuantity, int maxFuel, int fuelQuantity, FuelType fuelType, VehicleSize size, CleaningType cleanType, RampType ramp, MaintenanceType maintenance)
    {
        this.maxFood = maxFood;
        this.foodQuantity = foodQuantity;
        this.maxFuel = maxFuel;
        this.fuelQuantity = fuelQuantity;
        this.fuelType = fuelType;
        this.size = size;
        this.cleanType = cleanType;
        this.ramp = ramp;
        this.maintenance = maintenance;
    }

    public int getMaxFood()
    {
        return maxFood;
    }
    
    public int getFoodQuantity()
    {
        return foodQuantity;
    }
    
    public int getMaxFuel()
    {
        return maxFuel;
    }
    
    public int getFuelQuantity()
    {
        return fuelQuantity;
    }

    public VehicleSize getSize()
    {
        return size;
    }

    public CleaningType getCleanType()
    {
        return cleanType;
    }

    public RampType getRamp()
    {
        return ramp;
    }

    public MaintenanceType getMaintenance()
    {
        return maintenance;
    }

    public FuelType getFuelType()
    {
        return fuelType;
    }

    
    
    public void setFoodQuantity(int foodQuantity)
    {
        this.foodQuantity = foodQuantity;
    }

    public void setFuelQuantity(int fuelQuantity)
    {
        this.fuelQuantity = fuelQuantity;
    }

    public void setCleanType(CleaningType cleanType)
    {
        this.cleanType = cleanType;
    }

    public void setRamp(RampType ramp)
    {
        this.ramp = ramp;
    }

    public void setMaintenance(MaintenanceType maintenance)
    {
        this.maintenance = maintenance;
    }

    public void setFuelType(FuelType fuelType)
    {
        this.fuelType = fuelType;
    }

    public Bay getCurrentBay()
    {
        return currentBay;
    }

    public void setCurrentBay(Bay currentBay)
    {
        this.currentBay = currentBay;
    }
    
    

}
