/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

/**
 *
 * @author s6089488
 */
public class VehicleStore extends Location
{
    static private VehicleStore instance;

    
    
    private VehicleStore()
    {
        
    }
    
    static public VehicleStore getInstance()
    {
        if (instance == null)
        {
            instance = new VehicleStore();
        }
        return instance;
    }
    
}
