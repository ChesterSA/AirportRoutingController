/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

import Bays.Bay;
import Enums.VehicleSize;
import VehicleStates.Waiting;
import airportroutingcontroller.Plane;

/**
 * The CateringTruck, used for filling Plane's food, extends Vehicle
 */
public class CateringTruck extends Vehicle
{
    /**
     * the amount of food this truck currently has
     */
    private int foodQuantity;

    /**
     * constructor for CateringTruck
     * @param size the size of the vehicle
     * @param name the name for the vehicle
     * @param foodQuantity the amount of food the truck vehicle has.
     */
    public CateringTruck(VehicleSize size, String name, int foodQuantity)
    {
        super(size, name);
        this.foodQuantity = foodQuantity;
    }

    /**
     * fills up the food on the plane
     * @return a boolean indicating whether the job was successful
     */
    @Override
    public boolean doJob()
    {
        Bay current = (Bay)location;
        Plane p = current.getPlane();
        
        this.foodQuantity = p.getMaxFood() - p.getFoodQuantity();
        p.setFoodQuantity(p.getMaxFood());
        return true;
    }

    /**
     * Works out whether the current truck can handle the plane
     * if not passes it along the chain
     * 
     * @param p the plane to check
     * @return an object that can handle the plane, or null if none available
     */
    @Override
    public Vehicle handle(Plane p)
    {
        if ((p.getMaxFood() - p.getFoodQuantity()) <= this.foodQuantity
                && this.state == Waiting.state())
        {
            System.out.println("Catering truck " + name + " found");
            return this;
        }
        else if (next != null)
        {
            return next.handle(p);
        }
        else
        {
            return null;
        }
    }

}
