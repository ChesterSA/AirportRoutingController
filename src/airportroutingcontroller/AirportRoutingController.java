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
 * Entry point for system, handles where to send planes
 *
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class AirportRoutingController
{

    /**
     * List of the bays, used as a subscriber list for observer
     */
    private static LinkedList<Subscriber> bays;

    /**
     * Initial loading bay in the chains
     */
    private static LoadingBay firstLoadingBay;

    /**
     * Initial parking bay in the chain
     */
    private static ParkingBay firstParkingBay;

    /**
     * adds a subscriber to the list
     *
     * @param s the subscriber to add
     */
    public static void subscribe(Subscriber s)
    {
        bays.add(s);
    }

    /**
     * remove a subscriber from the list
     *
     * @param s
     */
    public static void unsubscribe(Subscriber s)
    {
        bays.remove(s);
    }

    /**
     * calls the update method on all subscribers;
     */
    public static void notifySubscribers()
    {
        bays.forEach((s)
                ->
        {
            s.update();
        });
    }

    /**
     * Checks which type of bay the plane needs to go to, then sends it there
     *
     * @param p the plane to be handled
     */
    public void handlePlane(Plane p)
    {

        if (p.getMaintenance() == MaintenanceType.SPECIALIST
                || p.getCleanType() == CleaningType.SEVERE)
        {
            ParkingBay pb = (ParkingBay) firstParkingBay.handle(p);
            if (pb != null)
            {
                System.out.println("Plane " + p.getPlaneID() + " has moved to parking bay " + pb.getBayID() + "\n");
                pb.setPlane(p);
                p.setParkingBay(pb);
                pb.initiate();
            }
            else
            {
                System.out.println("No parking bays available currently\n");
            }
        }

        LoadingBay lb = (LoadingBay) firstLoadingBay.handle(p);
        if (lb != null)
        {
            System.out.println("Plane " + p.getPlaneID() + " has moved to loading bay " + lb.getBayID() + "\n");
            lb.setPlane(p);
            p.setLoadingBay(lb);
            lb.initiate();
        }
        else
        {
            System.out.println("No loading bays available currently\n");
        }
        
        finishPlane();
    }

    /**
     * setter for firstLoadingBay
     *
     * @param firstLoadingBay the bay to set it to
     */
    public static void setFirstLoadingBay(LoadingBay firstLoadingBay)
    {
        AirportRoutingController.firstLoadingBay = firstLoadingBay;
    }

    /**
     * setter for firstParkingBay
     *
     * @param firstParkingBay the bay to set it to
     */
    public static void setFirstParkingBay(ParkingBay firstParkingBay)
    {
        AirportRoutingController.firstParkingBay = firstParkingBay;
    }
    
    private static void finishPlane()
    {
        
    }

}
