/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.LoadingBay;
import Bays.ParkingBay;
import Enums.CleaningType;
import Enums.MaintenanceType;
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
    
    public void handlePlane(Plane p)
    {
        if (p.getMaintenance() == MaintenanceType.SPECIALIST ||
                p.getCleanType() == CleaningType.SEVERE)          
        {
            ParkingBay pb = (ParkingBay)firstParkingBay.handle(p);
            if (pb != null)
            {
                System.out.println("Plane has moved to parking bay " + pb.getBayID() + "\n");
                pb.setPlane(p);
                p.setCurrentBay(pb);
            }
            else
            {
                System.out.println("No parking bays available currently\n");
            }
        }
        else
        {
            LoadingBay lb = (LoadingBay)firstLoadingBay.handle(p);
            if (lb != null)
            {
                System.out.println("Plane has moved to loading bay " + lb.getBayID() + "\n");
                lb.setPlane(p);
                p.setCurrentBay(lb);
            }
            else
            {
                System.out.println("No loading bays available currently\n");
            }
        }
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
