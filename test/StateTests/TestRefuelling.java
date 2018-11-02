/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateTests;

import Enums.VehicleSize;
import VehicleStates.Refueling;
import Vehicles.CateringTruck;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestRefuelling
{
    CateringTruck testTruck = new CateringTruck(VehicleSize.MEDIUM, "test", 150);
    
    @Test
    public void testStringOutput()
    {
        testTruck.setState(new Refueling());
        String expected = "test is refueled";
        String actual = testTruck.refuel();
        
        assertEquals(expected, actual);      
    }
    
    @Test
    public void testFuelIncrease()
    {
        testTruck.setState(new Refueling());
        testTruck.setFuel(50);
        int expected = 100;
        
        testTruck.refuel();
        
        int actual = testTruck.getFuel();
        
        assertEquals(expected, actual);
    }
}
