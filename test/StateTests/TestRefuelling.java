/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package StateTests;

import Enums.VehicleSize;
import VehicleStates.Refueling;
import VehicleStates.VehicleState;
import VehicleStates.Waiting;
import Vehicles.CateringTruck;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestRefuelling
{
    CateringTruck test = new CateringTruck(VehicleSize.MEDIUM, "test", 150);
    
    @Test
    public void testStringOutput()
    {
        test.setState(Refueling.state());
        String expected = "test is refueled";
        String actual = test.refuel();
        
        assertEquals(expected, actual);      
    }
    
    @Test
    public void testFuelIncrease()
    {
        test.setState(Refueling.state());
        test.setFuel(50);
        int expected = 100;
        
        test.refuel();
        
        int actual = test.getFuel();
        
        assertEquals(expected, actual);
    }
    
     @Test
    public void testCancel()
    {
        test.setState(Refueling.state());
        
        test.cancel();
        
        VehicleState expected = Waiting.state();
        VehicleState actual = test.getState();
        
        assertEquals(expected, actual);
    }
}
