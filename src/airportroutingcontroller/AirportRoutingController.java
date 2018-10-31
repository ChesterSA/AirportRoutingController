/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.LoadingBay;
import Bays.ParkingBay;
import java.util.LinkedList;

/**
 *
 * @author s6089488
 */
public class AirportRoutingController
{
    private static LinkedList<Subscriber> subscribers;
    private static LoadingBay firstLoadingBay;
    private static ParkingBay firstParkingBay;
    
    

    public static void subscribe(Subscriber s)
    {
        subscribers.add(s);
    }

    public static void unsubscribe(Subscriber s)
    {
        subscribers.remove(s);
    }

    public static void notifySubscribers()
    {
        subscribers.forEach((s) ->
        {
            s.update();
        });
    }

    public static LoadingBay getFirstLoadingBay()
    {
        return firstLoadingBay;
    }

    public static void setFirstLoadingBay(LoadingBay firstLoadingBay)
    {
        AirportRoutingController.firstLoadingBay = firstLoadingBay;
    }

    public static ParkingBay getFirstParkingBay()
    {
        return firstParkingBay;
    }

    public static void setFirstParkingBay(ParkingBay firstParking)
    {
        AirportRoutingController.firstParkingBay = firstParking;
    }

}
