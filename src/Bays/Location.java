/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bays;

/**
 * The location object that all other locations extend
 * @author Chester Swann-Auger
 */
public abstract class Location
{
    /**
     * the name of the location, used for identification
     */
    String name;

    /**
     * getter for the name object
     * @return the name string
     */
    public String getName()
    {
        return name;
    }
    
}
