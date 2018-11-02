/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

/**
 * VehicleStore class, stores vehicles that aren't in use and refuels them
 */
public class VehicleStore extends Location
{
    /**
     * instance object for singleton 
     */
    static private VehicleStore instance;
 
    /**
     *  constructor, private for singleton
     */
    private VehicleStore()
    {
        name = "Vehicle Store";
    }
    
    /**
     * getInstance, necessary for Singleton
     * 
     * @return the VehicleStore instance
     */
    static public VehicleStore getInstance()
    {
        if (instance == null)
        {
            instance = new VehicleStore();
        }
        return instance;
    }
    
}
