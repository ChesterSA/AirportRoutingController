/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportroutingcontroller;

import Bays.Bay;
import Bays.LoadingBay;
import Bays.ParkingBay;
import Bays.Runway;
import Enums.CleaningType;
import Enums.MaintenanceType;
import java.util.ArrayList;

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
    private static ArrayList<Subscriber> bays = new ArrayList<>();

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
        for (Subscriber b : bays)
        {
            b.update();
        }
    }

    /**
     * Checks which type of bay the plane needs to go to, then sends it there
     *
     * @param p the plane to be handled
     */
    public void handlePlane(Plane p)
    {
        System.out.println("************");
        System.out.println("\nPlane " + p.getPlaneID() + " has arrived at airport\n");
        notifySubscribers();
          
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
        System.out.println();
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
            System.out.println("\nNo loading bays available currently\n");
        }

        finishPlane(p);
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
     * adds a new loading bay to the end of the current chain
     *
     * @param b the bay to be added to the chain
     */
    public static void addBayToChain(Bay b)
    {
        bays.add(b);
        if (b instanceof LoadingBay)
        {       
            if(firstLoadingBay == null)
                firstLoadingBay = (LoadingBay)b;         
            else
                firstLoadingBay.addToChain(b);
        }
        else if (b instanceof ParkingBay)
        {     
            if(firstParkingBay == null)
                firstParkingBay = (ParkingBay)b;
            else
                firstParkingBay.addToChain(b);
        }   
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

    private static void finishPlane(Plane p)
    {
        System.out.println("Plane " + p.getPlaneID() + " moves to " + Runway.getInstance().getName());
        Runway.addPlane(p);

        p.setLoadingBay(null);
        p.setParkingBay(null);
    }

}
