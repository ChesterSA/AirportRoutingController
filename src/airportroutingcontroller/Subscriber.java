/* 
 * Created in Teesside University
 * By Chester Swann-Auger
 * As part of Group B - Airport Routing Controller
 */
package airportroutingcontroller;

/**
 * Subscriber interface for bays to work with observer pattern
 * 
 * @author Chester Swann-Auger
 * @since 01/11/18
 */
public interface Subscriber
{
    /**
     * Any subscriber will implement this to react to the subject updating
     */
    public void update();
}
