/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

import airportroutingcontroller.Plane;
import java.util.ArrayList;

/**
 *
 * @author s6089488
 */
public class Runway extends Location
{
    private static ArrayList<Plane> planes = new ArrayList<>();
    private static Runway instance;
    
    private Runway()
    {
        name = "Runway";
    }

    static public Runway getInstance()
    {
        if (instance == null)
        {
            instance = new Runway();
        }
        return instance;
    }
    
    public static void addPlane(Plane p)
    {
        planes.add(p);
    }
    
    
}
