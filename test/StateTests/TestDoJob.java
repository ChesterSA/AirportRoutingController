/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package StateTests;

import Enums.MaintenanceType;
import Enums.VehicleSize;
import VehicleStates.DoingJob;
import VehicleStates.VehicleState;
import VehicleStates.Waiting;
import Vehicles.MaintenanceTruck;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author s6089488
 */
public class TestDoJob
{
    MaintenanceTruck test = new MaintenanceTruck(VehicleSize.MEDIUM, "test", MaintenanceType.STANDARD);

    @Test
    public void testStringOutput()
    {
        test.setState(DoingJob.state());
        String expected = "test is doing a job and can't refuel";
        String actual = test.refuel();
        
        assertEquals(expected, actual);      
    }
    
    @Test
    public void testFuelIncrease()
    {
        test.setState(DoingJob.state());
        
        test.setFuel(50);
        int expected = 50;
        
        test.refuel();
        
        int actual = test.getFuel();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testCancel()
    {
        test.setState(DoingJob.state());
        
        test.cancel();
        
        VehicleState expected = Waiting.state();
        VehicleState actual = test.getState();
        
        assertEquals(expected, actual);
    }
}
