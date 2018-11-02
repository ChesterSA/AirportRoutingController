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
public class Runway
{
    private static ArrayList<Plane> planes = new ArrayList<>();
    
    public static void addPlane(Plane p)
    {
        planes.add(p);
    }
}
