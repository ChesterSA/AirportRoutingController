/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import Enums.VehicleSize;
import airportroutingcontroller.AirportRoutingController;
import airportroutingcontroller.BayChainable;
import airportroutingcontroller.DeliveryVehicles;
import airportroutingcontroller.Plane;
import airportroutingcontroller.Subscriber;

/**
 * Bay, supertype for ParkingBay and LoadingBay, extends Location
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public abstract class Bay extends Location implements Subscriber, BayChainable
{

    /**
     * integer to identify the bay
     */
    protected int bayID;

    /**
     * the plane that's currently at the bay
     */
    protected Plane plane;

    /**
     * the DeliveryVehicles class that manages selecting vehicles for the bay
     */
    protected DeliveryVehicles manager;

    /**
     * the size of plane and vehicle that the bay can use
     */
    protected VehicleSize size;

    /**
     * the next bay in the chain, used for Chain of Responsibility pattern
     */
    protected BayChainable next;

    /**
     * Constructor for the class
     *
     * @param bayID the bay ID to be used
     * @param size which size vehicles the bay can manage
     */
    public Bay(int bayID, VehicleSize size)
    {
        this.bayID = bayID;
        this.size = size;
        this.manager = DeliveryVehicles.getInstance();
        
        AirportRoutingController.addBayToChain(this);
    }

    /**
     * call all vehicles that are required by the bay to drive to the bay
     */
    public abstract void getVehicles();

    /**
     * getter for plane
     *
     * @return the current plane object
     */
    public Plane getPlane()
    {
        return plane;
    }

    /**
     * setter for plane
     *
     * @param plane the plane object for the Bay to handle
     */
    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    /**
     * handle method for Chain of Responsibility 
     * checks bay size and that no plane is at bay
     *
     * @param p the plane object to handle
     * @return a bay which can handle the plane, or null if none available
     */
    @Override
    public Bay handle(Plane p)
    {
        if (this.size.ordinal() >= p.getSize().ordinal()
                && plane == null)
        {
            System.out.println(getName() +  " is available");
            return this;
        }
        else if (next != null)
        {   
            return next.handle(p);
        }
        else
        {
            return null;
        }

    }

    /**
     * move the current plane to a different loading bay
     * @param lb the loading bay for the plane to move to
     */
    public void movePlaneToLoading(LoadingBay lb)
    {
        if (lb.size.ordinal() >= plane.getSize().ordinal()
                && lb.plane == null)
        {
            plane.setParkingBay(null);
            plane.setLoadingBay(lb);

            lb.plane = plane;
            plane = null;
        }
    }

    /**
     * moves the current plane to a different parking bay
     * @param pb the parking bay for the plane to move to
     */
    public void movePlanetoParking(ParkingBay pb)
    {
        if (pb.size.ordinal() >= plane.getSize().ordinal()
                && pb.plane == null)
        {
            plane.setLoadingBay(null);
            plane.setParkingBay(pb);

            pb.plane = plane;
            plane = null;
        }
    }
    
    /**
     * adds a bay to the next object, continues the chain
     * @param b the BayChainable object to add
     */
    @Override
    public void addNext(BayChainable b)
    {
        next = b;
    }
    
    /**
     * getter for bayID
     * @return the bayID
     */
    public int getBayID()
    {
        return bayID;
    }
    
    /**
     * Once a plane is in the bay, handles making sure the correct vehicles arrive and work
     */
    public abstract void initiate();
    
    
}
