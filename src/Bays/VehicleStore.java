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
public class VehicleStore extends Bay
{
    static private VehicleStore instance;
    
    private VehicleStore()
    {
        super(0);
    }
    
    static public VehicleStore getInstance()
    {
        if (instance == null)
        {
            instance = new VehicleStore();
        }
        return instance;
    }

    @Override
    public void getVehicles()
    {
        
    }

    @Override
    public void update()
    {
        
    }
    
}
