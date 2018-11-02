/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateTests;

import Enums.FuelType;
import Enums.RampType;
import Enums.VehicleSize;
import VehicleStates.Driving;
import Vehicles.FuelTruck;
import Vehicles.Ramp;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestDriving
{
    Ramp test = new Ramp(VehicleSize.MEDIUM, "test", RampType.ENCLOSED);

    @Test
    public void testStringOutput()
    {
        test.setState(Driving.state());
        String expected = "test is driving and can't refuel";
        String actual = test.refuel();
        
        assertEquals(expected, actual);      
    }
    
    @Test
    public void testFuelIncrease()
    {
        test.setState(Driving.state());
        
        test.setFuel(50);
        int expected = 50;
        
        test.refuel();
        
        int actual = test.getFuel();
        
        assertEquals(expected, actual);
    }
}
