/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.Bay;
import Bays.LoadingBay;
import Bays.ParkingBay;
import Enums.*;

/**
 *
 * @author s6089488
 */
public class Plane
{
    private String planeID;
    
    private final int maxFood;
    private int foodQuantity;
    
    private final int maxFuel;
    private int fuelQuantity;
    private FuelType fuelType;
    
    private final VehicleSize size;
    private CleaningType cleanType;
    private RampType ramp;
    private MaintenanceType maintenance;
    
    private LoadingBay loadingBay;
    private ParkingBay parkingBay;

    public Plane(String planeID, int maxFood, int foodQuantity, int maxFuel, int fuelQuantity, FuelType fuelType, VehicleSize size, CleaningType cleanType, RampType ramp, MaintenanceType maintenance)
    {
        this.planeID = planeID;
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

    public LoadingBay getLoadingBay()
    {
        return loadingBay;
    }

    public void setLoadingBay(LoadingBay loadingBay)
    {
        this.loadingBay = loadingBay;
    }

    public ParkingBay getParkingBay()
    {
        return parkingBay;
    }

    public void setParkingBay(ParkingBay parkingBay)
    {
        this.parkingBay = parkingBay;
    }

    public String getPlaneID()
    {
        return planeID;
    }

    public void setPlaneID(String PlaneID)
    {
        this.planeID = PlaneID;
    }
    
    

    
    
    

}
