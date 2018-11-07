/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package StateTests;

import Enums.FuelType;
import Enums.VehicleSize;
import VehicleStates.VehicleState;
import VehicleStates.Waiting;
import Vehicles.FuelTruck;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestWaiting
{

    FuelTruck test = new FuelTruck(VehicleSize.MEDIUM, "testFuel", FuelType.AVGAS, 250);

    @Test
    public void testStringOutput()
    {
        String expected = "testFuel is driving to refuel\ntestFuel is refueled";
        String actual = test.refuel();
        
        assertEquals(expected, actual);      
    }
    
    @Test
    public void testFuelIncrease()
    {
        test.setFuel(50);
        int expected = 100;
        
        test.refuel();
        
        int actual = test.getFuel();
        
        assertEquals(expected, actual);
    }
    
     @Test
    public void testCancel()
    {
        test.cancel();
        
        VehicleState expected = Waiting.state();
        VehicleState actual = test.getState();
        
        assertEquals(expected, actual);
    }
}
