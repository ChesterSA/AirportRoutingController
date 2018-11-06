/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import airportroutingcontroller.Plane;
import java.util.ArrayList;

/**
 * Runway, used as final space for planes
 * In full implementation would then set them to fly
 * 
 * @author Chester Swann-Auger
 * @since 02/11/18
 */
public class Runway extends Location
{
    /**
     * the list of planes currently at the runway
     */
    private static ArrayList<Plane> planes = new ArrayList<>();
    
    /**
     * instance object to work with the singleton pattern
     */
    private static Runway instance;
    
    /**
     * constructor for the runway class, private so singleton works
     */
    private Runway()
    {
        name = "Runway";
    }

    /**
     * getInstance object, returns the Runway object, used for singleton
     * @return the instance of Runway
     */
    static public Runway getInstance()
    {
        if (instance == null)
        {
            instance = new Runway();
        }
        return instance;
    }
    
    /**
     * adds a plane to the planes list
     * 
     * @param p the plane to add
     */
    public static void addPlane(Plane p)
    {
        planes.add(p);
        listPlanes();
    }
    
    /**
     * outputs a list of all planes to the std out
     */
    public static void listPlanes()
    {
        String s = "Planes ";
        
        for (Plane p : planes)
        {
            s += p.getPlaneID() + ", ";
        }
        
        //removes final comma
        s = s.substring(0, s.length()-2);
        
        s += " are at the runway\n\n";
        
        System.out.println(s);
    }
    
    
}
