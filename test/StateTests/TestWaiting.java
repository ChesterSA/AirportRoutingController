/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateTests;

import Enums.FuelType;
import Enums.VehicleSize;
import VehicleStates.*;
import Vehicles.FuelTruck;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestWaiting
{

    FuelTruck testTruck = new FuelTruck(VehicleSize.MEDIUM, "testFuel", FuelType.AVGAS, 250);

    @Test
    public void testStringOutput()
    {
        //System.out.println(testTruck.refuel());
        String expected = "Vehicle is driving to refuel - All refueled";
        String actual = testTruck.refuel();
        assertEquals(expected, actual);
          
    }
    
    @Test
    public void testFuelIncrease()
    {
        testTruck.setFuel(50);
        int expected = 100;
        
        testTruck.refuel();
        
        int actual = testTruck.getFuel();
        
        assertEquals(expected, actual);
    }
}
