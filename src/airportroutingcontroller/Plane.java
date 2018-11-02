/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.LoadingBay;
import Bays.ParkingBay;
import Enums.*;

/**
 *
 * @author s6089488
 */
public class Plane
{
    /**
     * identifer of the plane
     */
    private final String planeID;
    
    /**
     * the maximum amount of food the plane can have
     */
    private final int maxFood;
    
    /**
     * the current amount of food on the plane
     */
    private int foodQuantity;
    
    /**
     * the maximum amount of fuel on the plane
     */
    private final int maxFuel;
    
    /**
     * the current amount of fuel on plane
     */
    private int fuelQuantity;
    
    /**
     * the type of fuel the plane needs
     */
    private final FuelType fuelType;
    
    /**
     * the size of vehicles the plane needs
     */
    private final VehicleSize size;
    
    /**
     * how clean the plane is
     */
    private CleaningType cleanType;
    
    /**
     * what type of ramp the plane needs
     */
    private final RampType ramp;
    
    /**
     * the type of maintenance the plane needs
     */
    private MaintenanceType maintenance;
    
    /**
     * the loading bay the plane is in
     */
    private LoadingBay loadingBay;
    
    /**
     * the parking bay the plane is in
     */
    private ParkingBay parkingBay;

    /**
     * the constructor for plane
     * @param planeID the plane's id
     * @param maxFood the max amount of food for the plane
     * @param foodQuantity how much food is on the plane
     * @param maxFuel the max amount of fuel for plane
     * @param fuelQuantity the current quantity of fuel on plane
     * @param fuelType the type of fuel the plane needs
     * @param size the size of vehicles the plane needs
     * @param cleanType how clean the plane is
     * @param ramp what type of ramp the plane needs
     * @param maintenance the type of maintenance the plane needs
     */
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

    /**
     * getter for planeID 
     * @return the planeID
     */
    public String getPlaneID()
    {
        return planeID;
    }

    /**
     * getter for max food
     * @return the max food object
     */
    public int getMaxFood()
    {
        return maxFood;
    }
    
    /**
     * getter for maxFuel
     * @return the max Fuel object
     */
    public int getMaxFuel()
    {
        return maxFuel;
    }

    /**
     * getter for fuelType
     * @return the type of fuel the plane needs
     */
    public FuelType getFuelType()
    {
        return fuelType;
    }

    /**
     * getter for size
     * @return the size of vehicles the plane needs 
     */
    public VehicleSize getSize()
    {
        return size;
    }
    
    /**
     * getter for ramp
     * @return the ramptype the plane needs
     */
    public RampType getRamp()
    {
        return ramp;
    }
    
    /**
     * getter for foodQuantity
     * @return the quantity of food on the plane
     */
    public int getFoodQuantity()
    {
        return foodQuantity;
    }
    
    /**
     * setter for foodQuantity
     * @param foodQuantity the quantity of food to give the plane
     */
    public void setFoodQuantity(int foodQuantity)
    {
        this.foodQuantity = foodQuantity;
    }

    /**
     * getter for fuelQuantity
     * @return the quantity of fuel on the plane
     */
    public int getFuelQuantity()
    {
        return fuelQuantity;
    }
    
    /**
     * setter for fuelQuantity
     * @param fuelQuantity the quantity of fuel to give the plane
     */
    public void setFuelQuantity(int fuelQuantity)
    {
        this.fuelQuantity = fuelQuantity;
    }
    
    /**
     * getter for cleanType
     * @return the type of cleaning the plane needs
     */
    public CleaningType getCleanType()
    {
        return cleanType;
    }
    
    /**
     * setter for cleanType
     * @param cleanType the type of cleaning the plane needs
     */
    public void setCleanType(CleaningType cleanType)
    {
        this.cleanType = cleanType;
    }
    
    /**
     * getter for maintenanceType
     * @return the type of maintenance the plane needs
     */
    public MaintenanceType getMaintenance()
    {
        return maintenance;
    }
    
    /**
     * setter for maintenanceType
     * @param maintenanceType the type of maintenance the plane needs
     */
    public void setMaintenance(MaintenanceType maintenance)
    {
        this.maintenance = maintenance;
    }
    
    /**
     * getter for LoadingBay
     * @return the loading bay the plane is in
     */
    public LoadingBay getLoadingBay()
    {
        return loadingBay;
    }
    
    /**
     * setter for loadingBay
     * @param loadingBay the loadingBay the plane should be in
     */
    public void setLoadingBay(LoadingBay loadingBay)
    {
        this.loadingBay = loadingBay;
    }

    
    /**
     * getter for ParkingBay
     * @return the parking bay the plane is in
     */
    public ParkingBay getParkingBay()
    {
        return parkingBay;
    }
    
    /**
     * setter for parkingBay
     * @param parkingBay the parkingBay the plane should be in
     */
    public void setParkingBay(ParkingBay parkingBay)
    {
        this.parkingBay = parkingBay;
    }
    
    
    
    

    
    

}
