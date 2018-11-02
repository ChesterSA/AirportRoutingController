/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Vehicles.*;

/**
 * manages all vehicles on airport and controls which ones are needed
 * 
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public class DeliveryVehicles
{
    /**
     * instance used for singleton pattern
     */
    static private DeliveryVehicles instance;

    /**
     * the first fuel truck in the chain
     */
    private FuelTruck firstFuel;
    
    /**
     * the first catering truck in the chain
     */
    private CateringTruck firstCatering;
    
    /**
     * the first ramp in the chain
     */
    private Ramp firstRamp;
    
    /**
     * the first cleaning truck in the chain
     */
    private CleaningTruck firstCleaning;
    
    /**
     * the first maintenance truck in the chain
     */
    private MaintenanceTruck firstMaintenance;

    /**
     * private constructor for singleton pattern
     */
    private DeliveryVehicles()
    {

    }

    /**
     * gets the instance, ensures singleton pattern holds
     * @return 
     */
    static public DeliveryVehicles getInstance()
    {
        if (instance == null)
        {
            instance = new DeliveryVehicles();
        }
        return instance;
    }

    /**
     * gets a FuelTruck that can handle the plane
     * @param plane
     * @return a FuelTruck that can handle the plane, or null if none are available
     */
    public FuelTruck getFuelTruck(Plane plane)
    {
        System.out.println("Getting fuel truck");
        return (FuelTruck) firstFuel.handle(plane);
    }

    /**
     * gets a CateringTruck that can handle the plane
     * @param plane
     * @return a CateringTruck that can handle the plane, or null if none are available
     */
    public CateringTruck getCateringTruck(Plane plane)
    {
        System.out.println("Getting catering truck");
        return (CateringTruck) firstCatering.handle(plane);
    }

    /**
     * gets a Ramp that can handle the plane
     * @param plane
     * @return a Ramp that can handle the plane, or null if none are available
     */
    public Ramp getRamp(Plane plane)
    {
        System.out.println("Getting ramp");
        return (Ramp) firstRamp.handle(plane);
    }

    /**
     * gets a CleaningTruck that can handle the plane
     * @param plane
     * @return a CleaningTruck that can handle the plane, or null if none are available
     */
    public CleaningTruck getCleaningTruck(Plane plane)
    {
        System.out.println("Getting cleaning truck");
        return (CleaningTruck) firstCleaning.handle(plane);
    }

    /**
     * gets a MaintenanceTruck that can handle the plane
     * @param plane
     * @return a MaintenanceTruck that can handle the plane, or null if none are available
     */
    public MaintenanceTruck getMaintenanceTruck(Plane plane)
    {
        System.out.println("Getting maintenance truck");
        return (MaintenanceTruck) firstMaintenance.handle(plane);
    }

    /**
     * setter for firstFuel, keeps chain intact
     * @param firstFuel the item to set firstFuel to
     */
    public void setFirstFuel(FuelTruck firstFuel)
    {
        this.firstFuel = firstFuel;
    }

    /**
     * setter for firstCatering, keeps chain intact
     * @param firstCatering the item to set firstCatering to
     */
    public void setFirstCatering(CateringTruck firstCatering)
    {
        this.firstCatering = firstCatering;
    }

    /**
     * setter for firstRamp, keeps chain intact
     * @param firstRamp the item to set firstRamp to
     */
    public void setFirstRamp(Ramp firstRamp)
    {
        this.firstRamp = firstRamp;
    }

    /**
     * setter for firstCleaning, keeps chain intact
     * @param firstCleaning the item to set firstCleaning to
     */
    public void setFirstCleaning(CleaningTruck firstCleaning)
    {
        this.firstCleaning = firstCleaning;
    }
    
    /**
     * setter for firstMaintenance, keeps chain intact
     * @param firstMaintenance the item to set firstMaintenance to
     */
    public void setFirstMaintenance(MaintenanceTruck firstMaintenance)
    {
        this.firstMaintenance = firstMaintenance;
    }

}
