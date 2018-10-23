/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import java.util.LinkedList;

/**
 *
 * @author s6089488
 */
public class AirportRoutingController
{

    private LinkedList<Subscriber> subscribers;
    
    public void subscribe (Subscriber s)
    {
        subscribers.add(s);
    }
    
    public void unsubscribe(Subscriber s)
    {
        subscribers.remove(s);
    }
    
    public void notifySubscribers()
    {
        subscribers.forEach((s) -> {s.update();});
    }

}
